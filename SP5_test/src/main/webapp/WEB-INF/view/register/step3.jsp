<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<%@ include file = "/WEB-INF/view/top.jsp" %>

	<p>
		<spring:message code="regist.done">
        	<spring:argument value="${registerRequest.name}" />
        	<spring:argument value="${registerRequest.email}" />
        </spring:message>
        
		<a href="<c:url value='/index'/>">
            [<spring:message code="go.index" />]
        </a>
	</p>

<%@ include file = "/WEB-INF/view/bottom.jsp" %>