<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="mx.rengifo.evaluacion.util.Constante"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <style type="text/css">
            body {
                background: url("${pageContext.request.contextPath}/images/background-<% out.print(Constante.BACKGROUND); %>.jpg");
            }


</style>
   <script src="script.js"></script>
   <title><% out.println(Constante.TITLE_GRAL); %></title>
</head>
<body>

<div id='cssmenu'>
<ul>
   <li class=''><a href='inicio'><span>Inicio</span></a></li>
   <li><a href='login'><span>Entrar</span></a></li>
   <li><a href='register'><span>Registrar</span></a></li>
</ul>
</div>

<div style="position:absolute;left:350px;top:200px">
<h3>Felicitaciones ${requestScope.newUser} tu cuenta ha sido creada correctamente, <a href="${pageContext.request.contextPath}/login">entra</a> para tomar la evaluación en línea.</h3>
</div>


</body>
</html>
