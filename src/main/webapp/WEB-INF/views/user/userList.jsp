<%--
  Created by IntelliJ IDEA.
  User: mateuszsowinski
  Date: 25/06/2021
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/views/permanent/loged_header.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<table
        class="tableTab">
    <thead>
    <tr>
        <th>Id</th>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>Email</th>
        <th></th>

        <th></th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.lastname}</td>
            <td>${user.email}</td>
            <td><a href='<c:url value="/admin/user/delete/${user.id}"/>'>Usuń</a>
                <a href='<c:url value="/admin/user/update/${user.id}"/>'>Edytuj</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>


<%@ include file="/WEB-INF/views/permanent/loged_footer.jsp" %>
