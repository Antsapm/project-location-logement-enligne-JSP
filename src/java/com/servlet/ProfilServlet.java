/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.beans.Actualite;
import com.beans.Utilisateur;
import com.database.PubMethod;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author andrianajoro
 */
public class ProfilServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        try {
            // recupérer la session............;
            HttpSession session = request.getSession();
            List<Utilisateur> userloged = (List<Utilisateur>) session.getAttribute("userloged");
            JSONObject jsonuserloged = (JSONObject) session.getAttribute("jsonuserloged");
            // userloged = (JSONObject) session.getAttribute("userloged");
            
            
            // *************** Publication *************************
            
            PubMethod maka = new PubMethod();
            
            Utilisateur oneUse = userloged.get(0);
            
            int id = oneUse.getId();
            List<Actualite> actu = maka.getSelfPubs(id);
            // *************** FIN/Publication *************************
            
            request.setAttribute("userloged", userloged);
            request.setAttribute("actualite", actu);
            request.setAttribute("jsonuserloged", jsonuserloged);
            this.getServletContext().getRequestDispatcher("/WEB-INF/profil-page.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
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
