<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="mx.rengifo.evaluacion.util.Constante"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
    <title>
        <% out.println(Constante.TITLE_GRAL); %> &middot; Entrar
    </title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <style type="text/css">
body {
	background: url("${pageContext.request.contextPath}/images/background-<% out.print(Constante.BACKGROUND); %>.jpg");
}
.user-icon {
	top:153px; /* Positioning fix for slide-in, got lazy to think up of simpler method. */
	background: rgba(65,72,72,0.75) url('${pageContext.request.contextPath}/images/icon/user-icon.png') no-repeat center;	
}

.pass-icon {
	top:201px;
	background: rgba(65,72,72,0.75) url('${pageContext.request.contextPath}/images/icon/pass-icon.png') no-repeat center;
}


    </style>
    <script src="${pageContext.request.contextPath}/js/onsubmit_event.js" type="text/javascript"></script>

</head>
<body>

<div id='cssmenu'>
<ul>
   <li class=''><a href='${pageContext.request.contextPath}/inicio'><span>Inicio</span></a></li>
   <li><a href='${pageContext.request.contextPath}/login'><span>Entrar</span></a></li>
   <li><a href='${pageContext.request.contextPath}/register'><span>Registrar</span></a></li>
</ul>
</div>

<div style="position:absolute;left:500px;top:90px">
No tienes una cuenta, pulsa aquí para <a href='${pageContext.request.contextPath}/register'>Registrar</a>
</div>

<div id="wrapper">

	<form name="login-form" class="login-form" action="checkLogin" method="post" onsubmit="return ValidationEventLogin()">
	
		<div class="header">
		<h1>Entrar </h1>
		<span></span>
		</div>
	
		<div class="content">
		<input id="username" name="username" type="text" class="input username" placeholder="Usuario" />
		<div class="user-icon"></div>
		<input id="password" name="password" type="password" class="input password" placeholder="Contraseña" />
		<div class="pass-icon"></div>		
		</div>

		<div class="footer">
		<input type="submit" name="submit" value="Entrar" class="button" />
                <br />
                <span>* Todos los campos son obligatorios.</span>
		</div>
 
	</form>
    


</div>
		<div style="position:absolute;left:500px;color:red">
                ${requestScope.errorMessage}
                </div>
<div class="gradient">

</div>


</body>
</html>
