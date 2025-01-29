package dal;
package fr.eni.eni_encheres.dal;

import bo.ArticleVendu;
import fr.eni.eni_encheres.bo.ArticleVendu;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOArticleVenduSQL implements DAOArticleVendu {

    static final String SELECT_ALL = "select * from Articles_Vendus";
    static final String SELECT_BY_ID = "select * from Articles_Vendus where no_article=?";
    static final String INSERT = "INSERT  INTO Article_Vendu ([nom_article],[descritpion],[date_debut_encheres],[date_fin_encheres],[prix_initial],[prix_vente],[no_utilisateur],[no_categorie]) VALUES (:no_article,:nom_article,:descritpion,:date_debut_encheres,:date_fin_encheres,:prix_initial,:prix_vente,:no_utilisateur,:no_categorie)";
    static final String DELETE = "DELETE FROM Article_Vendu where no_article=?";
    static final String UPDATE = "UPDATE Article_Vendu set nom_article=?,descritpion=?,date_debut_encheres=?,date_fin_encheres=?,prix_initial=?,prix_vente=?,no_utilisateur=?,no_categorie=? where no_article=?";

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DAOArticleVenduSQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public int create(ArticleVendu articleVendu) {
        var namedparameters = new MapSqlParameterSource();
        namedparameters.addValue("nom_article", articleVendu.getNomArticle());
        namedparameters.addValue("descritpion", articleVendu.getDescription());
        namedparameters.addValue("date_debut_encheres", articleVendu.getDateDebutEncheres());
        namedparameters.addValue("date_fin_encheres", articleVendu.getDateFinEncheres());
        namedparameters.addValue("prix_initial", articleVendu.getMiseAPrix());
        namedparameters.addValue("prix_vente", articleVendu.getPrixVente());
        namedparameters.addValue("no_utilisateur", articleVendu.getUtilisateur().getNoUtilisateur());
        namedparameters.addValue("no_categorie", articleVendu.getCategorie().getNoCategorie());
        var keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(INSERT, namedparameters, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<ArticleVendu> read() {
        return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(ArticleVendu.class));
    }

    @Override
    public ArticleVendu read(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, BeanPropertyRowMapper.newInstance(ArticleVendu.class), id);
    }

    @Override
    public void update(ArticleVendu articleVendu) {
        jdbcTemplate.update(UPDATE, articleVendu.getNoArticle(), articleVendu.getNomArticle(), articleVendu.getDescription(), articleVendu.getDateDebutEncheres(), articleVendu.getDateFinEncheres(), articleVendu.getMiseAPrix(), articleVendu.getPrixVente(), articleVendu.getUtilisateur().getNoUtilisateur(), articleVendu.getCategorie().getNoCategorie());
    }

    @Override
    public void delete(ArticleVendu articleVendu) {
        delete(articleVendu.getNoArticle());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE, id);
    }






}
