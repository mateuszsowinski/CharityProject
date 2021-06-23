<%--
  Created by IntelliJ IDEA.
  User: mateuszsowinski
  Date: 15/06/2021
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ include file="/WEB-INF/views/permanent/header.jsp" %>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="user" method="post" >
        <div class="form-group">
            <form:input type="text" path="name" placeholder="Imię" />
        </div>
        <div class="form-group">
            <form:input type="text" path="lastname" placeholder="Nazwisko"  />
        </div>
        <div class="form-group">
            <form:input type="email" path="email" placeholder="Email"  />
        </div>
        <div class="form-group">
            <form:input type="password" path="password" placeholder="Hasło"  />
        </div>
        <div class="form-group">
            <input type="password" name="password2" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<%@ include file="/WEB-INF/views/permanent/footer.jsp" %>
