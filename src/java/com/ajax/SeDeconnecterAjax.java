/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ajax;

import com.database.Database;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author andrianajoro
 */
public class SeDeconnecterAjax extends HttpServlet {

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // recuperation des infos.............
        String idList = request.getParameter("idList");
        List<Integer> ids = new Gson().fromJson(idList, new TypeToken<List<Integer>>(){}.getType());
        
        // traitement..............
        for (var i=0; i<ids.size(); i++ ){
            int idr = ids.get(i);
            Database db = new Database();
            db.SeDeconnecter(idr);
        }
        
        //destruction de la session current..........
        HttpSession session = request.getSession();
        session.invalidate();
        
        // renvoyer l'info............
        JSONObject jsonResponse = new JSONObject();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try {
            jsonResponse.put("success", "Traitement effectué avec succès!");
        } catch (JSONException ex) {
            Logger.getLogger(SeDeconnecterAjax.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.getWriter().write(jsonResponse.toString());
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
