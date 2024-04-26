/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ajax;

import com.beans.Login;
import com.beans.Utilisateur;
import com.database.Database;
import java.io.IOException;
import com.google.gson.Gson;
import com.servlet.HomeServlet;
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
public class SeConnecterAjax extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // récupérer les infos du login.....
            Login user = new Login();
            user.setLogName(request.getParameter("username"));
            user.setLogPass(request.getParameter("pass"));
            
            // savoir si son pseudo est déjà dans la base....
            String rapport = "";
            Database data = new Database();
            String pseudoTest = data.control(user.getLogName());
            if (pseudoTest == "match"){
                // le pseudo n'est pas trouvé et renvoyer l'erreur.......
                rapport = "Aucun compte référant trouvé";
                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("error", rapport);
                response.setContentType("application/json");
                response.getWriter().write(jsonResponse.toString());
                
            }else{
                // consuleter le mot de passe
                boolean allow = data.seConnecter(user);
                if (allow){
                    // le mot de passe est correct....
                    
                    // recupération des infos de l'user connecté...........
                    List<Utilisateur> listUser = data.userSession(user);
                    
                    JSONObject jsonlistUser = new JSONObject();
                    jsonlistUser.put("userSession", listUser);
                    // création d'une variable type session qui contient l'info de l'user connecté...........
                    
                    
                    HttpSession session = request.getSession();
                    session.setAttribute("userloged", listUser);
                    session.setAttribute("jsonuserloged", jsonlistUser);
                    // renvoyer la reponses de success....
                    rapport = "Bonjour " + user.getLogName();
                    
                    JSONObject jsonResponse = new JSONObject();
                    jsonResponse.put("success", rapport);
                    response.setContentType("application/json");
                    response.getWriter().write(jsonResponse.toString());
                }else{
                    // le mot de pass est incorrect....;
                    rapport = "Mot de passe Incorect. Réessayer";
                    JSONObject jsonResponse = new JSONObject();
                    jsonResponse.put("error", rapport);
                    response.setContentType("application/json");
                    response.getWriter().write(jsonResponse.toString());
                }
                
                
            }
        } catch (JSONException ex) {
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
