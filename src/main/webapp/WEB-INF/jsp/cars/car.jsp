<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/header.jsp" flush="false" />

<div id="content">
    <h2><fmt:message key="cars.form.title"/></h2>

	<c:url var="url" value="/cars/save.html" /> 
	<form:form action="${url}" commandName="car">
	    <form:hidden path="id" />
	
	    <fieldset>
	        <div class="form-row">
	            <label for="make"><fmt:message key="cars.form.make"/>:</label>
	            <span class="input"><form:input path="make" /></span>
	        </div>
	        <div class="form-row">
	            <label for="model"><fmt:message key="cars.form.model"/>:</label>
	            <span class="input"><form:input path="model" /></span>
	        </div>
	        <div class="form-buttons">
	            <div class="button"><input id="btnSave" type="submit" value="<fmt:message key="button.save"/>" /></div>
	        </div>
	    </fieldset>
	</form:form>
</div>

<jsp:include page="/footer.jsp" flush="false" />