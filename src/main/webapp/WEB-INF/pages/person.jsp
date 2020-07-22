<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Person Page</title>
	<style type="text/css">
		.perTable  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.perTable td{font-family:Arial, sans-serif;font-size:16px;padding:10px 5px;border-style:solid;border-width:2px;overflow:hidden;word-break:normal;border-color:#ccc;color:#1F2421;background-color:#EDE1C7;}
		.perTable th{font-family:Arial, sans-serif;font-size:16px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:2px;overflow:hidden;word-break:normal;border-color:#ccc;color:#000000;background-color:#FACF57;}
		.perTable .perTable-4eph{background-color:#C0C0C0}
	</style>
</head>
<body>

	<c:if test="${empty person.personId}">
	<h1>
	<spring:message code="AddPerson"/>
	</h1>
	</c:if>


<c:url var="addAction" value="/person/add" ></c:url>

<form:form action="${addAction}" modelAttribute="person">
<table>
	<c:if test="${not empty person.personId}">
	<h1><spring:message code="EditPerson"/></h1>
	<tr>
		<td>
			<form:label path="personId">
				<spring:message code="PersonID"/>
			</form:label>
		</td>
		<td>
			<form:input path="personId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="personId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="firstName">
				<spring:message code="FirstName"/>
			</form:label>
		</td>
		<td>
			<form:input path="firstName" />
		</td> 
	</tr>
		<tr>
		<td>
			<form:label path="lastName">
				<spring:message code="LastName"/>
			</form:label>
		</td>
		<td>
			<form:input path="lastName" />
		</td> 
	</tr>
	
	
	<tr>
		<td colspan="2">
				<input type="submit"
					value="<spring:message code="Submit"/>" />
		</td>
	</tr>
</table>	
</form:form>
<br>

<c:if test="${not empty personList}">
<h3><spring:message code="PersonList"/></h3>
	<br>
	<h2>Persons Count:${personList.size()}</h2>
	<table  class="perTable">
	<tr>
		<th width="80">ID</th>
		<th width="120">First Name</th>
		<th width="120">Last Name</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
		<th width="60">Add Address</th>
	</tr>
	<c:forEach items="${personList}" var="person">
		<tr>
			<td>${person.personId}</td>
			<td>${person.firstName}</td>
			<td>${person.lastName}</td>
			<td><a href="<c:url value='/person/edit/${person.personId}' />" >Edit</a></td>
			<td><a href="<c:url value='person/remove/${person.personId}' />" >Delete</a></td>
			<td><a href="<c:url value='/address/add/${person.personId}' />" >Add Address</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>