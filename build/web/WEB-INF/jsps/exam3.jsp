<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<%@ page import="mx.rengifo.evaluacion.util.DatabaseConnectionFactory" %>
<%@ page import="mx.rengifo.evaluacion.util.Constante" %>
<%@ page import="mx.rengifo.evaluacion.util.Message" %>
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

        <div style="position:absolute;left:280px;top:20px">
            <span><strong><font FACE="arial">Sección 6: Preguntas Abiertas - Lea cuidadosamente y responda según lo considere pertinente.</font></strong></span>
        </div>
        <br/>
        <br/>

        <div style="position:absolute;left:280px;top:60px">

            <form action="exam3" method="post" >
                <div>
                    <font FACE="arial"><b>Pregunta 56</b></font><br/>
                    <font FACE="arial">Texto de la pregunta 56 </font>
                </div>
                <br/>
                <br/>

                <div>
                    <font FACE="arial">
                        <textarea name="comentarios56" rows="12" cols="125">...Tu respuesta aquí...</textarea>
                    </font>
                </div>
                <br/>
                <br/>

                <div>
                    <font FACE="arial"><b>Pregunta 57</b></font><br/>
                    <font FACE="arial">Texto de la pregunta 57 </font>
                </div>
                <br/>
                <br/>

                <div>
                    <font FACE="arial">
                        <textarea name="comentarios57" rows="12" cols="125">...Tu respuesta aquí...</textarea>
                    </font>
                </div>

                <br/>
                <br/>

                <button type="submit" name="action" value="FIN">FIN &#9632;</button>

                <br/>
                <br/>

            </form>

        </div>

    </body>
</html>
