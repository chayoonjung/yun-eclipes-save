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
	<link rel="stylesheet" href="/dashboard2-web/plugins/fontawesome-free/css/all.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="/dashboard2-web/dist/css/adminlte.min.css">
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
						<h1>ChartJS</h1>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
		</section>
	
		<!-- Main content -->
		<section class="content">
			<div class="container-fluid">
				<div class="row">
				<!-- left 라인 지음 -->
					<div class="col-md-12">
						<!-- BAR CHART -->
						<div class="card card-success">
							<div class="card-header">
								<h3 class="card-title">구별 매출금액 (십억)</h3>
	
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
				
				<div class="row">
					<div class="col-md-6">
												<!-- LINE CHART -->
						<div class="card card-info">
							<div class="card-header">
								<h3 class="card-title">1분기 성별 매출 비율</h3>
								
								
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
									<canvas id="sales-ratio-1"
										style="min-height: 250px; height: 250px; max-height: 250px; max-width: 100%;"></canvas>
								</div>
							</div>
							<!-- /.card-body -->
						</div>
						<!-- /.card -->
					</div>
					<div class="col-md-6">
											<!-- LINE CHART -->
						<div class="card card-info">
							<div class="card-header">
								<h3 class="card-title">2분기 성별 매출 비율</h3>
								
								
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
									<canvas id="sales-ratio-2"
										style="min-height: 250px; height: 250px; max-height: 250px; max-width: 100%;"></canvas>
								</div>
							</div>
							<!-- /.card-body -->
						</div>
						<!-- /.card -->
					</div>
				</div>
				
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
<script src="/dashboard2-web/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/dashboard2-web/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="/dashboard2-web/plugins/chart.js/Chart.min.js"></script>
<!-- AdminLTE App -->
<script src="/dashboard2-web/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/dashboard2-web/dist/js/demo.js"></script>
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
    	"url": "/dashboard2-web/cyj/sales-chart-data",
    	"method": "get",
    	"data": "type=area",
    	"dataType": "json",
    	"success": function(data, status, xhr) {
    	    var areaChartData = {
 	    	      labels  : data.labels,
 	    	      datasets: [
 	    	        {
 	    	          label               : '2019년 1분기',
 	    	          backgroundColor     : 'rgba(60,141,188,0.9)',
 	    	          borderColor         : 'rgba(60,141,188,0.8)',
 	    	          pointRadius          : false,
 	    	          pointColor          : '#3b8bba',
 	    	          pointStrokeColor    : 'rgba(60,141,188,1)',
 	    	          pointHighlightFill  : '#fff',
 	    	          pointHighlightStroke: 'rgba(60,141,188,1)',
 	    	          data                : data.datasets[0]
 	    	        },
 	    	        {
 	    	          label               : '2019년 2분기',
 	    	          backgroundColor     : 'rgba(210, 214, 222, 1)',
 	    	          borderColor         : 'rgba(210, 214, 222, 1)',
 	    	          pointRadius         : false,
 	    	          pointColor          : 'rgba(210, 214, 222, 1)',
 	    	          pointStrokeColor    : '#c1c7d1',
 	    	          pointHighlightFill  : '#fff',
 	    	          pointHighlightStroke: 'rgba(220,220,220,1)',
 	    	          data                : data.datasets[1]
 	    	        },
 	    	      ]
 	    	    }

    	  //-------------
    	    //- BAR CHART -
    	    //-------------
    	    var barChartCanvas = $('#barChart').get(0).getContext('2d')
    	    var barChartData = $.extend(true, {}, areaChartData)
    	    var temp0 = areaChartData.datasets[0]
    	    var temp1 = areaChartData.datasets[1]
    	    barChartData.datasets[0] = temp0
    	    barChartData.datasets[1] = temp1

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

    
    ///////////////////////////////////////////////////////////////
//stackchart를 만들려면 barchart만들고 진행해야함.
    $.ajax({
    	"url": "/dashboard2-web/cyj/sales-sex-chart-data",
    	"method": "get",
    	"data": "type=area",
    	"dataType": "json",
    	"success": function(data, status, xhr) {
    	    var areaChartData = {
 	    	      labels  : data.labels,
 	    	      datasets: [
 	    	        {
 	    	          label               : '남성',
 	    	          backgroundColor     : 'rgba(60,141,188,0.9)',
 	    	          borderColor         : 'rgba(60,141,188,0.8)',
 	    	          pointRadius          : false,
 	    	          pointColor          : '#3b8bba',
 	    	          pointStrokeColor    : 'rgba(60,141,188,1)',
 	    	          pointHighlightFill  : '#fff',
 	    	          pointHighlightStroke: 'rgba(60,141,188,1)',
 	    	          data                : data.datasets[0]
 	    	        },
 	    	        {
 	    	          label               : '여성',
 	    	          backgroundColor     : 'rgba(210, 214, 222, 1)',
 	    	          borderColor         : 'rgba(210, 214, 222, 1)',
 	    	          pointRadius         : false,
 	    	          pointColor          : 'rgba(210, 214, 222, 1)',
 	    	          pointStrokeColor    : '#c1c7d1',
 	    	          pointHighlightFill  : '#fff',
 	    	          pointHighlightStroke: 'rgba(220,220,220,1)',
 	    	          data                : data.datasets[1]
 	    	        },
 	    	      ]
 	    	    }
    	  //---------------------
    	    //- STACKED BAR CHART -
    	    //---------------------
    	    var barChartData = $.extend(true, {}, areaChartData)
    	    var temp0 = areaChartData.datasets[0]
    	    var temp1 = areaChartData.datasets[1]
    	    barChartData.datasets[0] = temp0
    	    barChartData.datasets[1] = temp1
    	    
    	    var stackedBarChartCanvas = $('#sales-ratio-1').get(0).getContext('2d')
    	    var stackedBarChartData = $.extend(true, {}, barChartData)

    	    var stackedBarChartOptions = {
    	      responsive              : true,
    	      maintainAspectRatio     : false,
    	      scales: {
    	        xAxes: [{
    	          stacked: true,
    	        }],
    	        yAxes: [{
    	          stacked: true
    	        }]
    	      }
    	    }

    	    var stackedBarChart = new Chart(stackedBarChartCanvas, {
    	      type: 'bar',
    	      data: stackedBarChartData,
    	      options: stackedBarChartOptions
    	    });
    	    
    	    ////////////////////////////
    	    
    	    var areaChartData2 = {
 	    	      labels  : data.labels,
 	    	      datasets: [
 	    	        {
 	    	          label               : '남성',
 	    	          backgroundColor     : 'rgba(60,141,188,0.9)',
 	    	          borderColor         : 'rgba(60,141,188,0.8)',
 	    	          pointRadius          : false,
 	    	          pointColor          : '#3b8bba',
 	    	          pointStrokeColor    : 'rgba(60,141,188,1)',
 	    	          pointHighlightFill  : '#fff',
 	    	          pointHighlightStroke: 'rgba(60,141,188,1)',
 	    	          data                : data.datasets[2]
 	    	        },
 	    	        {
 	    	          label               : '여성',
 	    	          backgroundColor     : 'rgba(210, 214, 222, 1)',
 	    	          borderColor         : 'rgba(210, 214, 222, 1)',
 	    	          pointRadius         : false,
 	    	          pointColor          : 'rgba(210, 214, 222, 1)',
 	    	          pointStrokeColor    : '#c1c7d1',
 	    	          pointHighlightFill  : '#fff',
 	    	          pointHighlightStroke: 'rgba(220,220,220,1)',
 	    	          data                : data.datasets[3]
 	    	        },
 	    	      ]
 	    	    }
    	  //---------------------
    	    //- STACKED BAR CHART -
    	    //---------------------
    	    var barChartData2 = $.extend(true, {}, areaChartData2)
    	    var temp02 = areaChartData2.datasets[0]
    	    var temp12 = areaChartData2.datasets[1]
    	    barChartData2.datasets[0] = temp02
    	    barChartData2.datasets[1] = temp12
    	    
    	    var stackedBarChartCanvas2 = $('#sales-ratio-2').get(0).getContext('2d')
    	    var stackedBarChartData2 = $.extend(true, {}, barChartData2)

    	    var stackedBarChartOptions2 = {
    	      responsive              : true,
    	      maintainAspectRatio     : false,
    	      scales: {
    	        xAxes: [{
    	          stacked: true,
    	        }],
    	        yAxes: [{
    	          stacked: true
    	        }]
    	      }
    	    }

    	    var stackedBarChart2 = new Chart(stackedBarChartCanvas2, {
    	      type: 'bar',
    	      data: stackedBarChartData2,
    	      options: stackedBarChartOptions2
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