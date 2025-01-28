package bll;

import bo.Retrait;

import java.util.List;

public interface RetraitService {
    void addRetrait(Retrait retrait);


    void deleteRetrait(int noArticle);



    Retrait getRetraitByNoArticle(int noArticle);

    void updateRetrait(Retrait retrait);
}
