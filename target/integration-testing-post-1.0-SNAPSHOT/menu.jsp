<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="navcontainer">
    <ul id="navlist">
        <li><a href="<%= request.getContextPath() %>/cars/list.html"><fmt:message key="menu.cars.list"/></a></li>
        <li><a href="<%= request.getContextPath() %>/cars/create.html"><fmt:message key="menu.cars.create"/></a></li>
    </ul>
</div>
