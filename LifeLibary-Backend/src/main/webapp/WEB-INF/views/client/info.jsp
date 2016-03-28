<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />
<h1>Информация</h1>
</br>
 <div class="borders">
   
      <div class = "border">
         <div class = "top"></div>
            <div class = "center">

             <ul>
             <a href="<c:url value='/${link.nameLink }' />">reduction/${link.nameLink }</a>&nbsp;</br>
             Домменое имя:${link.domain }</br>
             Информация:${link.information }</br>
             Клики:${link.count }</br>
             Имя пользователя: ${link.user.name}&nbsp;</br>
             Теги:
             <c:forEach items="${link.tags}" var="tags" >
             <a href="<c:url value='/client/search/${tags.name }' />">${tags.name}</a>
             </c:forEach></br>
             <a href="<c:url value='/client/update/${link.nameLink }' />">Редактировать</a>
             </ul>
            </div>
          <div class = "bottom"></div>
          </div>
    
  </div>