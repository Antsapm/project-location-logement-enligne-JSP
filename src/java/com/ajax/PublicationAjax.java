/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ajax;

import com.beans.Publication;
import com.beans.Utilisateur;
import com.database.PubMethod;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
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

public class PublicationAjax extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // recupérer les infos.................
        Publication pub = new Publication();
        
        pub.setDescription(request.getParameter("description"));
        pub.setLocalisation(request.getParameter("localisation"));
        pub.setLoyer(request.getParameter("loyer"));
        pub.setJaime(false);
        pub.setDisponible(false);
        pub.setCommentaire(false);
        
        // ============== date
        LocalDateTime dateNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String dateFormat = dateNow.format(formatter);
        pub.setDate(dateFormat);
        
        // ============= heure
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("HH:mm:ss");
        String HeureFormat = dateNow.format(formater);
        pub.setHeure(HeureFormat);
        
        //=============== id
        HttpSession session = request.getSession();
        List<Utilisateur> userloged =  (List<Utilisateur>) session.getAttribute("userloged");
        //JSONArray userSession = new JSONArray();
        //userSession = (JSONArray) userloged.get("userSession");
        //JSONObject user0 = new JSONObject();
        Utilisateur user0 =  (Utilisateur) userloged.get(0);
        //JsonElement user = (JsonElement) session.getAttribute("userloged");
        //List<Utilisateur> ids = new Gson().fromJson(userSession, new TypeToken<List<Utilisateur>>(){}.getType());
        pub.setId( user0.getId());
        
        // le fichier...............;
        Part filePart = request.getPart("photo");
        
        // Récupération du nom du fichier
        String fileName = filePart.getSubmittedFileName();
        
        // Écriture du fichier sur le disque
        String uploadPath = "/home/andrianajoro/NetBeansProjects/ProjetJSP/Immobilier/web/assets/images/post";
        filePart.write(uploadPath + File.separator + fileName);
        pub.setPhoto(fileName);
        
        // insertiont dans la base de Donnée.........;
        PubMethod posterPub = new PubMethod();
        String rapport = null;
        try {
            rapport = posterPub.poster(pub);
        } catch (SQLException ex) {
            Logger.getLogger(PublicationAjax.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // la réponse de la requête AJAX.......................;
        try {    
            JSONObject jsonResponse = new JSONObject();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");

            jsonResponse.put("success", rapport);
            response.getWriter().write(jsonResponse.toString());
        } catch (JSONException ex) {
        }
        
        //this.getServletContext().getRequestDispatcher("/WEB-INF/home-page.jsp").forward(request, response);
        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
