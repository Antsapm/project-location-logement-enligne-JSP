package com.ajax;

import com.beans.Utilisateur;
import com.dao.DaoFactory;
import org.json.JSONObject;
import com.dao.UtilisateurDao;
import com.database.Database;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.json.JSONException;

/**
 *
 * @author andrianajoro
 */
public class InsertionAjax extends HttpServlet {
    private UtilisateurDao utilisateurDao;
    
    public void init() throws ServletException{
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.utilisateurDao = daoFactory.recupUtilisateurDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Utilisateur user = new Utilisateur();
            user.setNom_util(request.getParameter("nom"));
            user.setPrenom_util(request.getParameter("prenom"));
            user.setPseudo(request.getParameter("pseudo"));
            user.setSexe(request.getParameter("sexe"));
            user.setMail(request.getParameter("mail"));
            user.setTelephone(request.getParameter("tel"));
            user.setAdresse(request.getParameter("adresse"));
            user.setPhoto("");
            user.setPassword(request.getParameter("password"));
            user.setActif(false);
            
            String rapport = "";
            Database data = new Database();
            String pseudoTest = data.control(user.getPseudo());
            if (pseudoTest == "match"){
                rapport = data.insererUtilisateur(user);
                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("success", rapport);
                response.setContentType("application/json");
                response.getWriter().write(jsonResponse.toString());
                
            }else{
                
                rapport = "Ce pseudo est déja utilisé. Veuillez en définir un autre";
                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("error", rapport);
                response.setContentType("application/json");
                response.getWriter().write(jsonResponse.toString());
                
            }
            
            //String rapport = utilisateurDao.ajouter(user);
            //request.setAttribute("rapport", rapport);
            //if (rapport !=""){
            //this.getServletContext().getRequestDispatcher("/WEB-INF/login-page.jsp").forward(request, response);
            //}
            
        } catch (JSONException ex) {
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
