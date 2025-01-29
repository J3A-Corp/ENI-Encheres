package dal;
package fr.eni.eni_encheres.dal;

import bo.Enchere;
import fr.eni.eni_encheres.bo.Enchere;

import java.util.List;

public interface DAOEnchere {
    Enchere create(Enchere enchere);

    List<Enchere> read();

    Enchere read(int noArticle);

    void update(Enchere enchere);

    void delete(Enchere enchere);

    void delete(int noArticle, int noUtilisateur);
}
