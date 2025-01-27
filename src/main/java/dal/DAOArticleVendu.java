package dal;

import bo.ArticleVendu;

import java.util.List;

public interface DAOArticleVendu {
    void create(ArticleVendu articleVendu);

    List<ArticleVendu> read();

    ArticleVendu read(int noArticle);

    void update(ArticleVendu articleVendu);

    void delete(ArticleVendu articleVendu);

    void delete(int noArticle);




}
