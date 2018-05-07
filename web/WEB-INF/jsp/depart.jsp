<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Quản lý nhóm</title>
        <base href="${pageContext.servletContext.contextPath}/">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
               
                <style>
                    
                    table th{
                        
                        vertical-align: middle;
                    }
                    a{
    text-decoration: none;
    color:inherit;
}
                </style>
    </head>
     <body class="is-preload">
        
       <form:form action="depart.htm" modelAttribute="depart">
		<div class="form-group">
			<label>Group Id</label>
			<form:input path="id" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label>Group Name</label>
			<form:input path="name" cssClass="form-control"/>
		</div>
                
                <div class="form-group">
			<label>Photo</label>
			<form:input type="file" path="images"  cssClass="form-control"/>
		</div>
                <hr/>

		<div class="form-group text-center">
			<button name="btnInsert" class="btn btn-default">Insert</button>
			<button name="btnUpdate" class="btn btn-default">Update</button>
			<button name="btnDelete" class="btn btn-default">Delete</button>
			<button name="btnReset" class="btn btn-default">Reset</button>
		</div>
	</form:form>
        <table class="table table-hover">
	<tr>
		<th>Group ID</th>
		<th>Group Name</th>
                <th>Photo</th>
		<th>Edit</th>
	</tr>
	<c:forEach var="m" items="${departs}">
	<tr>
		<td>${m.id}</td>
		<td>${m.name}</td>
                <td><img src="images/Groups/${m.images}"/></td>
		<td><a href="depart/${m.id}.htm">Edit</a></td>
	</tr>
	</c:forEach>
	</table>
                
              
    </body>
</html>
