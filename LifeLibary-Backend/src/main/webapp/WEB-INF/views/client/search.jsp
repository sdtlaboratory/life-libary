<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />
<h1>Поиск по тегу</h1>
</br>
 <div class="borders">
   <c:forEach items="${links}" var="links" >
      <div class = "border">
         <div class = "top"></div>
            <div class = "center">

             <ul>
             <a href="<c:url value='/${links.nameLink }' />">reduction/${links.nameLink }</a>&nbsp;
             Имя пользователя: ${links.user.name}&nbsp;
             Клики: ${links.count}&nbsp;
             <a href="<c:url value='/client/info/${links.nameLink }' />">подробнее</a>&nbsp;
             </ul>
            </div>
          <div class = "bottom"></div>
          </div>
    </c:forEach>
  </div>