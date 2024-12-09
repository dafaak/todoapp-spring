package com.dafaak.todoapp.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    private AuthenticationService authenticationService;
//
//    public LoginController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model) {
        model.put("name", "Israel");
        return "welcome";
    }

//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String goToWelcomepage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//
//        model.put("name", name);
//        model.put("password", password);
//
//        // Authenticate
//
//        if (authenticationService.authenticateUser(name, password)) {
//            model.remove("errorMessage");
//            return "welcome";
//        }
//
//        model.put("errorMessage", "Invalid credentials");
//        return "login";
//
//
//    }
}
