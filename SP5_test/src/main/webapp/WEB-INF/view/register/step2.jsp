<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file = "/WEB-INF/view/top.jsp" %>

	<h2><spring:message code="reg.ing"/></h2>
	<form action="step3" method="post">
		<p>
			<label><spring:message code="reg.email"/><br>
			<input type="text" name="email" id="email">
			</label>
		</p>
		<p>
			<label><spring:message code="reg.name"/><br>
			<input type="text" name="name" id="name">
			</label>
		</p>
		<p>
			<label><spring:message code="reg.pass"/><br>
			<input type="password" name="password" id="password">
			</label>
		</p>
		<p>
			<label><spring:message code="reg.passconfirm"/><br>
			<input type="password" name="confirmPassword" id="confirmPassword">
			</label>
		</p>
		
		<input type="submit" value="<spring:message code="regcom.btn"/>">
	</form>
<%@ include file = "/WEB-INF/view/bottom.jsp" %>