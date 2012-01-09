<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<jsp:include page="/header.jsp" flush="false" />

<div id="content">
    <h2><fmt:message key="cars.list.title"/></h2>
	<display:table name="cars" id="car">
	    <display:column property="id" title="ID" />
	    <display:column property="make" title="Make"/>
	    <display:column property="model" title="Model"/>
	    <display:column>
	        <c:url var="editUrl" value="/cars/info.html">
	            <c:param name="id" value="${car.id}" />
	        </c:url>
	        <c:url var="deleteUrl" value="/cars/delete.html">
	            <c:param name="id" value="${car.id}" />
	        </c:url>
	        <a href='<c:out value="${editUrl}"/>'><fmt:message key="button.edit"/></a>
	        <a href='<c:out value="${deleteUrl}"/>'><fmt:message key="button.delete"/></a>
	    </display:column>
	</display:table>
</div>

<jsp:include page="/footer.jsp" flush="false" />