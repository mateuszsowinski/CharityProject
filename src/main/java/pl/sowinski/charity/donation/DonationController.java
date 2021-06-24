package pl.sowinski.charity.donation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sowinski.charity.category.CategoryService;
import pl.sowinski.charity.institution.InstitutionService;
import pl.sowinski.charity.model.Category;
import pl.sowinski.charity.model.Donation;
import pl.sowinski.charity.model.Institution;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/app")
public class DonationController {

   public final DonationService donationService;
   public final CategoryService categoryService;
   public final InstitutionService institutionService;

    public DonationController(DonationService donationService, CategoryService categoryService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }


    @GetMapping("/form")
    public String donation(Model model){
        Donation donation = new Donation();
        List<Category> categories = categoryService.getCategory();
        List<Institution> institutions = institutionService.getInstitution();
        model.addAttribute("categories", categories);
        model.addAttribute("donation", donation);
        model.addAttribute("institution", institutions);
        return "form";
    }
    @PostMapping("/form")
    public String donationForm(@ModelAttribute("donation")@Valid Donation donation, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        donationService.add(donation);
        return "redirect:/app/form_success";
    }

    @GetMapping("/form_success")
    public String formSuccess(){
        return "form_success";
    }
}
