<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       <title>update Jsr</title>
    </head>
    <body>
    <form action="updateJsr.htm" method="post">
      name:<input type='text' name ='name' value="${jsr.name}" />
      description:<input type='text' name='description' value="${jsr.description}" />
      <input  type="hidden" name="id" value= "${jsr.id}" />
      <input type='submit' value= 'update' />
    <%--   <p style='color:red'> 
        ${error}
   </p>   --%> 
    </form>
    
  </body>
</html>  
          
   

