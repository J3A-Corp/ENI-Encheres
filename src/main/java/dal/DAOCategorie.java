package dal;

import bo.Categorie;
import bo.Categorie;

import java.util.ArrayList;
import java.util.List;

public interface DAOCategorie {

    int create(Categorie categorie);

    List<Categorie> read();

    Categorie read(int noArticle);

    void update(Categorie categorie);

    void delete(Categorie categorie);

    void delete(int noCategorie);

}
