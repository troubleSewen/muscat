package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartupController {

    @RequestMapping("/")
    public String index()
    {
        return "Start spring bootxxxx!";
    }
}
