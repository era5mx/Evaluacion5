<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="mx.rengifo.evaluacion.util.Constante"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
<title><% out.println(Constante.TITLE_GRAL); %></title>
<style type="text/css">
            body {
                background: url("${pageContext.request.contextPath}/images/background-<% out.print(Constante.BACKGROUND); %>.jpg");
            }
</style>
</head>
<body>
<div id='cssmenu'>
<ul>
   <li class=''><a href='${pageContext.request.contextPath}/inicio'><span>Inicio</span></a></li>
   <li><a href='${pageContext.request.contextPath}/login'><span>Entrar</span></a></li>
   <li><a href='${pageContext.request.contextPath}/register'><span>Registrar</span></a></li>
</ul>
</div>
<br><br><br>
<h2 align="center">Instrucciones para la Evaluación en línea para ${sessionScope.exam} : </h2>

<div style="position:absolute;left:500px;top:170px">
<ul style="list-style-type:disc">
 <li>La evaluación consta de 10 preguntas.</li>
 <li>El tiempo total de la evaluación es de 10 minutos</li>
 <li>Puedes terminar la evaluación en cualquier momento.</li>
 <li>Lee las preguntas cuidadosamente antes de responder.</li>
 <li>Puedes cambiar tu respuesta antes de enviarla.</li>
 <li>Buena suerte para la evaluación.</li>
</ul>  
<br><br><br>
</div>

<div  style="position:absolute;left:600px;top:350px">
<button onclick="location.href='${pageContext.request.contextPath}/exam'">Iniciar Evaluación</button>
</div>


</body>
</html>