package bll;

import bo.Categorie;

import java.util.List;

public interface CategorieService {
    void addCategorie(Categorie categorie);

    void deleteCategorie(int noArticle);

    List<Categorie> getCategorie();

    Categorie getCategoriebyID(int noArticle);

    void updateCategorie(Categorie categorie);
}
