<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
									</div>
									<!--end col-->
								</div>
								<!--end row-->
							</div>
							<!--end card-header-->
							<div class="card-body">
								<div class="row">
									<div class="col-12 col-md mb-2 mb-lg-0">
<textarea rows="10" cols="12">게시글 작성</textarea>
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
<textarea rows="10" cols="12">댓글 목록</textarea>
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
<textarea rows="10" cols="12">댓글 작성</textarea>
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

</body>
<!--end body-->

</html>