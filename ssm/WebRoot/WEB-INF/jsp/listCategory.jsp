<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${categorys}" var="category" varStatus="st">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
              
        </tr>
    </c:forEach>
</table>