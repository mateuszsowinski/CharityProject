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
    <h2>Zaloguj się</h2>
    <form:form method="post">
        <div class="form-group">
            <input type="text" id="email" name="userName" placeholder="Email" />
        </div>
        <div class="form-group">
            <input type="password" id="password" name="password" placeholder="Hasło" />
            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
            <a href="#" class="btn btn--without-border">Załóż konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
        </div>
    </form:form>
</section>

<%@ include file="/WEB-INF/views/permanent/footer.jsp" %>
