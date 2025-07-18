<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <jsp:include page="header.jsp"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Login</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.3.7/morph/bootstrap.min.css"/>
    </head>
    <body>
        <div class="row justify-content-center">
            <div class="col-6 bg-secondary p-4 mb-5">
                <form action="Login" method="POST">
                    <fieldset>
                      <legend>Inicia Sesión desde JSP</legend>
                      <div class="row">
                        <div>
                          <label for="username" class="form-label mt-4">Usuario</label>
                          <input name="username" type="text" class="form-control" id="username" aria-describedby="usernameHelp" placeholder="Escribe el nombre">
                        </div>
                        <div>
                          <label for="password" class="form-label mt-4">Contraseña</label>
                          <input name="password" type="password" class="form-control" id="username" aria-describedby="pwdHelp" placeholder="Escribe la contraseña">
                        </div>
                        <c:if test="${not empty error_msg}">
                            <p class="text-danger">${error_msg}</p>
                        </c:if>
                        <div>
                            <input type="hidden" value="entrar" name="actionBtn"/>
                            <button style="margin-top: 2em" type="submit" class="btn btn-success col-5" name="submitBtn">Enviar</button>
                            <a style="margin-top: 2em;" href="signIn.jsp" class="btn btn-info col-5">Crear Usuario</a>
                        </div>
                      </div>
                    </fieldset>
                  </form>
            </div>
        </div>
    </body>
</html>
