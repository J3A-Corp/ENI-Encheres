package dal;

import bo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOUtilisateurSQL implements DAOUtilisateur{

    static final String SELECT_ALL = "SELECT * from utilisateur";
    static final String SELECT_BY_ID = "SELECT * from utilisateur where no_utilisateur = :no_utilisateur";
    static final String SELECT_BY_PSEUDO = "SELECT * from utilisateur where pseudo = :pseudo";
    static final String INSERT = "INSERT  INTO utilisateur ([pseudo],[nom],[prenom],[email],[telephone],[rue],[code_postal],[ville],[mot_de_passe],[credit],[administrateur]) VALUES (?,?,?,?,?,?,?,?,0,?)";
    static final String DELETE = "DELETE FROM utilisateur where no_utilisateur=?";
    static final String UPDATE = "UPDATE utilisateur set pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=?,credit=?,administrateur=? where id=?";



    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Autowired
    PasswordEncoder passwordEncoder;

    public DAOUtilisateurSQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;

    }

    @Override
    public int create(Utilisateur utilisateur) {
////j'ai rajouté ça pour voir si le bcrypt en base de donnée changeait qqchose
        String encodedPassword = passwordEncoder.encode(utilisateur.getMotDePasse());
        utilisateur.setMotDePasse(encodedPassword);
        var namedparameters = new MapSqlParameterSource();

        namedparameters.addValue("pseudo", utilisateur.getPseudo());
        namedparameters.addValue("nom", utilisateur.getNom());
        namedparameters.addValue("prenom", utilisateur.getPrenom());
        namedparameters.addValue("email", utilisateur.getEmail());
        namedparameters.addValue("telephone", utilisateur.getTelephone());
        namedparameters.addValue("rue", utilisateur.getRue());
        namedparameters.addValue("code_postal", utilisateur.getCodePostal());
        namedparameters.addValue("ville", utilisateur.getVille());
        namedparameters.addValue("mot_de_passe", utilisateur.getMotDePasse());
        namedparameters.addValue("credit", utilisateur.getCredit());
        namedparameters.addValue("admin", utilisateur.isAdministrateur());

        var keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(INSERT, namedparameters, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public List<Utilisateur> read() {
        return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(Utilisateur.class));
    }
    @Override
    public Utilisateur read(int noUtilisateur) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, BeanPropertyRowMapper.newInstance(Utilisateur.class), noUtilisateur);
    }

    @Override
    public void update(Utilisateur utilisateur) {
        jdbcTemplate.update(UPDATE, utilisateur.getPseudo(), utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getTelephone(), utilisateur.getRue(), utilisateur.getCodePostal(), utilisateur.getVille(), utilisateur.getMotDePasse(), utilisateur.getCredit(), utilisateur.isAdministrateur());
    }

    @Override
    public void delete(Utilisateur utilisateur) {
        delete(utilisateur.getNoUtilisateur());
    }

    @Override
    public void delete(int noUtilisateur) {
        jdbcTemplate.update(DELETE, noUtilisateur);
    }
}
}
