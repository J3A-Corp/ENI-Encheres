package bll;
package fr.eni.eni_encheres.bll;

import bo.Retrait;

import java.util.List;
import fr.eni.eni_encheres.bo.Retrait;

public interface RetraitService {
    void addRetrait(Retrait retrait);


    void deleteRetrait(int noArticle);



    Retrait getRetraitByNoArticle(int noArticle);

    void updateRetrait(Retrait retrait);
}
