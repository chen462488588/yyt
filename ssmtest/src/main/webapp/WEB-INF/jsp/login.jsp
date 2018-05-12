<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">
	<base href="${pageContext.request.contextPath}/">
    <title>登录</title>

    <!-- Bootstrap core CSS -->
    <link href="static/js/boostrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="static/css/signin.css" rel="stylesheet">
  </head>

  <body class="text-center">
    <form class="form-signin" action="login/checkIsExist" method="post">
   	  <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">登录</h1>
      <label for="inputEmail" class="sr-only">用户名</label>
      <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus >
      <label for="inputPassword" class="sr-only">密码</label>
      <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> 记住密码
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">登入</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2018-2020</p>
    </form>
  </body>
</html>
