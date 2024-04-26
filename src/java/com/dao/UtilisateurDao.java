
package com.dao;

import com.beans.Utilisateur;
import java.util.List;

/**
 *
 * @author andrianajoro
 */
public interface UtilisateurDao {
    String ajouter(Utilisateur user);
    List<Utilisateur> lister();
    
}
