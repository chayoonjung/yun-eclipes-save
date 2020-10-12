<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Table Template</title>
	
	<!-- Google Font: Source Sans Pro -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="/dashboard2-web/plugins/fontawesome-free/css/all.min.css">
	  <!-- DataTables -->
  <link rel="stylesheet" href="/dashboard2-web/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="/dashboard2-web/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="/dashboard2-web/dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">

<div class="wrapper">

	<jsp:include page="/WEB-INF/views/modules/header.jsp" /> <!-- 페이지에 고정된 이미지 -->
	

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>DataTables</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">DataTables</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header" style="background-color: #e3f2fd;">
                <h3 class="card-title">상권-시군구/행정동 총 인구수</h3>
                <div class="card-tools">
                  <button type="button" class="btn btn-tool" data-card-widget="collapse">
                    <i class="fas fa-minus"></i>
                  </button>
                  <button type="button" class="btn btn-tool" data-card-widget="remove">
                    <i class="fas fa-times"></i>
                  </button>
                </div>
              </div>
              <!-- /.card-header -->
              <div id="total-people"  class="card-body">
                <table class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>연도/분기</th>
					<th>시군구</th>
					<th>상권 코드 명</th>
					<th>행정동</th>
					<th>총 유동인구수</th>
					<th>총 상주인구수</th>
					<th>총 직장인구수</th>
                  </tr>
                  </thead>
                  <tbody>
                  </tbody>

                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->

            <div class="card">
              <div class="card-header" style="background-color: #e3f2fd;">
                <h3 class="card-title">상권배후지-시군구/행정동 총 인구수</h3>
                <div class="card-tools">
                  <button type="button" class="btn btn-tool" data-card-widget="collapse">
                    <i class="fas fa-minus"></i>
                  </button>
                  <button type="button" class="btn btn-tool" data-card-widget="remove">
                    <i class="fas fa-times"></i>
                  </button>
                  
                </div>
                
              </div>
              <!-- /.card-header -->
              <div id="hl-total-people" class="card-body">
                <table class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>연도/분기</th>
					<th>시군구</th>
					<th>상권 코드 명</th>
					<th>행정동</th>
					<th>총 유동인구수</th>
					<th>총 상주인구수</th>
					<th>총 직장인구수</th>
                  </tr>
                  </thead>
                  <tbody>
                  </tbody>
                  
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  </div>
  <!-- /.content-wrapper -->
  
<!-- /.content-wrapper -->
	    	
	<jsp:include page="/WEB-INF/views/modules/footer.jsp" />


<!-- ./wrapper -->

<!-- jQuery -->
<script src="/dashboard2-web/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/dashboard2-web/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="/dashboard2-web/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/dashboard2-web/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="/dashboard2-web/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="/dashboard2-web/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<!-- AdminLTE App -->
<script src="/dashboard2-web/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/dashboard2-web/dist/js/demo.js"></script>

<script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true,
      "autoWidth": false,
    });
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });
</script>

<script type="text/javascript">
$(function() {

		
		//주소에서 반환한 html을 iris-container에 삽입
		$('#total-people').load('/dashboard2-web/cyj/pop', function() {
			$('#example2').DataTable({
			      "responsive": true,
			      "autoWidth": false,
			    });
		});
		
	});
	
$(function() {

	
	//주소에서 반환한 html을 iris-container에 삽입
	$('#hl-total-people').load('/dashboard2-web/cyj/hl-pop', function() {
		$('#example2').DataTable({
		      "responsive": true,
		      "autoWidth": false,
		    });
	});
	
});
	

</script>

</body>
</html>