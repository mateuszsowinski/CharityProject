<%--
  Created by IntelliJ IDEA.
  User: mateuszsowinski
  Date: 24/06/2021
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/permanent/loged_header.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="slogan container container--90">
    <h2>
        <a href='<c:url value="/admin/institution/list"/>'> Instytucje</a></td><br>
        <a href='<c:url value="/admin/user/list"/>'> Użytkowinicy</a></td><br>
        <a href='<c:url value="/admin/admin/list"/>'> Administracja</a></td><br>


    </h2>
</div>



<%@ include file="/WEB-INF/views/permanent/loged_footer.jsp" %>
