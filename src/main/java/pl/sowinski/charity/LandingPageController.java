package pl.sowinski.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sowinski.charity.institution.JpaInstitutionService;
import pl.sowinski.charity.model.Institution;

import java.util.List;

@Controller
public class LandingPageController {

    public final JpaInstitutionService jpaInstitutionService;

    public LandingPageController(JpaInstitutionService jpaInstitutionService) {
        this.jpaInstitutionService = jpaInstitutionService;
    }

    @GetMapping("")
    public String startingPage(Model model){
        List<Institution> institutions = jpaInstitutionService.getInstitution();
        model.addAttribute("institution",institutions);
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(){return "login";}

    @GetMapping("/register")
    public String registerPage(){return "register";}

}
