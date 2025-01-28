package dal;

import bo.Utilisateurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface DAOUtilisateur {


    int create(Utilisateurs utilisateurs);

    List<Utilisateurs> read();

    Utilisateurs read(int id);

    void update(Utilisateurs utilisateurs);

    void delete(Utilisateurs utilisateurs);

    void delete(int noUtilisateur);
}
