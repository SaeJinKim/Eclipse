<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ include file = "/WEB-INF/view/top.jsp" %>


	<spring:message code="log.done">
        <spring:argument value="${loginRequest.name}" />
        <spring:argument value="${loginRequest.email}" />
    </spring:message>
	
	<a href="<c:url value='/index'/>">
            [<spring:message code="go.index" />]
    </a>

<%@ include file = "/WEB-INF/view/bottom.jsp" %>