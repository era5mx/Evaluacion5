<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="mx.rengifo.evaluacion.util.Constante" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            .button {
                padding: 10px 15px;
                font-size: 14px;
                line-height: 100%;
                text-shadow: 0 1px rgba(0, 0, 0, 0.4);
                color: #fff;

                vertical-align: middle;
                text-align: center;
                cursor: pointer;
                font-weight: bold;
                transition: background 0.1s ease-in-out;
                -webkit-transition: background 0.1s ease-in-out;
                -moz-transition: background 0.1s ease-in-out;
                -ms-transition: background 0.1s ease-in-out;
                -o-transition: background 0.1s ease-in-out;
                text-shadow: 0 1px rgba(0, 0, 0, 0.3);
                color: #fff;
                -webkit-border-radius: 40px;
                -moz-border-radius: 40px;
                border-radius: 40px;
                font-family: 'Helvetica Neue', Helvetica, sans-serif;
            }

            .button, .button:hover, .button:active {
                outline: 0 none;
                text-decoration: none;
                color: #fff;
            }

            .username {
                background-color: #2ecc71;
                box-shadow: 0px 3px 0px 0px #239a55;
            }

        </style>

        <title><% out.println(Constante.TITLE_GRAL);%> &middot; Inicio</title>
    </head>
    <body>

        <div id='cssmenu'>
            <ul>
                <li class=''><a href='${pageContext.request.contextPath}'><span>Inicio</span></a></li>
                <li><a href='${pageContext.request.contextPath}/login'><span>Entrar</span></a></li>
                <li><a href='${pageContext.request.contextPath}/register'><span>Registrar</span></a></li>
            </ul>
        </div>

        <c:if test='${empty sessionScope.user}'>
            <div style="position:absolute;left:120px;top:60px">
                <h1><a href='${pageContext.request.contextPath}/login'><span>Inicia sesión</span></a></h1>
            </div>
        </c:if>

        <c:if test='${not empty sessionScope.user}'>

            <div style="position:absolute;top:70px;left:1100px">
                Hola <a href="#" class="button username">${sessionScope.user}</a>
            </div>

            <div style="position:absolute;top:70px;left:1300px">
                <a href='${pageContext.request.contextPath}/logout'>Salir</a>
            </div>

            <div style="position:absolute;left:120px;top:60px">

                <table cellpadding="0" cellspacing="50">

                    <tr>
                        <td>    
                            <a href="takeExam?test=${sessionScope.exam}"><img height="200" width="200" src="${pageContext.request.contextPath}/images/${sessionScope.exam}.png"/></a>
                        </td>
                    </tr>

                </table>

                <div style="color:red">
                    ${requestScope.errorMessage}
                </div>

            </div>

        </c:if>

    </body>
</html>
