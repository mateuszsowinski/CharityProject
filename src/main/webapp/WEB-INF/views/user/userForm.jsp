<%--
  Created by IntelliJ IDEA.
  User: mateuszsowinski
  Date: 25/06/2021
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ include file="/WEB-INF/views/permanent/loged_header.jsp" %>


<form:form method="post" modelAttribute="user">
    <div class="form-group">
        <p hidden>  <form:input path="id" type="text" value=""/></div>
    </p>
    <form:input path="userName" type="text" value="" placeholder="Imię uzytkownika"/>
    <form:input path="lastname" type="text" value="" placeholder="Nazwisko"/>
    <form:input path="email" type="text" value="" placeholder="Email"/>


    <button class="btn" type="submit">Dadaj kategorię</button>

</form:form>

<%@ include file="/WEB-INF/views/permanent/loged_footer.jsp" %>
