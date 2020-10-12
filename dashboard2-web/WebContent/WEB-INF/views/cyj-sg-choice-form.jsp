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
	<link rel="stylesheet" href="/dashboard-web/plugins/fontawesome-free/css/all.min.css">
	 <!-- DataTables -->
  <link rel="stylesheet" href="/dashboard-web/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="/dashboard-web/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="/dashboard-web/dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">

<div class="wrapper">

	<jsp:include page="/WEB-INF/views/modules/header.jsp" />
	
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-12">
            <h1>General Form</h1>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">

          <div class="col-md-12">
          
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Quick Example</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form id="input-form">
                <div class="card-body">
                  <div class="form-group">
                  <label for="gu">자치구</label>
                    <select id="gu" name="gu" class="form-control">
                          <option>강남구</option>
                          <option>강서구</option>
                          <option>강북구</option>
                          <option>강서구</option>
                          <option>관악구</option>
                          <option>광진구</option>
                          <option>구로구</option>
                          <option>금천구</option>
                          <option>노원구</option>
                          <option>도봉구</option>
                          <option>동대문구</option>
                          <option>동작구</option>
                          <option>마포구</option>
                          <option>서대문구</option>
                          <option>서초구</option>
                          <option>성동구</option>
                          <option>성북구</option>
                          <option>송파구</option>
                          <option>양천구</option>
                          <option>영등포구</option>
                          <option>용산구</option>
                          <option>은평구</option>
                          <option>종로구</option>
                          <option>중구</option>
                          <option>중랑구</option>
                        </select>
                  </div>
                  <div class="form-group">
                  <label for="service_category">서비스 업종</label>
                    <select id="service_category" name="service_category" class="form-control">
                          <option>PC방</option>
                          <option>가구</option>
                          <option>가방</option>
                          <option>가전제품</option>
                          <option>가전제품 수리</option>
                          <option>고시원</option>
                          <option>골프연습장</option>
                          <option>기타법무서비스</option>
                          <option>네일숍</option>
                          <option>노래방</option>
                          <option>당구장</option>
                          <option>동물병원</option>
                          <option>문구</option>
                          <option>미곡판매</option>
                          <option>미용실</option>
                          <option>반찬가게</option>
                          <option>법무사사무소</option>
                          <option>변리사사무소</option>
                          <option>변호사사무소</option>
                          <option>볼링장</option>
                          <option>부동상중개업</option>
                          <option>분식전문점</option>
                          <option>서적</option>
                          <option>섬유제품</option>
                          <option>세무사사무소</option>
                          <option>세탁소</option>
                          <option>수산물판매</option>
                          <option>슈퍼마켓</option>
                          <option>스포츠강습</option>
                          <option>스포츠클럽</option>
                          <option>시계 및 귀금속</option>
                          <option>신발</option>
                          <option>안경</option>
                          <option>애완동물</option>
                          <option>양식음식점</option>
                          <option>여관</option>
                          <option>예술학원</option>
                          <option>완구</option>
                          <option>외국어학원</option>
                          <option>운동/경기용품</option>
                          <option>유아의류</option>
                          <option>육류판매</option>
                          <option>의료기기</option>
                          <option>의약품</option>
                          <option>인테리어</option>
                          <option>일반교습학원</option>
                          <option>일반의류</option>
                          <option>일반의원</option>
                          <option>일식음식점</option>
                          <option>자동차미용</option>
                          <option>자동차수리</option>
                          <option>자전거 및 기타운송장비</option>
                          <option>전자상거래업</option>
                          <option>제과점</option>
                          <option>조명용품</option>
                          <option>주류도매</option>
                          <option>중식음식점</option>
                          <option>철물점</option>
                          <option>청과상</option>
                          <option>치과의원</option>
                          <option>치킨전문점</option>
                          <option>커피-음료</option>
                          <option>컴퓨터및주변장치판매</option>
                          <option>컴퓨터학원</option>
                          <option>패스트푸드점</option>
                          <option>편의점</option>
                          <option>피부관리실</option>
                          <option>한복점</option>
                          <option>한식음식점</option>
                          <option>한의원</option>
                          <option>핸드폰</option>
                          <option>호프-간이주점</option>
                          <option>화장품</option>
                          <option>화초</option>
                          <option>회계사사무소</option>
                          
                        </select>
                  </div>
                  <div class="form-group">
                    <label for="store_count">점포수</label>
                    <input type="text" class="form-control" id="store_count" name="store_count">
                  </div>
                  </div>                  
                <!-- /.card-body -->

                <div class="card-footer">
                  <button id="sg-search" type="button" class="btn btn-primary">search</button>
                </div>
              </form>
            </div>
            
          </div>
          
        </div>
        <!-- /.row -->
        <div class="row">
          <div class="col-md-12">
            <div class="card card-default">
              <div class="card-header">
                <h3 class="card-title">
                  <i  class="fas fa-exclamation-triangle"></i>
                  	확인 결과
                </h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
              <!--
                <div class="alert alert-danger alert-dismissible">
                  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                  <h5><i class="icon fas fa-ban"></i> Alert!</h5>
                  Danger alert preview. This alert is dismissable. A wonderful serenity has taken possession of my
                  entire
                  soul, like these sweet mornings of spring which I enjoy with my whole heart.
                </div>
                <div class="alert alert-info alert-dismissible">
                  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                  <h5><i class="icon fas fa-info"></i> Alert!</h5>
                  Info alert preview. This alert is dismissable.
                </div>
                <div class="alert alert-warning alert-dismissible">
                  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                  <h5><i class="icon fas fa-exclamation-triangle"></i> Alert!</h5>
                  Warning alert preview. This alert is dismissable.
                </div>
                -->
                <div class="alert alert-success alert-dismissible">
                  <h5><i class="icon fas fa-check"></i> <span id="result-title">&nbsp;</span></h5>
                  <span id="result-message">&nbsp;</span>
                </div>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->

        </div>
              
        <div class="card">
              <div class="card-header" style="background-color: #e3f2fd;">
                <h3 class="card-title">서비스 업종 매출금액</h3>
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
              <div id="sg-stroe-sales" class="card-body">
                <table class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>연도/분기</th>
                      <th>상권 구분</th>
                      <th>자치구</th>
                      <th>행정동</th>
                      <th>서비스업종</th>
                      <th>당월 매출금액</th>
                      <th>여성 매출금액</th>
                      <th>남성 매출금액</th>
                      <th>점포수</th>
                      <th>프랜차이즈 점포수</th>
                  </tr>
                  </thead>
                  <tbody>
                  </tbody>
                  
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
      </div><!-- /.container-fluid -->
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
<!-- DataTables -->
<script src="/dashboard-web/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/dashboard-web/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="/dashboard-web/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="/dashboard-web/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<!-- AdminLTE App -->
<script src="/dashboard-web/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/dashboard-web/dist/js/demo.js"></script>
<script type="text/javascript">
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
  
$(function() {
	$('#sg-search').on('click', function(event) {
		event.preventDefault();
		event.stopPropagation();
		
		var input_data = $('#input-form').serialize();
		//alert(input_data);
		
							
		$.ajax({
			"url": "/dashboard2-web/cyj/sg-choice2",
			"method": "GET",
			"data": input_data,
			//"dataType": "json",
			"success": function(data, status, xhr) {
				$('#result-title').text(data);
				$('#result-message').text(data);
			}, 
			"error": function(xhr, status, err) {
				console.log(err);
			}
		});
		
		
 		$('#sg-stroe-sales').load("/dashboard2-web/cyj/sg-choice?" + input_data)
		
	});
});
</script>
</body>
</html>