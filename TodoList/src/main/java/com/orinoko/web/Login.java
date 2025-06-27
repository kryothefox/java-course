package com.orinoko.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    private static final Map<String, String> usuarios = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        usuarios.put("Pepito", "1234");
        usuarios.put("Jaimito", "8812");
        usuarios.put("Manolito", "7712");
        usuarios.put("Mafalda", "0011");
        System.out.println("Estoy en el init");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Revisamos el metodo que esta usando la petición (request)
        System.out.println(request.getMethod());
        // Instanciamos el objeto que me permite navegar a otros puntos de mi aplicaciones
        RequestDispatcher rd;
        
        String username = request.getParameter("username");

        if (usuarios.containsKey(username)) {
            String pwd = request.getParameter("pwd");
            if (usuarios.get(username).equals(pwd)) {
                // request.setAttribute("bienvenida", "Hola ");
                rd = request.getRequestDispatcher("/wel");
            } else {
                // request.setAttribute("bienvenida", "Adios ");
                rd = request.getRequestDispatcher("/index.html");
            }
        }
        else{
            // request.setAttribute("bienvenida", "No se quien eres ");        
            // throw new ServletException();
            rd = null;
            response.sendRedirect(request.getContextPath()+"/wel");
        }
        rd.include(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("ME DESTRUYO!!!!!!!!!!!!!");
    }


}
