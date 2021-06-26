<%--
  Created by IntelliJ IDEA.
  User: mateuszsowinski
  Date: 25/06/2021
  Time: 18:25
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
        <th>Nazwa Instytucji</th>
        <th>Opis</th>
        <th></th>
    </tr>
    </thead>

                <tbody>
                <c:forEach items="${institutions}" var="institution">
                    <tr>
                        <td>${institution.id}</td>
                        <td>${institution.name}</td>
                        <td>${institution.description}</td>
                        <td><a href='<c:url value="/admin/institution/delete/${institution.id}"/>'>Usuń</a>
                            <a href='<c:url value="/admin/institution/update/${institution.id}"/>'>Edytuj</a></td>
                    </tr>
                </c:forEach>
                <a href='<c:url value="/admin/institution/add"/>'>Dodaj Instytucję</a></td>

                </tbody>
            </table>

<%@ include file="/WEB-INF/views/permanent/loged_footer.jsp" %>
