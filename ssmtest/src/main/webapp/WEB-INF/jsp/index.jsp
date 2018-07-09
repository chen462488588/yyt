<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="${pageContext.request.contextPath}/">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Dashboard Template for Bootstrap</title>
<link href="/static/js/boostrap/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
 <script src="static/js/ie-emulation-modes-warning.js"></script>
<link href="/static/css/dashboard.css" rel="stylesheet">
<script src="/static/js/jquery.min.js"></script>
<script src="/static/js/boostrap/js/bootstrap.min.js"></script>

</head>

<body  > 

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid" >
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">烁晋自动化有限公司后台管理系统</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<!-- <form class="navbar-form navbar-right" action="brandInfo/getByName" method="get">
					<input type="text" class="form-control" placeholder="Search..." name="brandName" value="a">
					<input type="submit" value="搜索">
				</form> -->
			</div>
		</div>
	</nav>

	<div class="container-fluid" >
		<div class="row" >
			<!--  左侧的-->
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="javascript:void(0);"
						url="page/home" class="iframeTarget">首页</a></li>
					<li><a href="javascript:void(0);"
						url="brandInfo/getBrandInfoList/1" class="iframeTarget">供应商信息管理</a></li>
					<li><a href="javascript:void(0);"
						url="page/templateManage" class="iframeTarget">模板管理</a></li>

				</ul>
			</div>
			<!--  右侧部分-->
			 <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row placeholders">
					<iframe id="iframe"
						style="border: 0; width: 100%; height: 100%; background-color: #FFF;"
						frameborder="0"  scrolling="auto" >
					 </iframe>
				</div>
			</div> 
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			$(".iframeTarget").click(function() {
				var url = $(this).attr("url");
				$("#iframe").attr("src", url);
				$("#iframe").height($(window).height());
			});
		})
	</script>


</body>
</html>
