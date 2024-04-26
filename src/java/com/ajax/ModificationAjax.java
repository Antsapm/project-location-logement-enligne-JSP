/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ajax;

import com.beans.Login;
import com.beans.Utilisateur;
import com.database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author andrianajoro
 */
@MultipartConfig(
   fileSizeThreshold   = 1024 * 1024 * 1, // 1 MB
   maxFileSize         = 1024 * 1024 * 10, // 10 MB
   maxRequestSize      = 1024 * 1024 * 15  // 15 MB
)
public class ModificationAjax extends HttpServlet {

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
        try {
            // recup..............
            String pseudo = request.getParameter("pseudonyme");
            String id = request.getParameter("id");
            String adresse = request.getParameter("address");
            String mdps = request.getParameter("password");
            
            // traitement....................
            Database modifier = new Database();
            String rapport = modifier.modif(pseudo, adresse, id);
            // recréatution...............;;;;;
            
            Login mod = new Login();
            mod.setLogName(pseudo);
            mod.setLogPass(mdps);
            
            HttpSession newsession = request.getSession();
            Database data = new Database();
            List<Utilisateur> listUser = data.userSession(mod);
            
            List<Utilisateur> users = (List<Utilisateur>) newsession.getAttribute("userloged");
            Utilisateur user = users.get(0);
            user.setPseudo(pseudo);
            user.setAdresse(adresse);
            users.remove(0);
            users.add(user);
            
            JSONObject jsonUser = new JSONObject();
            jsonUser.put("userSession", users);
            response.setContentType("application/json");
            
            newsession.setAttribute("userloged", users);
            newsession.setAttribute("jsonuserloged", jsonUser);
            
            
            // renvoyer la reponse AJAX............
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("success", rapport);
        
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse.toString());
        } catch (SQLException | JSONException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
        
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
