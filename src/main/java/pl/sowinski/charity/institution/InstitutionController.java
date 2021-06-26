package pl.sowinski.charity.institution;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sowinski.charity.model.Institution;

import java.util.List;

@Controller
@RequestMapping("/admin/institution")
@Secured(value = "ADMIN")
public class InstitutionController {

    public final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/list")
    public String listInstitution(Model model){
        List<Institution> institutions =institutionService.getInstitution();
        model.addAttribute("institutions", institutions);
        return "institution/institution";
    }
    @GetMapping("/delete/{id:\\d+}")
    public String deleteInstitution(@PathVariable Long id){
        institutionService.delete(id);
        return "redirect:/admin/institution/list";
    }
    @GetMapping("/add")
    public String addInstitution(Model model){
        Institution institution = new Institution();
        model.addAttribute("institution", institution);
        return "institution/institutionForm";
    }
    @PostMapping("/add")
    public String addInstitutionForm(@ModelAttribute("institution") Institution institution){
        institutionService.add(institution);
        return "redirect:/admin/institution/list";
    }
    @GetMapping("/update/{id:\\d+}")
    public String updateInstitution(@PathVariable Long id, Model model){
        model.addAttribute("institution", institutionService.getInstitutionById(id));
        return "institution/institutionForm";
    }
    @PostMapping("/update/{id:\\d+}")
    public String updateInstitutionUpdate(@ModelAttribute("institution") Institution institution){
        institutionService.update(institution);
        return "redirect:/admin/institution/list";
    }
}


