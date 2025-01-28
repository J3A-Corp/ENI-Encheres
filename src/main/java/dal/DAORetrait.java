package dal;

import bo.Retrait;


import java.util.List;

public interface DAORetrait {
    int create(Retrait retrait);



    Retrait read(int noArticle);


    void update(Retrait retrait);

    void delete(Retrait retrait);




    void delete(int noArticle);

}
