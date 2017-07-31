<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<%@ page import="mx.rengifo.evaluacion.util.DatabaseConnectionFactory" %>
<%@ page import="mx.rengifo.evaluacion.util.Constante" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><% out.println(Constante.TITLE_GRAL); %> &middot; Preguntas de Ordenamiento y Relaci&oacute;n</title>
        <style type="text/css">
            body {
                background: url("${pageContext.request.contextPath}/images/background/background-<% out.print(Constante.BACKGROUND);%>.jpg");
            }
        </style>

    </head>

    <body>
        
        <!-- Opciones de Respuestas -->
        <% 
            String exam = (String) session.getAttribute("exam");
            String[] opciones42 = new String[5];
            String[] opciones43 = new String[5];
            String[] opciones44 = new String[5];
            if(exam.equals("rol1")){
                opciones42 = new String[]{"Texto1_42_rol1","Texto2_42_rol1","Texto3_42_rol1","Texto4_42_rol1","Texto5_42_rol1"};
                opciones43 = new String[]{"Texto1_43_rol1","Texto2_43_rol1","Texto3_43_rol1","Texto4_43_rol1","Texto5_43_rol1"};
                opciones44 = new String[]{"Texto1_44_rol1","Texto2_44_rol1","Texto3_44_rol1","Texto4_44_rol1","Texto5_44_rol1"};
            } 
            else if(exam.equals("rol2")){
                opciones42 = new String[]{"Texto1_42_rol2","Texto2_42_rol2","Texto3_42_rol2","Texto4_42_rol2","Texto5_42_rol2"};
                opciones43 = new String[]{"Texto1_43_rol2","Texto2_43_rol2","Texto3_43_rol2","Texto4_43_rol2","Texto5_43_rol2"};
                opciones44 = new String[]{"Texto1_44_rol2","Texto2_44_rol2","Texto3_44_rol2","Texto4_44_rol2","Texto5_44_rol2"};
            }
            else if(exam.equals("rol3")){
                opciones42 = new String[]{"Texto1_42_rol3","Texto2_42_rol3","Texto3_42_rol3","Texto4_42_rol3","Texto5_42_rol3"};
                opciones43 = new String[]{"Texto1_43_rol3","Texto2_43_rol3","Texto3_43_rol3","Texto4_43_rol3","Texto5_43_rol3"};
                opciones44 = new String[]{"Texto1_44_rol3","Texto2_44_rol3","Texto3_44_rol3","Texto4_44_rol3","Texto5_44_rol3"};
            }
            else if(exam.equals("rol4")){
                opciones42 = new String[]{"Texto1_42_rol4","Texto2_42_rol4","Texto3_42_rol4","Texto4_42_rol4","Texto5_42_rol4"};
                opciones43 = new String[]{"Texto1_43_rol4","Texto2_43_rol4","Texto3_43_rol4","Texto4_43_rol4","Texto5_43_rol4"};
                opciones44 = new String[]{"Texto1_44_rol4","Texto2_44_rol4","Texto3_44_rol4","Texto4_44_rol4","Texto5_44_rol4"};
            }
            else if(exam.equals("rol5")){
                opciones42 = new String[]{"Texto1_42_rol5","Texto2_42_rol5","Texto3_42_rol5","Texto4_42_rol5","Texto5_42_rol5"};
                opciones43 = new String[]{"Texto1_43_rol5","Texto2_43_rol5","Texto3_43_rol5","Texto4_43_rol5","Texto5_43_rol5"};
                opciones44 = new String[]{"Texto1_44_rol5","Texto2_44_rol5","Texto3_44_rol5","Texto4_44_rol5","Texto5_44_rol5"};
            }
            else {
                request.setAttribute("errorMessage","<br><br>ERROR: Esta seccion no es valida para el examen ["+exam+"]");
            }

        %>

        <div style="position:absolute;left:280px;top:20px;font-family:Arial">
            <span><strong>Secci&oacute;n 6: Preguntas de Ordenamiento y Relaci&oacute;n - ${sessionScope.exam}<br>
                    Lea cuidadosamente y responda seg&uacute;n lo considere pertinente.</strong></span>
        </div>
        <br>
        <br>

        <div style="position:absolute;left:280px;top:60px;font-family:Arial">

            <form action="exam2" method="post" >
                
                <div>
                    <strong>Pregunta 42</strong><br>
                    <c:choose>
                        <c:when test="${sessionScope.exam=='rol1'}">
                            Texto de la pregunta 42 &middot; rol1
                        </c:when>
                        <c:when test="${sessionScope.exam=='rol2'}">
                            Texto de la pregunta 42 &middot; rol2
                        </c:when> 
                        <c:when test="${sessionScope.exam=='rol3'}">
                            Texto de la pregunta 42 &middot; rol3
                        </c:when> 
                        <c:when test="${sessionScope.exam=='rol4'}">
                            Texto de la pregunta 42 &middot; rol4
                        </c:when> 
                        <c:when test="${sessionScope.exam=='rol5'}">
                            Texto de la pregunta 42 &middot; rol5
                        </c:when> 
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>
                    <br>
                    <br>
                </div>

                <div>

                    <Table border="0">
                        <TR>
                            <TD><% out.println(opciones42[0]); %></TD> <TD><input type="text" name="entrada421"></TD> 
                        </TR>
                        <TR>
                            <TD><% out.println(opciones42[1]); %></TD> <TD><input type="text" name="entrada422"></TD>
                        </TR>
                        <TR>
                            <TD><% out.println(opciones42[2]); %></TD> <TD><input type="text" name="entrada423"></TD>
                        </TR>
                        <TR>
                            <TD><% out.println(opciones42[3]); %></TD> <TD><input type="text" name="entrada424"></TD>
                        </TR>
                        <TR>
                            <TD><% out.println(opciones42[4]); %></TD> <TD><input type="text" name="entrada425"></TD>
                        </TR>
                    </Table>

                </div>

                <br>
                <br>
                
                <div>
                    <strong>Pregunta 43</strong><br>
                    <c:choose>
                        <c:when test="${sessionScope.exam=='rol1'}">
                            Texto de la pregunta 43 &middot; rol1
                        </c:when>
                        <c:when test="${sessionScope.exam=='rol2'}">
                            Texto de la pregunta 43 &middot; rol2
                        </c:when> 
                        <c:when test="${sessionScope.exam=='rol3'}">
                            Texto de la pregunta 43 &middot; rol3
                        </c:when> 
                        <c:when test="${sessionScope.exam=='rol4'}">
                            Texto de la pregunta 43 &middot; rol4
                        </c:when> 
                        <c:when test="${sessionScope.exam=='rol5'}">
                            Texto de la pregunta 43 &middot; rol5
                        </c:when> 
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>
                    <br>
                    <br>
                </div>
                
                <Table border="0">
                    <TR>
                        <!-- left -->
                        <TD>
                            <Table border="0">
                                <TR>
                                    <TD>A.</TD> <TD><% out.println(opciones43[0]); %></TD> 
                                </TR> 
                                <TR>
                                    <TD>B.</TD> <TD><% out.println(opciones43[1]); %></TD>
                                </TR>
                                <TR>
                                    <TD>C.</TD> <TD><% out.println(opciones43[2]); %></TD>
                                </TR>
                                <TR>
                                    <TD>D.</TD> <TD><% out.println(opciones43[3]); %></TD>
                                </TR>
                                <TR>
                                    <TD>E.</TD> <TD><% out.println(opciones43[4]); %></TD>
                                </TR>   
                            </Table>
                        </TD>
                        <!-- right -->
                        <TD>
                            <Table border="0">
                                <TR>
                                    <TD><input type="text" name="entrada431"></TD><TD><% out.println(opciones43[0]); %></TD>  
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada432"></TD><TD><% out.println(opciones43[1]); %></TD>
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada433"></TD><TD><% out.println(opciones43[2]); %></TD>
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada434"></TD><TD><% out.println(opciones43[3]); %></TD> 
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada435"></TD><TD><% out.println(opciones43[4]); %></TD>
                                </TR>
                            </Table>
                        </TD> 
                    </TR> 
                </Table>
                
                <br>
                <br>

                <div>
                    <strong>Pregunta 44</strong><br>
                    <c:choose>
                        <c:when test="${sessionScope.exam=='rol1'}">
                            Texto de la pregunta 44 &middot; rol1
                        </c:when>
                        <c:when test="${sessionScope.exam=='rol2'}">
                            Texto de la pregunta 44 &middot; rol2
                        </c:when> 
                        <c:when test="${sessionScope.exam=='rol3'}">
                            Texto de la pregunta 44 &middot; rol3
                        </c:when> 
                        <c:when test="${sessionScope.exam=='rol4'}">
                            Texto de la pregunta 44 &middot; rol4
                        </c:when> 
                        <c:when test="${sessionScope.exam=='rol5'}">
                            Texto de la pregunta 44 &middot; rol5
                        </c:when> 
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>
                    <br>
                    <br>
                </div>

                <Table border="0">
                    <TR>
                        <!-- left -->
                        <TD>
                            <Table border="0">
                                <TR>
                                    <TD>A.</TD> <TD><% out.println(opciones44[0]); %></TD> 
                                </TR> 
                                <TR>
                                    <TD>B.</TD> <TD><% out.println(opciones44[1]); %></TD>
                                </TR>
                                <TR>
                                    <TD>C.</TD> <TD><% out.println(opciones44[2]); %></TD>
                                </TR>
                                <TR>
                                    <TD>D.</TD> <TD><% out.println(opciones44[3]); %></TD>
                                </TR>
                                <TR>
                                    <TD>E.</TD> <TD><% out.println(opciones44[4]); %></TD>
                                </TR>   
                            </Table>
                        </TD>
                        <!-- right -->
                        <TD>
                            <Table border="0">
                                <TR>
                                    <TD><input type="text" name="entrada441"></TD><TD><% out.println(opciones44[0]); %></TD>  
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada442"></TD><TD><% out.println(opciones44[1]); %></TD>
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada443"></TD><TD><% out.println(opciones44[2]); %></TD>
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada444"></TD><TD><% out.println(opciones44[3]); %></TD> 
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada445"></TD><TD><% out.println(opciones44[4]); %></TD>
                                </TR>
                            </Table>
                        </TD> 
                    </TR> 
                </Table>

                <br>
                <br>

                <button type="submit" name="action" value="FIN">FIN &#9632;</button>
                
                <br>
                <br>

            </form>

        </div>

        <div style="position:absolute;left:500px;color:red">
        ${requestScope.errorMessage}
        </div>

        <div class="gradient">
        </div>

    </body>

</html>
