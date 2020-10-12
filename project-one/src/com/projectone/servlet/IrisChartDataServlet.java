package com.projectone.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projectone.vo.IrisVO;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

@WebServlet(urlPatterns = { "/iris-chart-data" })
public class IrisChartDataServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		AreaChartData areaChartData = loadAreaChartData();   //서버에서 가져와야 한다. 서버 API 입력 할것.
		
		
		Gson gson = new Gson();
		String json = null;
		
		String path = "http://127.0.0.1:5000/demo/iris-list?species=";
			
			// 자바 프로그램에서 다른 서버에 요청을 보내고 응답을 수신하는 도구
			URL url = new URL(path);		
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			
			String result = "";
			
			int status = conn.getResponseCode();
			if (status == 200) {
				// 네트워크를 통해 수신된 데이터를 읽는 도구 ( IO 객체 )
				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				
				JsonReader reader = new JsonReader(isr);
				
				IrisVO[] irisList = gson.fromJson(reader, IrisVO[].class);
				
				double t1 = 0, t2 = 0, t3 = 0, t4 = 0;
				
				for (int i=0; i< irisList.length; i++) {
					IrisVO iris =  irisList[i];
					t1 += iris.getSepalWidth();
					t2 += iris.getSepalLength();
					t3 += iris.getPetalWidth();
					t4 += iris.getPetalLength();
					
				}
				
						
				AreaChartData areaChartData = new AreaChartData();
				areaChartData.setLabels(new String[] {"SW", "SL", "PW", "PL"});
				areaChartData.append( new Double[] {t1/irisList.length, t2/irisList.length, t3/irisList.length, t4/irisList.length} );
			
				json = gson.toJson(areaChartData);
				
				PrintWriter out = resp.getWriter();
				out.println(json);
				
				
			} else {
				result = String.format("%d 오류가 발생했습니다.", status);
			}
			
			conn.disconnect();
		

		
	}	
	
	class AreaChartData {
		String[] labels;
		ArrayList<Object[]> datasets = new ArrayList<>();
		
		public AreaChartData() {}
		
		public AreaChartData(String[] labels, ArrayList<Object[]> datasets) {
			this.labels = labels;
			this.datasets = datasets;
		}
		
		public String[] getLabels() {
			return labels;
		}
		public void setLabels(String[] labels) {
			this.labels = labels;
		}
		public List<Object[]> getDatasets() {
			return datasets;
		}
		public void setDatasets(ArrayList<Object[]> datasets) {
			this.datasets = datasets;
		}
		public void append(Object[] data) {
			datasets.add(data);
		}
	}
}
	

