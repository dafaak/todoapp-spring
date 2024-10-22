package com.dafaak.todoapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String goToLoginPage(ModelMap model) {

        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String goToWelcomepage(@RequestParam String name, @RequestParam String password, ModelMap model) {

        model.put("name", name);
        model.put("password", password);

        // Authenticate

        if (authenticationService.authenticateUser(name, password)) {
            model.remove("errorMessage");
            return "welcome";
        }

        model.put("errorMessage", "Invalid credentials");
        return "login";


    }
}
