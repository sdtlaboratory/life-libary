<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />
<h1>Обновление ссылки</h1>
</br>
<ul>
 <div class="borders">
    <div class = "border">
         <div class = "top"></div>
            <div class = "center">
<ul>
   <form:form method = "post" action = "/reduction/client/update/${link.nameLink}" commandName = "link">
    <table>
      <tr>
        <td>
          <form:label path = "domain">URL вашего сайта:</form:label>
        </td>
        <td>
          <form:input path="domain"/>
        </td>
        
      </tr>
      <tr>
        <td>
          <form:label path = "information">Краткая информация:</form:label>
        </td>
        <td>
          <form:input path="information"/>
        </td>
        
      </tr>
       <tr>
        <td>
          <form:label path = "tag1">Теги(через запятую "тег, тег1, тег2"):</form:label>
        </td>
        <td>
          <form:input path="tag1"/>
        </td>
        
      </tr>
      <tr>
        <td colspan="2"><input type="SUBMIT" value="Обновить"></td>
      </tr>
    </table>
  </form:form>
              </ul>
            </div>
          <div class = "bottom"></div>
    </div>

  </div>
