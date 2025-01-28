package dal;

import bo.Categorie;

import java.util.ArrayList;
import java.util.List;

public interface DAOCategorie {

    List<Categorie> getCategories();
    Categorie getCategoriesById(int id);
    Categorie getCategoriesByName(String name);
    int addCategorie(Categorie categories);
    void updateCategorie(Categorie categories);
    void deleteCategorie(Categorie categories);

}
