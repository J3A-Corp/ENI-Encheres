package dal;

import bo.Retrait;

public interface DAORetrait {
    int create(Retrait retrait);

    Retrait read(int no_article);

    void update(Retrait retrait);

    void delete(Retrait retrait);

    void delete(int id);
}
