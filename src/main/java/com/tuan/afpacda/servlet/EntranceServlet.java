/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuan.afpacda.servlet;

import com.tuan.afpacda.utils.ConnexionFactory;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tuan
 */
public class EntranceServlet extends HttpServlet {
    
    /**
     *
     * @param config
     * @throws ServletException
     */
    @Override
     public void init(ServletConfig config) throws ServletException {
        System.out.println("EntranceServlet::INIT");
        
         // Important !
        super.init(config);

        // On instancie le driver
        try {
            Class.forName(config.getInitParameter("driver")).newInstance();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException ==> " + ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println("InstantiationException ==> " + ex.getMessage());
        } catch (IllegalAccessException ex) {
             System.out.println("IllegalAccessException ==> " + ex.getMessage());
        }

        // On instancie une ConnexionFactory
        ConnexionFactory cnxFactory = new ConnexionFactory();
        // On nourrit l'objet
        cnxFactory.setDbUser(config.getInitParameter("user"));
        cnxFactory.setDbPass(config.getInitParameter("pass"));
        cnxFactory.setDbUrl(config.getInitParameter("url"));

        // On instancie une Connection
        Connection cnx = cnxFactory.getConnexion();
        System.out.println("CNX ================> " + cnx);

        // On crée un attribut d'application
        getServletContext().setAttribute("connexion", cnx);
        System.out.println(getServletContext().getAttribute("connexion"));

    }


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
     //   processRequest(request, response);
     
     //on FORWARD la requette http
     request.getRequestDispatcher("themes").forward(request, response);
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
