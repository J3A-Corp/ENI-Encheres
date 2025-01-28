package dal;

import bo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface DAOUtilisateur {


    int create(Utilisateur utilisateur);

    List<Utilisateur> read();

    Utilisateur read(int id);

    void update(Utilisateur utilisateur);

    void delete(Utilisateur utilisateur);

    void delete(int noUtilisateur);
}
