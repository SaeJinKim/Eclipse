<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<%@ include file = "/WEB-INF/view/top.jsp" %>



<h2><spring:message code="log.ing"/></h2>
	<form:form modelAttribute="loginRequest">
    <form:errors />
		<p>
			<label><spring:message code="log.email"/><br>
       		<form:input path="email" />
        	<form:errors path="email"/>
			</label>
		</p>
		<p>
			<label><spring:message code="log.pass"/><br>
        	<form:password path="password" />
        	<form:errors path="password"/>
			</label>
		</p>
		<p>
       		<label><spring:message code="check" />:
       		<form:checkbox path="check"/> 
       		</label>
  		</p>
		<input type="submit" value="<spring:message code="log.btn"/>">
	</form:form>

<%@ include file = "/WEB-INF/view/bottom.jsp" %>