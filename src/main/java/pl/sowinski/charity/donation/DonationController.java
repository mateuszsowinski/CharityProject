package pl.sowinski.charity.donation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sowinski.charity.model.Donation;

import javax.validation.Valid;

@Controller
public class DonationController {

   public final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }


    @GetMapping("/form")
    public String donation(Model model){
        Donation donation = new Donation();
        model.addAttribute("donation", donation);
        return "form";
    }
    @PostMapping("/form")
    public String donationForm(@ModelAttribute("donation")@Valid Donation donation, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        donationService.add(donation);
        return "redirect:/form_success";
    }

    @GetMapping("/form_success")
    public String formSuccess(){
        return "form_success";
    }
}


//
//    @PostMapping("/add")
//    public String addProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "productForm";
//        }
//        productService.add(product);
//        return "redirect:/app/product/list";
//    }