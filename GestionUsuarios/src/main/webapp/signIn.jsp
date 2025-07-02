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
        <div class="row justify-content-center m-5">
            <div class="col-6 bg-secondary p-4 ">
                <%  Map<String, String> errorMap = new TreeMap<>();
                    if (request.getAttribute("error_map") != null) {
                        errorMap = (Map<String, String>) request.getAttribute("error_map");
                    }
                %>
                <form action="Login" method="POST">
                    <fieldset>
                        <legend>Registrarse desde JSP</legend>
                        <div class="row">
                            <div>
                                <label for="inputUsername1" class="form-label mt-4">Usuario</label>
                                <input type="text" name="username" class="form-control" id="inputUsername1" aria-describedby="usernameHelp" style="background-color: <%= (errorMap.get("username") != null) ? "rgba(255,0,0,0.2)" : "white"%>" value=""
                                       placeholder="<%= (errorMap.get("username") != null) ? errorMap.get("username") : "Escribe el nombre"%>" required/>
                            </div>
                            <div>
                                <label for="inputEmail" class="form-label mt-4">Email</label>
                                <input type="email" name="email" class="form-control" id="inputEmail" aria-describedby="emailHelp" <%= (errorMap.get("email") != null) ? "rgba(255,0,0,0.2)" : "white"%>" value=""
                                       placeholder="<%= (errorMap.get("email") != null) ? errorMap.get("email") : "Escribe el email"%>" required/>
                            </div>
                            <div>
                                <label for="inputUsername1" class="form-label mt-4">Teléfono</label>
                                <input type="text" name="phone" class="form-control" id="inputUsername1" aria-describedby="usernameHelp" style="background-color: <%= (errorMap.get("phone") != null) ? "rgba(255,0,0,0.2)" : "white"%>" value=""
                                       placeholder="<%= (errorMap.get("phone") != null) ? errorMap.get("phone") : "Escribe el teléfono"%>" required/>
                            </div>
                            <div>
                                <label for="inputPwd1" class="form-label mt-4">Contraseña</label>
                                <input type="password" name="password" class="form-control" id="inputPwd1" aria-describedby="pwdHelp" <%= (errorMap.get("password") != null) ? "rgba(255,0,0,0.2)" : "white"%>" value=""
                                       placeholder="<%= (errorMap.get("password") != null) ? errorMap.get("password") : "Escribe el password"%>" required/>
                            </div>

                        </div>
                        <div class="d-flex gap-3 mt-4">
                            <input type="hidden" value="crear" name="actionBtn"/>
                            <button type="submit" class="btn btn-success flex-fill text-center" name="submitBtn">Crear</button>
                            <a href="login.jsp" class="btn btn-warning flex-fill text-center">Volver</a>
                        </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </body>

</html>
