
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="t" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
if(request.getSession().getAttribute("idLogin") != null){
    response.sendRedirect("index.jsp");
}
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="">

    <title>Iniciar Sesión</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./css/login.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

    <div class="container">

        <form class="form-signin" action="./ValidarLogin" data-toggle="validator" method="post">
            <h2 class="form-signin-heading">Iniciar Sesión</h2>
            <input name="usuario" type="text" class="form-control" placeholder="Usuario" required autofocus>
            <input name="clave" type="password" class="form-control" placeholder="Contraseña" required>
            <p class="text-center text-danger">
            <%
            if(request.getSession().getAttribute("msgErr") != null)
            	out.print(request.getSession().getAttribute("msgErr"));
            	request.getSession().setAttribute("msgErr", null);
            %>
            </p>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar Sesión</button>
        </form>

    </div>
    <!-- /container -->

	<script src="js/jquery.min.js"></script>
    <script src="js/validator.js"></script>
</body>

</html>