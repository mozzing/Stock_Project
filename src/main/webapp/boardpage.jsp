<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
		<meta charset="utf-8" />
		<title>Stock Board</title>
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta content="Premium Multipurpose Admin & Dashboard Template"
			name="description" />
		<meta content="" name="author" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		
		<!-- App favicon -->
		<link rel="shortcut icon"
			href="/${pageContext.request.contextPath}/assets/images/favicon.ico">
		
		<!-- App css -->
		<link
			href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"
			rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/assets/css/icons.min.css"
			rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/assets/css/app.min.css"
			rel="stylesheet" type="text/css" />
</head>

<body id="body">
	<!-- leftbar-tab-menu -->
	<div class="leftbar-tab-menu">
		<div class="main-icon-menu">
			<a href="index.html" class="logo logo-metrica d-block text-center">
				<span> <img src="assets/images/logo-sm.png" alt="logo-small"
					class="logo-sm">
			</span>
			</a>
			<div class="main-icon-menu-body">
				<div class="position-reletive h-100" data-simplebar
					style="overflow-x: hidden;">
					<ul class="nav nav-tabs" role="tablist" id="tab-menu">
						<li class="nav-item" data-bs-toggle="tooltip"
							data-bs-placement="right" title="Dashboard"
							data-bs-trigger="hover"><a href="#MetricaDashboard"
							id="dashboard-tab" class="nav-link"> <i
								class="ti ti-smart-home menu-icon"></i>
						</a>
						<!--end nav-link--></li>
						<!--end nav-item-->
						<li class="nav-item" data-bs-toggle="tooltip"
							data-bs-placement="right" title="Apps" data-bs-trigger="hover">
							<a href="#MetricaApps" id="apps-tab" class="nav-link"> <i
								class="ti ti-apps menu-icon"></i>
						</a>
						<!--end nav-link-->
						</li>
						<!--end nav-item-->

						<li class="nav-item" data-bs-toggle="tooltip"
							data-bs-placement="right" title="Uikit" data-bs-trigger="hover">
							<a href="#MetricaUikit" id="uikit-tab" class="nav-link"> <i
								class="ti ti-planet menu-icon"></i>
						</a>
						<!--end nav-link-->
						</li>
						<!--end nav-item-->

						<li class="nav-item" data-bs-toggle="tooltip"
							data-bs-placement="right" title="Pages" data-bs-trigger="hover">
							<a href="#MetricaPages" id="pages-tab" class="nav-link"> <i
								class="ti ti-files menu-icon"></i>
						</a>
						<!--end nav-link-->
						</li>
						<!--end nav-item-->

						<li class="nav-item" data-bs-toggle="tooltip"
							data-bs-placement="right" title="Authentication"
							data-bs-trigger="hover"><a href="#MetricaAuthentication"
							id="authentication-tab" class="nav-link"> <i
								class="ti ti-shield-lock menu-icon"></i>
						</a>
						<!--end nav-link--></li>
						<!--end nav-item-->
					</ul>
					<!--end nav-->
				</div>
				<!--end /div-->
			</div>
			<!--end main-icon-menu-body-->
			
			<!--end pro-metrica-end-->
		</div>
		<!--end main-icon-menu-->

	</div>
	<!-- end leftbar-tab-menu-->
	<div class="page-wrapper">

		<!-- Page Content-->
		<div class="page-content-tab">

			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">
								<div class="row align-items-center">
									<div class="col">
<h4 class="card-title">증권 정보 출력</h4>
									</div>
									<!--end col-->
								</div>
								<!--end row-->
							</div>
							<!--end card-header-->
							<div class="card-body">
								<div class="row">
									<div class="col-12 col-md mb-2 mb-lg-0">
<textarea rows="10" cols="12">증권 차트 호출부분</textarea>
									</div>
									<!--end col-->
								</div>
								<!--end row-->
							</div>
							<!--end card-body-->
							
						</div>
						<!--end card-->
					</div>
					<!--end col-->
				</div>
				<!-- end row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">
								<div class="row align-items-center">
									<div class="col">
<h4 class="card-title">게시판 제목 </h4>
<form id="myForm">
	<input type="hidden" name="bseq" value="${MY_KEY_BVO.bseq}">
	<input type="hidden" name="pageGubun" id="pageGubun">
	<table class="datatable-table">
		<tbody>
			<tr>
				<th>글번호</th>
				<td>${MY_KEY_BVO.bseq}</td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td>${MY_KEY_BVO.useq}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${MY_KEY_BVO.boarddate}</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="  수정  " id="updateBtn"> 
					<input type="button" value="  삭제  " id="deleteBtn"> 
					<input type="button" value="  목록  " id="listBtn">
				</td>
			</tr>
		</tfoot>
	</table>
</form>
									</div>
									<!--end col-->
								</div>
								<!--end row-->
							</div>
							<!--end card-header-->
							<div class="card-body">
								<div class="row">
									<div class="col-12 col-md mb-2 mb-lg-0">
<h4 class="card-title">게시판 내용 </h4>
<form id="myForm">
	<input type="hidden" name="bseq" value="${MY_KEY_BVO.bseq}">
	<input type="hidden" name="pageGubun" id="pageGubun">
	<table class="datatable-table">
		<tbody>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" size="100" value="${MY_KEY_BVO.title}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents" rows="5" cols="100">${MY_KEY_BVO.boardcontents}</textarea></td>
			</tr>
		</tbody>
	</table>
</form>
									</div>
									<!--end col-->
								</div>
								<!--end row-->
							</div>
							<!--end card-body-->
							
						</div>
						<!--end card-->
					</div>
					<!--end col-->
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">
								<div class="row align-items-center">
									<div class="col">
<h4 class="card-title">댓글목록</h4>
									</div>
									<!--end col-->
								</div>
								<!--end row-->
							</div>
							<!--end card-header-->
							<div class="card-body">
								<div class="row">
									<div class="col-12 col-md mb-2 mb-lg-0">
<div id="resultDiv">
	<table style="width: 100%">
		<c:choose>
			<c:when test="${ fn:length(MY_KEY_RLIST) <= 0 }">
				해당 게시물의 댓글이 존재하지 않습니다
			</c:when>
			<c:otherwise>
				<c:forEach var="rvo" items="${MY_KEY_RLIST}">

					<tr>
						<td>
							<c:if test="${rvo.regid =='guest'}">
								<!-- 버튼 클래스 추가 ************************************************************************ -->
								<input type='button' value='삭제' data-gubun='RD001'
									data-bseq='${rvo.bseq}' data-rseq='${rvo.rseq}'
									class='restDeleteBtn'>
							</c:if>
						</td>
						<td>${rvo.reply}</td>
						<td>(${rvo.regid}, ${rvo.regdate})</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</div>
									</div>
									<!--end col-->
								</div>
								<!--end row-->
							</div>
							<!--end card-body-->
							
						</div>
						<!--end card-->
					</div>
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">
								<div class="row align-items-center">
									<div class="col">
<h4 class="card-title">댓글작성</h4>
									</div>
									<!--end col-->
								</div>
								<!--end row-->
							</div>
							<!--end card-header-->
							<div class="card-body">
								<div class="row">
									<div class="col-12 col-md mb-2 mb-lg-0">
<form name="replyForm" id="replyForm">
	<input type='hidden' name=pageGubun value="RI001"> 
	<input type="hidden" name="bseq" value="${MY_KEY_BVO.bseq}">
	<table style="width: 100%">
		<tr>
			<td>
				<input type="text" size="60" name="reply" id="reply">
				<input type='button' id="insertBtn" value='댓글저장'>
			<td>
		</tr>
	</table>
</form>
									</div>
									<!--end col-->
								</div>
								<!--end row-->
							</div>
							<!--end card-body-->
							
						</div>
						<!--end card-->
					</div>
				</div>
				<!-- end row -->
			</div>
			<!--end col-->

		</div>
		<!--end row-->

	</div>
	<!-- container -->

	<!--Start Rightbar-->
	<!--Start Rightbar/offcanvas-->
	<div class="offcanvas offcanvas-end" tabindex="-1" id="Appearance"
		aria-labelledby="AppearanceLabel">
		<div class="offcanvas-header border-bottom">
			<h5 class="m-0 font-14" id="AppearanceLabel">Appearance</h5>
			<button type="button"
				class="btn-close text-reset p-0 m-0 align-self-center"
				data-bs-dismiss="offcanvas" aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">
			<h6>Account Settings</h6>
			<div class="p-2 text-start mt-3">
				<div class="form-check form-switch mb-2">
					<input class="form-check-input" type="checkbox"
						id="settings-switch1"> <label class="form-check-label"
						for="settings-switch1">Auto updates</label>
				</div>
				<!--end form-switch-->
				<div class="form-check form-switch mb-2">
					<input class="form-check-input" type="checkbox"
						id="settings-switch2" checked> <label
						class="form-check-label" for="settings-switch2">Location
						Permission</label>
				</div>
				<!--end form-switch-->
				<div class="form-check form-switch">
					<input class="form-check-input" type="checkbox"
						id="settings-switch3"> <label class="form-check-label"
						for="settings-switch3">Show offline Contacts</label>
				</div>
				<!--end form-switch-->
			</div>
			<!--end /div-->
			<h6>General Settings</h6>
			<div class="p-2 text-start mt-3">
				<div class="form-check form-switch mb-2">
					<input class="form-check-input" type="checkbox"
						id="settings-switch4"> <label class="form-check-label"
						for="settings-switch4">Show me Online</label>
				</div>
				<!--end form-switch-->
				<div class="form-check form-switch mb-2">
					<input class="form-check-input" type="checkbox"
						id="settings-switch5" checked> <label
						class="form-check-label" for="settings-switch5">Status
						visible to all</label>
				</div>
				<!--end form-switch-->
				<div class="form-check form-switch">
					<input class="form-check-input" type="checkbox"
						id="settings-switch6"> <label class="form-check-label"
						for="settings-switch6">Notifications Popup</label>
				</div>
				<!--end form-switch-->
			</div>
			<!--end /div-->
		</div>
		<!--end offcanvas-body-->
	</div>
	<!--end Rightbar/offcanvas-->
	<!--end Rightbar-->

	
	</div>
	<!-- end page content -->
	</div>
	<!-- end page-wrapper -->

	<!-- Javascript  -->
	<!-- vendor js -->

	<script
		src="/${pageContext.request.contextPath}/assets/libs/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="/${pageContext.request.contextPath}/assets/libs/simplebar/simplebar.min.js"></script>
	<script
		src="/${pageContext.request.contextPath}/assets/libs/feather-icons/feather.min.js"></script>
	<script
		src="/${pageContext.request.contextPath}/assets/libs/apexcharts/apexcharts.min.js"></script>
	<script
		src="/${pageContext.request.contextPath}/assets/js/pages/crypto-index.init.js"></script>
	<!-- App js 
	<script src="/${pageContext.request.contextPath}/assets/js/app.js"></script> -->

<script>
	function My_make_reply_table(obj) {
		if(obj.status == "200") {
			$("#resultDiv").empty();
			htmlStr = "<table style=\"{width:100%}\">";
									
			$(obj.message).map(function(i, rvo) {
			htmlStr += "<tr>";
			htmlStr += "<td><input type='button' value='삭제'  data-gubun='RD001' data-bseq='"+rvo.bseq+"' data-rseq='"+rvo.rseq+"' class='restDeleteBtn'></td>";
			htmlStr += "<td>"+rvo.rseq+"</td>";
			htmlStr += "<td>"+rvo.reply+"</td>";
			htmlStr += "<td>"+rvo.regid+"</td>";
			htmlStr += "</tr>";
			});
			htmlStr += "</table>";
			$("#resultDiv").html(htmlStr);
		
		} else {
			$("#resultDiv").html("입력 중 에러발생 " + obj.message);	
		}
	}
			
	$( document ).ready(function() {
	
		//jQuery 동적이벤트 바인딩
		$(document).on('click',".restDeleteBtn",function(){
							
			// ****************************************************************************
			// data-* 속성 값 추출
			// ****************************************************************************
			console.log($(this).data());
			
			var pageGubun = $(this).data('gubun'); // data-gubun
			var bseq = $(this).data('bseq');           // data-bseq
			var rseq = $(this).data('rseq');           // data-rseq
			//console.log(pageGubun + "," + bseq + "," + rseq);
			
			// 방법1) 템플릿 리터럴로 Query String 생성
			var formDataStr1 = `pageGubun=${pageGubun}&bseq=${bseq}&rseq=${rseq}`;
			  
			// 방법2) URLSearchParams(). 사용해 Query String 생성
			var params = new URLSearchParams({ pageGubun, bseq, rseq });
			var formDataStr2 = params.toString();
			
			// 방법3) $.param(). 사용해 Query String 생성
			var tempObj = {
				pageGubun: pageGubun,
				bseq: bseq,
				rseq: rseq
			};
			var formDataStr3 = params.toString();  //$.param(tempObj);
			   
			console.log(formDataStr1);
			console.log(formDataStr2);
			console.log(formDataStr3);
						    
			// ****************************************************************************
						   
			$.ajax({
				url  		: "/myreply" ,
				method 		: 'POST' , 
				data 		: formDataStr3 , 	  //pageGubun=RD001&bseq=12&rseq=3		
				//contentType : "application/x-www-form-urlencoded; charset=UTF-8", 
				//dataType 	: "json", 	
				success 	: function(obj) { 
									My_make_reply_table(obj);
				  	  } ,
				error 		: function(err) { console.log("에러:" + err) }  
				});
		});
					
					
		$("#insertBtn").click( function() {  
			var formData = $("#replyForm").serialize();  //pageGubun=RI001&bseq=12&reply=댓글댓글
			console.log(formData);
			$.ajax({
				url  		: "/myreply" ,
				method 		: 'POST' , 
				data 		: formData , 			
				//contentType : "application/x-www-form-urlencoded; charset=UTF-8", 
				//dataType 	: "json", 	
				success 	: function(obj) { 
					My_make_reply_table(obj);
					$("#reply").val("");
					$("#reply").focus();
				} ,
				error 		: function(err) { console.log("에러:" + err) }  
			});
		});
			
					
					
		$("#updateBtn").click( function() {  
			$("#myForm").attr("method", "post");
			//$("#myForm").attr("action", "/myboard?pageGubun=U001");
			$("#myForm").attr("action", "/myboard");
			$("#pageGubun").val("U001");
			$("#myForm").submit();
		} );  
		
		/*
		$("#deleteBtn").click( function() {  
			$("#myForm").attr("method", "post");
			//$("#myForm").attr("action", "/myboard?pageGubun=D001");
			$("#myForm").attr("action", "/myboard");
			$("#pageGubun").val("D001");
			$("#myForm").submit();
		} );
		*/
					
					
		$("#listBtn").click( function() {  
			$("#myForm").attr("method", "get");
			$("#myForm").attr("action", "/myboard");
			$("#myForm").submit();
		});
					
				    
	});
</script>
</body>
<!--end body-->

</html>