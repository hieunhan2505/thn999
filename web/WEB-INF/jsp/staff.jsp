<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <head>
        <meta charset="UTF-8">
        <base href="${pageContext.servletContext.contextPath}/">
        <title>Idols</title>
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
  
     
     
	<form:form action="staff.htm" modelAttribute="staff">
		<div class="form-group">
			<label>Id</label>
			<form:input path="id" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label>Name</label>
			<form:input path="name" cssClass="form-control"/>
		</div>
                
                <div class="form-group">
			<label>Gender</label>
			<div>
				<form:radiobutton path="gender" value="true" label="Male"/>
				<form:radiobutton path="gender" value="false" label="Female"/>
			</div>
		</div>
                        
                      <div class="form-group">
			<label>Group</label>
			<form:select path="depart.id" cssClass="form-control"
				items="${departs}" itemValue="id" itemLabel="name"/>
		</div>
                
                <div class="form-group">
			<label>Photo</label>
			<form:input type="file" path="photo" cssClass="form-control"/>
		</div>

		<div class="form-group text-center">
			<button name="btnInsert" class="btn btn-default">Insert</button>
			<button name="btnUpdate" class="btn btn-default">Update</button>
			<button name="btnDelete" class="btn btn-default">Delete</button>
			<button name="btnReset" class="btn btn-default">Reset</button>
		</div>
	</form:form>
	
	<table class="table table-hover">
	<tr>
		<th>Id</th>
		<th>Name</th>
                <th>Gender</th>
                <th>Photo</th>
                <th>Group</th>
		<th></th>
	</tr>
	<c:forEach var="m" items="${staffs}">
	<tr>
		<td>${m.id}</td>
		<td>${m.name}</td>
                <td><c:if test = "${m.gender == 'true'}">Male</c:if>
                <c:if test = "${m.gender == 'false'}">Female</c:if></td>
                <td><img src="images/Idols/${m.photo}"/></td>
                <td><img src="images/Groups/${m.depart.images}"/></td>
		<td><a href="staff/${m.id}.htm">Edit</a></td>
	</tr>
	</c:forEach>
	</table>
                
                
          
</body>
</html>
