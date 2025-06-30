<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Login</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.3.7/darkly/bootstrap.min.css"/>
    </head>
    <body>
        <div class="row justify-content-center">
            <div class="col-6 bg-secondary p-4 mb-5">
                <form action="Login" method="POST">
                    <fieldset>
                      <legend>Inicia Sesión desde JSP</legend>
                      <div class="row">
                        <div>
                          <label for="inputUsername1" class="form-label mt-4">Usuario</label>
                          <input type="text" class="form-control" id="inputUsername1" aria-describedby="usernameHelp" placeholder="Escribe el nombre">
                        </div>
                        <div>
                          <label for="inputPwd1" class="form-label mt-4">Contraseña</label>
                          <input type="password" class="form-control" id="inputPwd1" aria-describedby="pwdHelp" placeholder="Escribe la contraseña">
                        </div>
                        <c:if test="${not empty error_msg}">
                            <p class="text-danger">${error_msg}</p>
                        </c:if>
                        <div>
                            <input type="hidden" value="entrar" name="actionBtn"/>
                            <button type="submit" class="btn btn-success col-5" name="submitBtn">Enviar</button>
                            <a href="signIn.jsp" class="btn btn-info col-5">Crear Usuario</a>
                        </div>
                      </div>
                    </fieldset>
                  </form>
            </div>
        </div>
    </body>
</html>
