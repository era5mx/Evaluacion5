<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<%@ page import="mx.rengifo.evaluacion.util.DatabaseConnectionFactory" %>
<%@ page import="mx.rengifo.evaluacion.util.Constante" %>
<%@ page import="mx.rengifo.evaluacion.util.Message" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><% out.println(Constante.TITLE_GRAL); %> &middot; Preguntas Abiertas</title>
        <style type="text/css">
            body {
                background: url("${pageContext.request.contextPath}/images/background/background-<% out.print(Constante.BACKGROUND);%>.jpg");
            }
        </style>

    </head>

    <body>

        <div style="position:absolute;left:280px;top:20px;font-family:Arial">
            <span><strong>Secci&oacute;n 6: Preguntas Abiertas - ${sessionScope.exam}<br>
                    Lea cuidadosamente y responda seg&uacute;n lo considere pertinente.</strong></span>
        </div>
        <br>
        <br>

        <div style="position:absolute;left:280px;top:60px;font-family:Arial">

            <form action="exam3" method="post" >
                
                <div>
                    <strong>Pregunta 56</strong><br>
                    <c:choose>
                        <c:when test="${sessionScope.exam=='rol1'}">
                            Texto de la pregunta 56 &middot; rol1
                        </c:when>
                        <c:when test="${sessionScope.exam=='rol2'}">
                            Texto de la pregunta 56 &middot; rol2
                        </c:when> 
                        <c:when test="${sessionScope.exam=='rol3'}">
                            Texto de la pregunta 56 &middot; rol3
                        </c:when> 
                        <c:when test="${sessionScope.exam=='rol4'}">
                            Texto de la pregunta 56 &middot; rol4
                        </c:when> 
                        <c:when test="${sessionScope.exam=='rol5'}">
                            Texto de la pregunta 56 &middot; rol5
                        </c:when> 
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>
                    <br>
                    <br>
                </div>

                <div>
                    <textarea name="comentarios56" rows="12" cols="125">...Tu respuesta aqu&iacute;...</textarea>
                </div>
                <br>
                <br>

                <div>
                    <strong>Pregunta 57</strong><br>
                    <c:choose>
                        <c:when test="${sessionScope.exam=='rol1'}">
                            Texto de la pregunta 57 &middot; rol1
                        </c:when>
                        <c:when test="${sessionScope.exam=='rol2'}">
                            Texto de la pregunta 57 &middot; rol2
                        </c:when> 
                        <c:when test="${sessionScope.exam=='rol3'}">
                            Texto de la pregunta 57 &middot; rol3
                        </c:when> 
                        <c:when test="${sessionScope.exam=='rol4'}">
                            Texto de la pregunta 57 &middot; rol4
                        </c:when> 
                        <c:when test="${sessionScope.exam=='rol5'}">
                            Texto de la pregunta 57 &middot; rol5
                        </c:when> 
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>
                    <br>
                    <br>
                </div>

                <div>
                    <textarea name="comentarios57" rows="12" cols="125">...Tu respuesta aqu&iacute;...</textarea>
                </div>

                <br>
                <br>

                <button type="submit" name="action" value="FIN">FIN &#9632;</button>

                <br>
                <br>

            </form>

        </div>

    </body>
</html>
