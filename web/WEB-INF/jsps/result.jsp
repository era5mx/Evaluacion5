<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<%@ page import="mx.rengifo.evaluacion.util.DatabaseConnectionFactory" %>
<%@ page import="mx.rengifo.evaluacion.Exam" %>
<%@ page import="mx.rengifo.evaluacion.util.Message" %>
<%@ page import="mx.rengifo.evaluacion.util.Constante" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="Resultados de la primera secci&oacute;n de la evaluaci&oacute;n">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <style type="text/css">
            body {
                background: url("${pageContext.request.contextPath}/images/background/background-<% out.print(Constante.BACKGROUND); %>.jpg");
            }

</style>
<title><% out.println(Constante.TITLE_GRAL); %> &middot; Resultados 1</title>
</head>
<body>

<div style="position:absolute;left:500px;top:70px">

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
        ps = con.prepareStatement(Exam.UPDATE_EXAM_CALIFICACION);
        ps.setString(1, exam);
        ps.setString(2, result);
        ps.setString(3, user);
        ps.executeUpdate();
        con.commit();

    } catch (SQLException sqe) {
        sqe.printStackTrace();
        System.out.println(Message.ERROR_MESSAGE_INSERT);
    } finally {
        try {
            con.close();
        } catch (SQLException se) {
            System.out.println(Message.ERROR_MESSAGE_CLOSE_CONNECTION);
        }
    }
%>

<h2 align="center"><a href='${pageContext.request.contextPath}/takeExam2'>Ir a siguiente secci&oacute;n del examen</a></h2>
</div>

</body>
</html>