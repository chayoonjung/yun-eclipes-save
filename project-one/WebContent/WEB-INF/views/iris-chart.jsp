<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Chart Template</title>
	
	<!-- Google Font: Source Sans Pro -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="/dashboard-web/plugins/fontawesome-free/css/all.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="/dashboard-web/dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini layout-fixed">

<div class="wrapper">

	<jsp:include page="/WEB-INF/views/modules/header.jsp" />
	
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-12">
						<h1>아이리스 차트</h1>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
		</section>
	
		<!-- Main content -->
		<section class="content">
			<div class="container-fluid">
				<div class="row">
					
					<div class="col-md-12">   <!-- md-4 : 1/4  md-6 : /112   -->
						
	
						<!-- BAR CHART -->
						<div class="card card-success">
							<div class="card-header">
								<h3 class="card-title">Iris Chart</h3>
	
								<div class="card-tools">
									<button type="button" class="btn btn-tool"
										data-card-widget="collapse">
										<i class="fas fa-minus"></i>
									</button>
									<button type="button" class="btn btn-tool"
										data-card-widget="remove">
										<i class="fas fa-times"></i>
									</button>
								</div>
							</div>
							<div class="card-body">
								<div class="chart">
									<canvas id="barChart"
										style="min-height: 250px; height: 250px; max-height: 250px; max-width: 100%;"></canvas>
								</div>
							</div>
							<!-- /.card-body -->
						</div>
						<!-- /.card -->
	
						
	
					</div>
					<!-- /.col (RIGHT) -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	    	
	<jsp:include page="/WEB-INF/views/modules/footer.jsp" />

</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="/dashboard-web/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/dashboard-web/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="/dashboard-web/plugins/chart.js/Chart.min.js"></script>
<!-- AdminLTE App -->
<script src="/dashboard-web/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/dashboard-web/dist/js/demo.js"></script>
<!-- Page specific script -->
<script>
  $(function () {
    /* ChartJS
     * -------
     * Here we will create a few charts using ChartJS
     */

    //--------------
    //- AREA CHART -
    //--------------

   $.ajax({
    	"url": "/dashboard-web/iris-chart-data",   //데이터 요청하는 서블릿 만들어야 함.
    	"method": "get",
    	"data": "type=area",
    	"dataType": "json",
    	"success": function(data, status, xhr) {
    
		    var areaChartData = {
		      labels  : data.labels,
		      datasets: [
		        {
		          label               : 'Digital Goods',
		          backgroundColor     : 'rgba(60,141,188,0.9)',
		          borderColor         : 'rgba(60,141,188,0.8)',
		          pointRadius          : false,
		          pointColor          : '#3b8bba',
		          pointStrokeColor    : 'rgba(60,141,188,1)',
		          pointHighlightFill  : '#fff',
		          pointHighlightStroke: 'rgba(60,141,188,1)',
		          data                : data.datasets[0]
		        },
		       
		      ]
		    }

		
		    //-------------
		    //- BAR CHART -
		    //-------------
		    var barChartCanvas = $('#barChart').get(0).getContext('2d')
		    var barChartData = $.extend(true, {}, areaChartData)
		    var temp0 = areaChartData.datasets[0]
		    //var temp1 = areaChartData.datasets[1]
		    barChartData.datasets[0] = temp0
		    //barChartData.datasets[1] = temp1
		
		    var barChartOptions = {
		      responsive              : true,
		      maintainAspectRatio     : false,
		      datasetFill             : false
		    }
		
		    var barChart = new Chart(barChartCanvas, {
		      type: 'bar',
		      data: barChartData,
		      options: barChartOptions
		    })
		    	},
		    	"error": function(xhr, status, err) {
		    		console.log(err.message);
		    	}
		   });
 
  })
</script>
</body>
</html>