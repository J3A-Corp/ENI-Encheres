package bll;

import bo.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    void addUtilisateur(Utilisateur utilisateur);

    void deleteUtilisateur(int noUtilisateur);

    List<Utilisateur> getUtilisateur();

    Utilisateur getUtilisateurByNoUtilisateur(int noUtilisateur);


}
