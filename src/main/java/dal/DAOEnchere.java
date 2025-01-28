package dal;

import bo.Enchere;

import java.util.List;

public interface DAOEnchere {
    Enchere create(Enchere enchere);

    List<Enchere> read();

    Enchere read(int noArticle);

    void update(Enchere enchere);

    void delete(Enchere enchere);

    void delete(int noArticle, int noUtilisateur);
}
