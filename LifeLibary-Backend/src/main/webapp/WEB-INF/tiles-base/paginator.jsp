<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />
  
  <div class="paginator">
				<ul>
	
					<c:if test="${page > 1 }">
						<li><a href="?page=${page - 1}"><span>&laquo;</span></a></li>
					</c:if>
					<c:forEach begin="${startpage}" end="${endpage}" var="p">
						<c:if test="${p == page }">
							<li class="active"><a href="?page=${p}"><b>${p}</b></a></li>
						</c:if>
						<c:if test="${p != page }">
							<li><span><a href="?page=${p}">${p}</a></span></li>
						</c:if>
					</c:forEach>
					<c:if test="${(page + 1) <= endpage}">
						<li><a href="?page=${page + 1}"><span>&raquo;</span></a></li>
					</c:if>
				</ul>
   </div>