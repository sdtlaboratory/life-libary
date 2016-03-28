<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/header.css"/>" />

<div id="header">
		<div id="logo">
			<a href="/"></a>
		</div>
		<div id="gor-menu">
		<div id ="location">
		Добро пожаловать
		<security:authorize access="isAuthenticated()" >
        ${user.role} (${user.login}) / ID: ${user.userId}
        <a href="<c:url value='/j_spring_security_logout' />">Выйти</a>
         </security:authorize> 
         <security:authorize access="isAnonymous()" >
         Гость, <a href="<c:url value='/login' />">Войти</a>
          </security:authorize> 
         </div>
		</div>
</div>
