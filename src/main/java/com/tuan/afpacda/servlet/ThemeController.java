/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuan.afpacda.servlet;

import com.tuan.afpacda.beans.Theme;
import com.tuan.afpacda.dao.ThemeDao;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tuan
 */
@WebServlet(name = "ThemeController", urlPatterns = {"/themes"})
public class ThemeController extends HttpServlet {

//----------------------------------------------------------------------------

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         System.out.println("EntranceServlet::doGet");
          // Une connexion JDBC 
        Connection cnx = (Connection)getServletContext().getAttribute("connexion");
        // Un objet ThemeDao
        ThemeDao dao = new ThemeDao(cnx);
        List<Theme> listeThemes = new ArrayList();
        String action = "0";
        String view = "";
        
        // Présence d'un paramètre 'action' ?
        if(request.getParameter("action") != null){
            action = request.getParameter("action");      
        }
     
        switch(action){
            
            case "0":
                listeThemes = dao.liste();
       
                // On crée un attribut de requète 
                request.setAttribute("listeThemes", listeThemes);
                view = "themes/liste.jsp";
            break;
            
        }
        
        // On forward la requète
        request.getRequestDispatcher(view).forward(request, response); 

        
        System.out.println(listeThemes);
        
        
        // Liste de themes
        
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
         System.out.println("EntranceServlet::doPost");
       // processRequest(request, response);
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
