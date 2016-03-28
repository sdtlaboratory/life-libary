<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<meta http-equiv="cache-control" content="max-age=0" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
	<meta http-equiv="pragma" content="no-cache" />

	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/layout.css"/>" />
 	
 	<script src="<c:url value="/resources/js/jquery.js" />"></script>
 	<script src="<c:url value="/resources/js/json2.js" />"></script>
 	
	<script src="<c:url value="/resources/js/main.js" />"></script>
</head>
<body>
 
<div id="wrapper">
   	
   	<tiles:insertAttribute name="header" />
		
	<div id="wrapper1">
	<div id="middle">
	<div class="container">
		<div id="content">
			<security:authorize access="isAuthenticated()">
					<tiles:insertAttribute name="body" />	
			</security:authorize>
			
			<security:authorize access="isAnonymous()">
					<tiles:insertAttribute name="body" />				
			</security:authorize>
		</div>
	</div>
	
	<security:authorize access="isAuthenticated()">
	
	 <tiles:insertAttribute name="menu" />
	
	</security:authorize>
	</div>
	</div>
	
	</div>
    
	
	 <tiles:insertAttribute name="paginator" />
	
	
<tiles:insertAttribute name="footer" />	
</body>
</html>