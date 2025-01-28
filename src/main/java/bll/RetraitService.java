package bll;

import bo.Retrait;

import java.util.List;

public interface RetraitService {
    void addRetrait(Retrait retrait);

    void deleteRetrait(int noArticle, int noUtilisateur);

    List<Retrait> getRetrait();

    Retrait getRetraitByNoArticle(int noArticle);

    void updateRetrait(Retrait retrait);
}
