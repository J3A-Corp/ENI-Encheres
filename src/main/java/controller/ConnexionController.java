package controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.security.provisioning.UserDetailsManager;

@Controller
public class ConnexionController {
    protected final Log logger = LogFactory.getLog(getClass());


    //Mise en commentaire momentanée pour éviter les complications lors du développement
    @Autowired
    //private UserDetailManager userDetailManager;

    @GetMapping("/login")
    public String login() {
        logger.info("Login Page");
        return "login";
    }

}
