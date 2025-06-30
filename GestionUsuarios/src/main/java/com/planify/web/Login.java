package com.planify.web;

import com.planify.db.UserDAO;
import com.planify.models.AppUser;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Estoy en el Init");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //System.out.println(request.getMethod());

        try {
            switch (request.getParameter("actionBtn")) {
                case "entrar" ->
                    enter(request, response);
                case "crear" ->
                    create(request, response, getAppUser(request));
                default ->
                    throw new AssertionError();
            }
        } catch (Exception e) {
            if (e instanceof ConstraintViolationException cve) {
                //StringBuilder sb = new StringBuilder();
                Map<String, String> errorMap = new TreeMap();
                cve.getConstraintViolations().forEach(v -> {
                    String[] messages = v.getMessage().split("-");
                    String key = messages[0];
                    String value = messages[1];
                    errorMap.put(key, value);
                });
                request.setAttribute("error_map", errorMap);
                request.getRequestDispatcher("/signIn.jsp").forward(request, response);
            } else {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "Error desconocido", e);
            }
        }

    }

    private void enter(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        try (UserDAO udb = new UserDAO()) {
            AppUser currentUser = udb.findByName(username);
            if (currentUser != null) {
                checkPWD(currentUser, pwd, request, response);
            } else {
                request.setAttribute("error_msg", "No existe ningún usuario con este nombre");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }

    }

    private void checkPWD(AppUser currentUser,String pwd,HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        if (currentUser.getPassword().equals(pwd)) {
            //request.setAttribute("bienvenida", "Hola");
            request.getRequestDispatcher("/wel").include(request, response);
        } else {
            request.setAttribute("error_msg", "No existe ningún usuario con este nombre");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response, AppUser au)
            throws ServletException, IOException, ConstraintViolationException {
        try (UserDAO udb = new UserDAO()) {
            if (udb.create(au)) {
                System.out.println("Usuario creado con éxito");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                System.out.println("Usuario no creado");
                request.getRequestDispatcher("/signIn.jsp").forward(request, response);
            }
        }
    }

    private AppUser getAppUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone");
        if (phoneNumber.isEmpty()) {
            phoneNumber = "123456789";
        }
        return new AppUser(username, pwd, email, phoneNumber);
    }

    @Override
    public void destroy() {
        System.out.println("Me destruyo");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
