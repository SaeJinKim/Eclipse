<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<%@ include file = "/WEB-INF/view/top.jsp" %>

	${force} 
	<h4><spring:message code="could.agree"/></h4>
	<form action="step2" method="post">
		<label>
			 <input type="checkbox" name="agree"><spring:message code="agree"/>
			 <input type="checkbox" name="disagree"><spring:message code="disagree"/>
		</label>
		<input type="submit" value="<spring:message code="ntx.btn"/>">
	</form>
	
<%@ include file = "/WEB-INF/view/bottom.jsp" %>