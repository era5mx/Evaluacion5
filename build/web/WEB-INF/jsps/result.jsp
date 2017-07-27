<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<%@ page import="mx.rengifo.evaluacion.util.DatabaseConnectionFactory" %>
<%@ page import="mx.rengifo.evaluacion.util.Constante"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <style type="text/css">
            body {
                background: url("${pageContext.request.contextPath}/images/background/background-<% out.print(Constante.BACKGROUND); %>.jpg");
            }

</style>
<title><% out.println(Constante.TITLE_GRAL); %> &middot; Resultados</title>
</head>
<body>

<div style="position:absolute;left:500px;top:70px">
<!--
<h3 style="align-content: center">Resultados del Quiz</h3>
-->

<!-- 
<table border=1>
        <tr>
            <td class="head">
                Quiz :
            </td>
            <td>
                <span id="lblSubject">{sessionScope.exam}</span></td>
        </tr>
        <tr>
            <td class="head">
                Starting Time :
            </td>
            <td >
                <span id="lblStime">{sessionScope.started}</span></td>
        </tr>
        
              
                <tr>
            <td class="head">
               No. de Preguntas :
            </td>
            <td>
                <span id="lblNquestions">10</span></td>
        </tr>
        
                <tr>
            <td class="head">
                No. de respuestas correctas :
            </td>
            <td>
                <span id="lblNcans">{requestScope.result}</span></td>
        </tr>
        
    </table>

-->
        
<%
    String exam = (String) session.getAttribute("exam"); 
    String result = ((Integer) request.getAttribute("result")).toString();
    String user = (String) session.getAttribute("user");
    System.out.println("user :[" + user + "]; exam:[" + exam + "]; result:[" + result + "]");

    Connection con = DatabaseConnectionFactory.createConnection();
    PreparedStatement ps = null;
    try {
        con.setAutoCommit(false);
        ps = con.prepareStatement("UPDATE users SET exam=?, calificacion=? WHERE username = ?");
        ps.setString(1, exam);
        ps.setString(2, result);
        ps.setString(3, user);
        ps.executeUpdate();
        con.commit();

    } catch (SQLException sqe) {
        sqe.printStackTrace();
        System.out.println("Error : Mientras se insertaba el registro en la base de datos");
    } finally {
        try {
            con.close();
        } catch (SQLException se) {
            System.out.println("Error : Mientras se cerraba la conexion");
        }
    }
%>

<!-- 
< c :if test="{requestScope.result >= 5}">
   <h3 align="center">Aprobado</h3>
< / c:if>
< c :if test="{requestScope.result < 5}">
   <h3 align="center">Reprobado</h3>
< / c:if>
-->

<h2 align="center"><a href='${pageContext.request.contextPath}/takeExam2'>Ir a siguiente sección del examen</a></h2>
</div>

</body>
</html>