package bll;

import bo.Enchere;

import java.util.List;

public interface EnchereService {
    void addEnchere(Enchere enchere);

    void deleteEnchere(int noArticle, int no);

    List<Enchere> getEnchere();

    Enchere getEncherebyID(int noArticle);

    void updateEnchere(Enchere enchere);
}
