<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">
<base href="${pageContext.request.contextPath}/">
<title>登录</title>

<!-- Bootstrap core CSS -->
<link href="static/js/boostrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="static/css/signin.css" rel="stylesheet">
<script src="static/js/boostrap/js/bootstrap.js"></script>
</head>

<body class="text-center">
	<form class="form-inline">
	  <div class="form-group">
	    <label for="exampleInputName2">电话</label>
	    <input type="text" class="form-control" id="exampleInputName2" placeholder="xxx" value="${brandInfo.tel }">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail2">品牌</label>
	    <input type="text" class="form-control" id="exampleInputEmail2" placeholder="xxx" value="${brandInfo.brandName }">
	  </div><br/>
	  <button type="submit" class="btn btn-default">确认修改</button>
	</form>
</body>
</html>
