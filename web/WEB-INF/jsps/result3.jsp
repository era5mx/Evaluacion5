<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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
        <meta name="description" content="Resultados de la tercera secci&oacute;n de la evaluaci&oacute;n">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
        <style type="text/css">
            body {
                background: url("${pageContext.request.contextPath}/images/background/background-<% out.print(Constante.BACKGROUND); %>.jpg");
            }

        </style>
        <title><% out.println(Constante.TITLE_GRAL); %> &middot; Resultados 3</title>
    </head>
    <body>

        <div style="position:absolute;left:500px;top:70px">

            <!-- Preparando las respuestas y cargandolas al map -->
            <%
                String respuesta56 = "[" + request.getParameter("comentarios56") + "]";
                String respuesta57 = "[" + request.getParameter("comentarios57") + "]";

                Map<Integer, String> selections = new LinkedHashMap<Integer, String>();
                selections.put(56, respuesta56);
                selections.put(57, respuesta57);

            %>
            
            <!--
            <table border=1>
                <tr>
                    <td class="head">
                        Pregunta 56
                    </td>
                    <td>
                        <span id="lblSubject">
                            < out.print("Respuesta56: " + respuesta56); %>
                        </span>
                    </td>
                </tr>
                <tr>
                    <td class="head">
                        Pregunta 57
                    </td>
                    <td >
                        <span id="lblStime">
                            < out.print("Respuesta57: " + respuesta57); %>
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
                        System.out.println(Message.ERROR_MESSAGE_INSERT);
                    } finally {
                        try {
                            con.close();
                        } catch (SQLException se) {
                            System.out.println(Message.ERROR_MESSAGE_CLOSE_CONNECTION);
                        }
                    }
                }

            %>

            <h2 align="center"><a href='${pageContext.request.contextPath}/logout'>Terminar el examen</a></h2>
        </div>

    </body>
</html>