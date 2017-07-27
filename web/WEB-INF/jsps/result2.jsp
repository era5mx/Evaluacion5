<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<%@ page import="mx.rengifo.evaluacion.util.Constante" %>
<%@ page import="mx.rengifo.evaluacion.util.Message" %>
<%@ page import="mx.rengifo.evaluacion.util.DatabaseConnectionFactory" %>
<%@ page import="mx.rengifo.evaluacion.Exam" %>
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
        <title><% out.println(Constante.TITLE_GRAL); %> &middot; Resultados 2</title>
    </head>
    <body>

        <div style="position:absolute;left:500px;top:70px">
            <!--
            <h3 style="align-content: center">Resultados de la segunda secci&oacute;n de la evaluaci&oacute;n</h3>
            -->

            <!-- Logica para guardar el resultado -->

            <!-- Preparando las respuestas y cargandolas al map -->
            <%
                String respuesta42 = "["
                        + request.getParameter("entrada421") + " "
                        + request.getParameter("entrada422") + " "
                        + request.getParameter("entrada423") + " "
                        + request.getParameter("entrada424") + " "
                        + request.getParameter("entrada425") + "]";
                String respuesta43 = "["
                        + request.getParameter("entrada431") + " "
                        + request.getParameter("entrada432") + " "
                        + request.getParameter("entrada433") + " "
                        + request.getParameter("entrada434") + " "
                        + request.getParameter("entrada435") + "]";
                String respuesta44 = "["
                        + request.getParameter("entrada441") + " "
                        + request.getParameter("entrada442") + " "
                        + request.getParameter("entrada443") + " "
                        + request.getParameter("entrada444") + " "
                        + request.getParameter("entrada445") + "]";
                Map<Integer, String> selections = new LinkedHashMap<Integer, String>();
                selections.put(42, respuesta42);
                selections.put(43, respuesta43);
                selections.put(44, respuesta44);

            %>
            <!-- 
            <table border=1>
                <tr>
                    <td class="head">
                        Pregunta 42
                    </td>
                    <td>
                        <span id="lblSubject">
                            < out.print("Respuesta42: " + respuesta42); %>
                        </span>
                    </td>
                </tr>
                <tr>
                    <td class="head">
                        Pregunta 43
                    </td>
                    <td >
                        <span id="lblStime">
                            < out.print("Respuesta43: " + respuesta43); %>
                        </span>
                    </td>
                </tr>
                <tr>
                    <td class="head">
                        Pregunta 44
                    </td>
                    <td >
                        <span id="lblStime">
                            < out.print("Respuesta44: " + respuesta44); %>
                        </span>
                    </td>
                </tr>
            </table>
            -->

            <!-- Persistiendo los datos -->
            <%
                String username = (String) session.getAttribute("user");

                for (Map.Entry<Integer, String> en : selections.entrySet()) {
                    Integer key = en.getKey();
                    String value = en.getValue();

                    Connection con = DatabaseConnectionFactory.createConnection();
                    PreparedStatement ps = null;
                    try {
                        con.setAutoCommit(false);

                        ps = con.prepareStatement(Exam.INSERT_INTO_QUIZRESULTADOS);
                        ps.setString(1, username);
                        ps.setInt(2, key);
                        ps.setString(3, value.toString());
                        ps.executeUpdate();
                        con.commit();

                    } catch (SQLException sqe) {
                        sqe.printStackTrace();
                        System.out.println("Error : While Inserting record in database");
                    } finally {
                        try {
                            con.close();
                        } catch (SQLException se) {
                            System.out.println("Error : While Closing Connection");
                        }
                    }
                }

            %>

            <h2 align="center"><a href='${pageContext.request.contextPath}/takeExam3'>Ir a siguiente sección del examen</a></h2>
        </div>

    </body>
</html>