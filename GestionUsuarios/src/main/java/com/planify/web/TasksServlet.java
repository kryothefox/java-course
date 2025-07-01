/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.planify.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.planify.db.TaskDAO;
import com.planify.models.AppUser;
import com.planify.models.Tasks;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;

/**
 *
 * @author manana
 */

public class TasksServlet extends HttpServlet {


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
                
                try (TaskDAO DAO = new TaskDAO()) {
                    
                    String id = request.getParameter("taskId") != null ? request.getParameter("taskId") : "0";
                    
                    if(!id.equals("0")){
                        DAO.delete(Integer.valueOf(request.getParameter("taskId")));
                    }
                    request.getRequestDispatcher("/tasks.jsp").forward(request, response);

                } catch (Exception e) {
                    System.err.println(e.getCause() + " - " + e.getMessage());
                }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        try (TaskDAO DAO = new TaskDAO()) {
            Tasks task = getTasks(request);
            DAO.create(task);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } catch (ConstraintViolationException e) {
            // TODO: Implement Constraint violation exception!!!11
        } catch (Exception e){
              System.err.println(e.getCause() + " - " + e.getMessage());
        }


    }

    
    private Tasks getTasks(HttpServletRequest request) {
        String taskName = request.getParameter("taskName");
        String taskDesc = request.getParameter("taskDescription");
        String taskState = request.getParameter("taskState");
        String taskLimitDate = request.getParameter("limitDate");
        return new Tasks(taskName,taskDesc,new Date(taskLimitDate),taskState);
    }


}
