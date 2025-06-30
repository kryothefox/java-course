<%@page import="java.util.Map"%>
<%@page import="java.util.TreeMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP SignIn</title>
    </head>
    <body>
        <h1>REGISTRARSE DESDE JSP</h1>
        <%  Map<String, String> errorMap = new TreeMap<>();
            if (request.getAttribute("error_map") != null) {
                errorMap = (Map<String, String>)request.getAttribute("error_map");
            }
        %>
        <form action="Login" method="POST">
            <label>Usuario</label><br/>
            <input type="text" name="username" style="background-color: <%= (errorMap.get("username")!=null)?"rgba(255,0,0,0.2)":"white" %>" value=""
                   placeholder="<%= (errorMap.get("username")!=null)?errorMap.get("username"):"Escribe el nombre" %>" required/><br/>
            <%-- <input type="text" name="username" value="" placeholder="Escribe el nombre" required/>
            <p style="color:red"><%= (errorMap.get("username")!=null)?errorMap.get("username"):"" %></p> --%>              
   
            <label>Email</label><br/>
            <input type="text" name="email" style="background-color: <%= (errorMap.get("email")!=null)?"rgba(255,0,0,0.2)":"white" %>" value=""
                   placeholder="<%= (errorMap.get("email")!=null)?errorMap.get("email"):"Escribe el email" %>" required/><br/>
            <%-- <input type="text" name="email"
                   placeholder="Escribe el email" required/>
            <p style="color:red"><%= (errorMap.get("email")!=null)?errorMap.get("email"):"" %></p> --%>
            
            <label>Telefono</label><br/>
            <input type="text" name="phone" style="background-color: <%= (errorMap.get("phone")!=null)?"rgba(255,0,0,0.2)":"white" %>" value=""
                   placeholder="<%= (errorMap.get("phone")!=null)?errorMap.get("phone"):"Escribe el teléfono" %>" required/><br/>
            <%-- <input type="text" name="phone" value=""
                   placeholder="Escribe el teléfono"/>
            <p style="color:red"><%= (errorMap.get("phone")!=null)?errorMap.get("phone"):"" %></p> --%>
            <label>Contraseña</label><br/>
            <input type="password" name="pwd" style="background-color: <%= (errorMap.get("pwd")!=null)?"rgba(255,0,0,0.2)":"white" %>" value=""
                   placeholder="<%= (errorMap.get("pwd")!=null)?errorMap.get("pwd"):"Escribe la contraseña" %>" required/><br/>
            <%-- <input type="password" name="pwd" value=""
                   placeholder="Escribe la contraseña" required/>
            <p style="color:red"><%= (errorMap.get("pwd")!=null)?errorMap.get("pwd"):"" %></p> --%>
            <input type="hidden" value="crear" name="actionBtn"/>
            <input type="submit" value="Enviar" name="submitBtn"/>
        </form><br/>
        <button><a href="login.jsp">Iniciar Sesion</a></button>
    </body>
</html>
