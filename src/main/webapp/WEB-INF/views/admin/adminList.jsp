<%--
  Created by IntelliJ IDEA.
  User: mateuszsowinski
  Date: 26/06/2021
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ include file="/WEB-INF/views/permanent/loged_header.jsp" %>


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

    <c:forEach items="${adminList}" var="admin">
        <tr>
            <td>${admin.id}</td>
            <td>${admin.userName}</td>
            <td>${admin.lastname}</td>
            <td>${admin.email}</td>

            <td><a href='<c:url value="/admin/delete/${admin.id}"/>'>Usuń</a>
                <a href='<c:url value="/admin/update/${admin.id}"/>'>Edytuj</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>



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
    <c:forEach items="${userList}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.userName}</td>
        <td>${user.lastname}</td>
        <td>${user.email}</td>
        <td>    <a href='<c:url value="/admin/rolechange/${user.id}"/>'>Nadaj uprawnienia administratora</a>
        </td>

    </tr>
    </c:forEach>

    <%@ include file="/WEB-INF/views/permanent/loged_footer.jsp" %>

