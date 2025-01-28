package bll;

import bo.Enchere;

import java.util.List;

public interface EnchereService {
    void addEnchere(Enchere enchere);

    void deleteEnchere(int noArticle, int noUtilisateur);

    List<Enchere> getEnchere();

    Enchere getEnchereByNoArticleNNoUtilisateur(int noArticle, int noUtilisateur);

    void updateEnchere(Enchere enchere);
}
