<%@page import="java.util.Map"%>
<%@page import="java.util.TreeMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Sign Up</title>
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.3.7/morph/bootstrap.min.css"/>
    </head>
    <body>
        <div class="row justify-content-center">
        <div class="col-6 bg-secondary p-4 mb-5">

        <%  Map<String, String> errorMap = new TreeMap<>();
            if (request.getAttribute("error_map") != null) {
                errorMap = (Map<String, String>)request.getAttribute("error_map");
            }
        %>
        
        <form action="Login" method="POST">
        <fieldset>
        <legend>REGISTRARSE DESDE JSP</legend>
            
            <label>Usuario</label><br/>
            <input type="text" name="username" style="background-color: <%= (errorMap.get("username")!=null)?"rgba(255,0,0,0.2)":"white" %>" value=""
                   placeholder="<%= (errorMap.get("username")!=null)?errorMap.get("username"):"Escribe el nombre" %>" required/><br/>
                    
   
            <label>Email</label><br/>
            <input type="text" name="email" style="background-color: <%= (errorMap.get("email")!=null)?"rgba(255,0,0,0.2)":"white" %>" value=""
                   placeholder="<%= (errorMap.get("email")!=null)?errorMap.get("email"):"Escribe el email" %>" required/><br/>
           
            
            <label>Telefono</label><br/>
            <input type="text" name="phone" style="background-color: <%= (errorMap.get("phone")!=null)?"rgba(255,0,0,0.2)":"white" %>" value=""
                   placeholder="<%= (errorMap.get("phone")!=null)?errorMap.get("phone"):"Escribe el teléfono" %>" required/><br/>
           
            <label>Contraseña</label><br/>
            <input type="password" name="password" style="background-color: <%= (errorMap.get("pwd")!=null)?"rgba(255,0,0,0.2)":"white" %>" value=""
                   placeholder="<%= (errorMap.get("pwd")!=null)?errorMap.get("pwd"):"Escribe la contraseña" %>" required/><br/>
          
            <input type="hidden" value="crear" name="actionBtn"/>
            <input type="submit" value="Crear Usuario" name="submitBtn"/>
        </form><br/>
        <button><a href="login.jsp">Iniciar Sesion</a></button>
    </body>
</html>
