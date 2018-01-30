package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping(value = "/CSAccount/login", method = RequestMethod.POST, produces = "application/json")
    public String Login(@RequestParam(value = "userName") String userName, @RequestParam(value = "password") String pwd) {
        if (pwd != null) {
            return "Hello " + userName;
        } else {
            return "Invalid login.";
        }
    }


    @RequestMapping(value = "/CSAccount/logout", method = RequestMethod.POST)
    public String logout() {

        return "Logout ";
    }

}
