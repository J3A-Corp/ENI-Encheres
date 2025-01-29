package dal;

import bo.Utilisateur;
import bo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
package fr.eni.eni_encheres.dal;

import fr.eni.eni_encheres.bo.Utilisateur;

import java.util.List;

public interface DAOUtilisateur {


    int create(Utilisateur utilisateurs);

    List<Utilisateur> read();

    Utilisateur read(int id);

    void update(Utilisateur utilisateurs);

    void delete(Utilisateur utilisateurs);

    void delete(int noUtilisateur);
}
