package pl.sowinski.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sowinski.charity.institution.InstitutionService;
import pl.sowinski.charity.model.Institution;
import pl.sowinski.charity.repository.DonationRepository;

import java.util.List;

@Controller
public class LandingPageController {

    public final InstitutionService institutionService;
    public final DonationRepository donationRepository;


    public LandingPageController(InstitutionService institutionService, DonationRepository donationRepository) {
        this.institutionService = institutionService;
        this.donationRepository = donationRepository;
    }


    @GetMapping("")
    public String startingPage(Model model){
        List<Institution> institutions = institutionService.getInstitution();
        int quantity = donationRepository.sumQuantity();
        int count = donationRepository.countDonationById();
        model.addAttribute("institution",institutions);
        model.addAttribute("quantity", quantity);
        model.addAttribute("count", count);
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(){return "login";}

    @GetMapping("/register")
    public String registerPage(){return "register";}

}
