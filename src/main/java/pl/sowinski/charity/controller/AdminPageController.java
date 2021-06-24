package pl.sowinski.charity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@Secured("ADMIN")
public class AdminPageController {

    @GetMapping("/panel")
    public String adminPanel(){
        return "adminPanel";
    }
}
