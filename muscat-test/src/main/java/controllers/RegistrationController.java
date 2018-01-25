package controllers;

import dto.CustomerDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @RequestMapping("/registration")
    public CustomerDTO customer(@RequestParam(value="companyName") String companyName){
        return new CustomerDTO(companyName);
    }
}
