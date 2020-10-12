package com.dashboardweb.servlet;

import java.io.BufferedReader;
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

import com.dashboardweb.vo.CyjSalesVO;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

@WebServlet(urlPatterns = { "/cyj/sales-chart-data" })
public class CyjSalesChartDataServlet extends HttpServlet {

	class AreaChartData {
		String[] labels;
		ArrayList<Object[]> datasets = new ArrayList<>();

		public AreaChartData() {
		}

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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = "http://127.0.0.1:5000/cyj/sg-sales";

		// 자바 프로그램에서 다른 서버에 요청을 보내고 응답을 수신하는 도구
		URL url = new URL(path); // 경로 지정

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		int status = conn.getResponseCode();
		if (status == 200) { // 네트워크를 통해 수신된 데이터를 읽는 도구 (IO 객체)
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			JsonReader reader = new JsonReader(isr);
			Gson gson = new Gson(); //
			CyjSalesVO[] salseList = gson.fromJson(reader, CyjSalesVO[].class); //

			String[] labels = new String[salseList.length / 2];
			Long[] t1 = new Long[salseList.length / 2];
			Long[] t2 = new Long[salseList.length / 2];
			for (int i = 0, j = 0; i < salseList.length; i += 2, j++) {
				labels[j] = salseList[i].getGuName();
				t1[j] = salseList[i].getMonthSales() / 1000000000 ;
				t2[j] = salseList[i + 1].getMonthSales() / 1000000000;
			}

			AreaChartData areaChartData = new AreaChartData();
			areaChartData.setLabels(labels);
			areaChartData.append(t1);
			areaChartData.append(t2);

			conn.disconnect();

			String json = null;

			json = gson.toJson(areaChartData);

			resp.setContentType("text/json;charset=utf-8");
			
			PrintWriter out = resp.getWriter();
			out.println(json);

		}
	}

}
