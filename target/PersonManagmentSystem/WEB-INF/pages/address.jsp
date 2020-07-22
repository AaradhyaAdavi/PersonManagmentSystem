<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Address Page</title>
	<style type="text/css">
		.addrTable  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.addrTable td{font-family:Arial, sans-serif;font-size:16px;padding:10px 5px;border-style:solid;border-width:2px;overflow:hidden;word-break:normal;border-color:#ccc;color:#1F2421;background-color:#EDE1C7;}
		.addrTable th{font-family:Arial, sans-serif;font-size:16px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:2px;overflow:hidden;word-break:normal;border-color:#ccc;color:#000000;background-color:#FACF57;}
		.addrTable .addrTable-4eph{background-color:#C0C0C0}
	</style>
	
</head>
<body>

	 <c:if test="${empty person.personId}">
	<h1>
	<spring:message code="AddAddress"/>
	</h1>
	</c:if> 


<c:url var="addAction" value="/address/addaddress" ></c:url>

<form:form action="${addAction}" modelAttribute="address">
<table>
	 <c:if test="${not empty address.addressId}">
	<h1><spring:message code="EditAddress"/></h1>
	 <tr>
		<td>
			<form:label path="addressId">
				<spring:message code="AddressID"/>
			</form:label>
		</td>
		<td>
			<form:input path="addressId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="addressId" />
		</td> 
	</tr> 
	</c:if> 
	<tr>
		<td>
			<form:label path="street">
				<spring:message code="Street"/>
			</form:label>
		</td>
		<td>
			<form:input path="street" />
		</td> 
	</tr>
		<tr>
		<td>
			<form:label path="city">
				<spring:message code="City"/>
			</form:label>
		</td>
		<td>
			<form:input path="city" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="state">
				<spring:message code="State"/>
			</form:label>
		</td>
		<td>
			<form:input path="state" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="postalCode">
				<spring:message code="PostalCode"/>
			</form:label>
		</td>
		<td>
			<form:input path="PostalCode" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="person_id">
				<spring:message code="PersonID"/>
			</form:label>
		</td>
		<td>
			<form:input path="person_id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="person_id" />
		</td> 
	</tr>
	 <c:if test="${not empty address.person_id}">
		<tr>
			<td colspan="2">
					<input type="submit" value="<spring:message code="Submit"/>" />
			</td>
		</tr>
	</c:if>
</table>	
</form:form>
<br>

<c:if test="${not empty addrList}">
<h3><spring:message code="PersonList"/></h3>
	<table class="addrTable" >
	<tr>
		<th width="80">Address ID</th>
		<th width="120">Street</th>
		<th width="120">City</th>
		<th width="60">State</th>
		<th width="60">Postal Code</th>
		<th width="60">Person ID</th>
		<th width="60">Edit Address</th>
		<th width="60">Delete Address</th>
	</tr>
	<c:forEach items="${addrList}" var="address">
		<tr>
			<td>${address.addressId}</td>
			<td>${address.street}</td>
			<td>${address.city}</td>
			<td>${address.state}</td>
			<td>${address.postalCode}</td>
			<td>${address.person_id}</td>
			<td><a href="<c:url value='/address/edit/${address.addressId}' />" >Edit</a></td>
			<td><a href="<c:url value='/address/remove/${address.addressId}' />" >Delete</a></td>
			
			
		</tr>
	</c:forEach>
	</table>
</c:if>
<br/>
<br/>
<a href="<c:url value='/persons' />" >Back To Add Person</a>

</body>
</html>