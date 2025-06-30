<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Login Copy</title>
    </head>
    <body>
        <h1>INICIA SESION DESDE JSP</h1>
        <form action="Login" method="POST">
            <label>Usuario</label><br/>
            <input type="text" name="username" value=""
                   placeholder="Escribe el nombre" required/><br/>
            <label>Contraseña</label><br/>
            <input type="password" name="pwd" value=""
                   placeholder="Escribe la contraseña" required/><br/>
            <input type="hidden" value="entrar" name="actionBtn"/>
            <input type="submit" value="Enviar" name="submitBtn"/>
        </form><br/>
        <button><a href="signIn.jsp">Crear Usuario</a></button>
    </body>
</html>

