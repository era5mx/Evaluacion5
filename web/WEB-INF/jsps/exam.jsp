<%@ page language="java" import="mx.rengifo.evaluacion.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="mx.rengifo.evaluacion.util.Constante"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><% out.println(Constante.TITLE_GRAL); %></title>
<style type="text/css">
    body {
        background: url("${pageContext.request.contextPath}/images/background/background-<% out.print(Constante.BACKGROUND);%>.jpg");
    }
</style>

</head>
<body>
<div style="position:absolute;left:50px;top:20px;font-family:Arial">
<%
  int currentQuestion=((Exam)request.getSession().getAttribute("currentExam")).getCurrentQuestion();
 %>
Pregunta actual ${sessionScope.quest.questionNumber+1} / 51
</div>

<!-- Begin - Seleccion multiple (41) -->
 <%
   if(currentQuestion >= 0 && currentQuestion < 41)
   {
 %>
<div style="position:absolute;left:280px;top:20px;font-family:Arial">
    <span><strong>Seleccion simple: Elije la opci&oacute;n correcta</strong></span>
</div>

<%} %>
<!-- End - Seleccion multiple (41) -->

<!-- Begin - Verdadero / Falso (9) -->
 <%
   if(currentQuestion >= 41 && currentQuestion < 50)
   {
 %>
<div style="position:absolute;left:280px;top:20px;font-family:Arial">
    <span><strong>Verdadero / Falso: Indica si la afirmaci&oacute;n es verdadera o falsa.</strong></span></div>
<%} %>
<!-- End - Verdadero / Falso (9) -->
 
<!-- Begin - Mejor Opcion (1) -->
 <%
   if(currentQuestion ==50)
   {
 %>
<div style="position:absolute;left:280px;top:20px;font-family:Arial">
    <span><strong>Mejor opci&oacute;n: Elije la mejor opci&oacute;n de las propuestas.</strong></span></div>
<%} %>
<!-- End - Mejor Opcion  (1) -->
 
<!-- Pregunta -->
<div style="position:absolute;width:1000px;padding:25px;height:200px;border:1px solid green;left:100px;top:60px;font-family:Arial">
    
    <span>${sessionScope.quest.question}</span><br><br>

    <!-- Opciones -->
    <form action="exam" method="post" >
     <c:forEach var="choice" items="${sessionScope.quest.questionOptions}" varStatus="counter">
         <c:if test="${not empty choice}">
            <input type="radio" name="answer" value="${counter.count}" >${choice}  <br/>
         </c:if>
     </c:forEach> <br/> 


    <!-- Navegador --> 
     <%
       if(currentQuestion > 0)
       {
     %>
     <button type="submit" name="action" value="ANTERIOR">&#171; ANTERIOR</button>
     <%} %>

     <%
       if(currentQuestion < 50)
       {
     %>
     <button type="submit" name="action" value="SIGUIENTE">SIGUIENTE &#187;</button>
     <%} %>
     <button type="submit" name="action" value="FIN">FIN &#9632;</button>

    </form>
</div>

</body>
</html>