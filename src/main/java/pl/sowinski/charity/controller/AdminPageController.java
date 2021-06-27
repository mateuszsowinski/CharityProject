package pl.sowinski.charity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sowinski.charity.model.Institution;
import pl.sowinski.charity.model.Role;
import pl.sowinski.charity.model.UserOperator;
import pl.sowinski.charity.repository.RoleRepository;
import pl.sowinski.charity.repository.UserRepository;
import pl.sowinski.charity.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
@Secured("ADMIN")
public class AdminPageController {

    public final UserService userService;
    public final UserRepository userRepository;
    public final RoleRepository roleRepository;


    public AdminPageController(UserService userService, UserRepository userRepository, RoleRepository roleRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @GetMapping("/panel")
    public String adminPanel() {
        return "adminPanel";
    }

    @GetMapping("/admin/list")
    public String adminList(Model model) {
        List<UserOperator> userOperatorList = userRepository.findByRole(1);
        List<UserOperator> adminList = userRepository.findByRole(2);
        model.addAttribute("userList", userOperatorList);
        model.addAttribute("adminList", adminList);
        return "admin/adminList";

    }
    @GetMapping("/rolechange/{id:\\d+}")
    public String adminRoleChange(@PathVariable Integer id){
        roleRepository.updateRole(2,id);
        return "redirect:/admin/admin/list";
    }
    @GetMapping("/delete/{id:\\d+}")
    public String adminDelete(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/admin/admin/list";
    }

    @GetMapping("/update/{id:\\d+}")
    public String adminUpdate(@PathVariable Long id, Model model){
        model.addAttribute("admin",userService.getUserById(id));
        return "admin/adminForm";
    }
    @PostMapping("/update/{id:\\d+}")
    public String adminUpdateForm(@ModelAttribute("admin") UserOperator userOperator){
        userService.update(userOperator);
        return "redirect:/admin/admin/list";
    }

    @GetMapping("/add")
    public String addAdmin(Model model){
        UserOperator admin = new UserOperator();
        model.addAttribute("admin", admin);
        return "admin/adminForm";
    }
    @PostMapping("/add")
    public String addAdminForm(@ModelAttribute("admin") UserOperator userOperator){
        userService.add(userOperator);
        return "redirect:/admin/admin/list";
    }
}

//    @GetMapping("/update/{id:\\d+}")
//    public String updateInstitution(@PathVariable Long id, Model model){
//        model.addAttribute("institution", institutionService.getInstitutionById(id));
//        return "institution/institutionForm";
//    }
//    @PostMapping("/update/{id:\\d+}")
//    public String updateInstitutionUpdate(@ModelAttribute("institution") Institution institution){
//        institutionService.update(institution);
//        return "redirect:/admin/institution/list";
//    }