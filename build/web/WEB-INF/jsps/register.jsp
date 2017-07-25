<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<%@ page import="mx.rengifo.evaluacion.util.Constante"%>
<%@ page import="mx.rengifo.evaluacion.util.Message" %>
<%@ page import="mx.rengifo.evaluacion.util.DatabaseConnectionFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
    <title>
        <% out.println(Constante.TITLE_GRAL); %> &middot; Registrar
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
    <script src="${pageContext.request.contextPath}/js/onsubmit_event.js"></script>
</head>
<body>

<!-- Menu -->
<div id='cssmenu'>
<ul>
   <li class=''><a href='${pageContext.request.contextPath}/inicio'><span>Inicio</span></a></li>
   <li><a href='${pageContext.request.contextPath}/login'><span>Entrar</span></a></li>
   <li><a href='${pageContext.request.contextPath}/register'><span>Registrar</span></a></li>
</ul>
</div>

<% 
    // Conexion con bd para recuperar el catalogo de examenes activos
    ResultSet resultado = null;
    PreparedStatement ps = null;
    Connection con = DatabaseConnectionFactory.createConnection();
    
    if(null==con){
        System.out.println(Message.ERROR_MESSAGE_OPEN_CONNECTION);
    }
    else {
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement("select * from examenes where activo=1");
            resultado = ps.executeQuery();

        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.out.println(Message.ERROR_MESSAGE_SELECT);
        }
    }
%> 

<div id="wrapper">

	<form name="login-form" class="login-form" action="checkRegister" method="post" onsubmit="return ValidationEventRegister()">
	
		<div class="header">
		<h1>Registrar </h1>
		<span></span>
		</div>
	
		<div class="content">
		<input id="username" name="username" type="text" class="input username" placeholder="Usuario" />
		<div class="user-icon"></div><br/><br/>
		<input id="email" name="email" type="text" class="input username" placeholder="Correo" />
		<div class="user-icon"></div>
		<input id="password" name="password" type="password" class="input password" placeholder="Contraseña" />
		<div class="pass-icon"></div><br/><br/>
                
                <%  
                    out.println(" <select name='exam' class='input username'>");
                    out.println("<option value='' disabled selected>Seleccione el rol...</option>");
                    // continuamos con el select
                    while (resultado.next()) {
                        String exam=resultado.getString("exam");//guardamos un campo de resultado en una variable 
                        out.println("<option value='" + exam + "'>" + exam + "</option>");//imprimimos el contenido del select
                    }
                    out.println("</select>"); 
                %>
                <div class="user-icon"></div>
                
		</div>

		<div class="footer">		
		<input type="submit" name="submit" value="Registrar" class="register" />
                <br />
                <span>* Todos los campos son obligatorios.</span>
                
                <div style="color:red">
                ${requestScope.errorMessage}
                </div>
                
		</div>
	
	</form>

</div>

		
                
<div class="gradient"></div>


</body>
</html>
