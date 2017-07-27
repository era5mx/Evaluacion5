<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<%@ page import="mx.rengifo.evaluacion.util.DatabaseConnectionFactory" %>
<%@ page import="mx.rengifo.evaluacion.util.Constante" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><% out.println(Constante.TITLE_GRAL); %> &middot; Preguntas Ordenamiento/Relacion</title>
        <style type="text/css">
            body {
                background: url("${pageContext.request.contextPath}/images/background/background-<% out.print(Constante.BACKGROUND);%>.jpg");
            }
        </style>

    </head>

    <body>

        <div style="position:absolute;left:280px;top:20px">
            <span><strong><font FACE="arial">Sección 6: Preguntas de Ordenamiento y Relaci&oacute;n - Lea cuidadosamente y responda según lo considere pertinente.</font></strong></span>
        </div>
        <br/>
        <br/>

        <div style="position:absolute;left:280px;top:60px">

            <form action="exam2" method="post" >

                <div>
                    <font FACE="arial"><b>Pregunta 42</b></font><br/>
                    <font FACE="arial">Texto de la pregunta 42 </font>
                    <br/>
                    <br/>
                </div>

                <div>

                    <Table border="0">
                        <TR>
                            <TD>Texto1</TD> <TD><input type="text" name="entrada421"></TD> 
                        </TR>
                        <TR>
                            <TD>Texto2</TD> <TD><input type="text" name="entrada422"></TD>
                        </TR>
                        <TR>
                            <TD>Texto3</TD> <TD><input type="text" name="entrada423"></TD>
                        </TR>
                        <TR>
                            <TD>Texto4</TD> <TD><input type="text" name="entrada424"></TD>
                        </TR>
                        <TR>
                            <TD>Texto5</TD> <TD><input type="text" name="entrada425"></TD>
                        </TR>
                    </Table>

                </div>

                <br/>
                <br/>

                <div>
                    <font FACE="arial"><b>Pregunta 43</b></font><br/>
                    <font FACE="arial">Texto de la pregunta 43 </font>
                    <br/>
                    <br/>
                </div>
                
                <Table border="0">
                    <TR>
                        <!-- left -->
                        <TD>
                            <Table border="0">
                                <TR>
                                    <TD>A.</TD> <TD>Texto1</TD> 
                                </TR> 
                                <TR>
                                    <TD>B.</TD> <TD>Texto2</TD>
                                </TR>
                                <TR>
                                    <TD>C.</TD> <TD>Texto3</TD>
                                </TR>
                                <TR>
                                    <TD>D.</TD> <TD>Texto4</TD>
                                </TR>
                                <TR>
                                    <TD>E.</TD> <TD>Texto5</TD>
                                </TR>   
                            </Table>
                        </TD>
                        <!-- right -->
                        <TD>
                            <Table border="0">
                                <TR>
                                    <TD><input type="text" name="entrada431"></TD><TD>Texto1</TD>  
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada432"></TD><TD>Texto2</TD>
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada433"></TD><TD>Texto3</TD>
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada434"></TD><TD>Texto4</TD> 
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada435"></TD><TD>Texto5</TD>
                                </TR>
                            </Table>
                        </TD> 
                    </TR> 
                </Table>
                
                <br/>
                <br/>

                <div>
                    <font FACE="arial"><b>Pregunta 44</b></font><br/>
                    <font FACE="arial">Texto de la pregunta 44 </font>
                    <br/>
                    <br/>
                </div>

                <Table border="0">
                    <TR>
                        <!-- left -->
                        <TD>
                            <Table border="0">
                                <TR>
                                    <TD>A.</TD> <TD>Texto1</TD> 
                                </TR> 
                                <TR>
                                    <TD>B.</TD> <TD>Texto2</TD>
                                </TR>
                                <TR>
                                    <TD>C.</TD> <TD>Texto3</TD>
                                </TR>
                                <TR>
                                    <TD>D.</TD> <TD>Texto4</TD>
                                </TR>
                                <TR>
                                    <TD>E.</TD> <TD>Texto5</TD>
                                </TR>   
                            </Table>
                        </TD>
                        <!-- right -->
                        <TD>
                            <Table border="0">
                                <TR>
                                    <TD><input type="text" name="entrada441"></TD><TD>Texto1</TD>  
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada442"></TD><TD>Texto2</TD>
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada443"></TD><TD>Texto3</TD>
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada444"></TD><TD>Texto4</TD> 
                                </TR>
                                <TR>
                                    <TD><input type="text" name="entrada445"></TD><TD>Texto5</TD>
                                </TR>
                            </Table>
                        </TD> 
                    </TR> 
                </Table>

                <br/>
                <br/>

                <button type="submit" name="action" value="FIN">FIN &#9632;</button>
                
                <br/>
                <br/>

            </form>

        </div>

    </body>

</html>
