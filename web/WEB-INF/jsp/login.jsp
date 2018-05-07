

<%@page  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="login.htm" method="post">
         
                            
                            <div class="group">
                        <label  class="label">Username</label>
					<input name="id" type="text"  class="input"></div>
                       
                                
                                <div class="group">
					<label  class="label">Password</label>
                                        <input name="password"  type="password" class="input">
				</div>   
                           
                        <div class="group">
					<input type="submit" class="button" value="Log In">
				</div>
                        
        </form>
    </body>
</html>
