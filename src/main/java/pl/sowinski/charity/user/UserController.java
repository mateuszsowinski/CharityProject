package pl.sowinski.charity.user;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sowinski.charity.model.UserOperator;
import pl.sowinski.charity.repository.RoleRepository;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
@Secured(value = "ADMIN")
public class UserController {

    public final UserService userService;
    public final RoleRepository roleRepository;

    public UserController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }


    @GetMapping("/list")
    public String listUser(Model model) {
        List<UserOperator> users = userService.getUser();
        model.addAttribute("users", users);
        return "user/userList";
    }

    @GetMapping("/delete/{id:\\d+}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/admin/user/list";
    }

    @GetMapping("/update/{id:\\d+}")
    public String updateUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/userForm";
    }

    @PostMapping("/update/{id:\\d+}")
    public String updateUserForm(@ModelAttribute("user") UserOperator userOperator) {
        userService.update(userOperator);
        return "redirect:/admin/user/list";
    }
    @GetMapping("/add")
    public String addUser(Model model){
        UserOperator user = new UserOperator();
        model.addAttribute("user", user);
        return "user/userForm";
    }
    @PostMapping("/add")
    public String addUserForm(@ModelAttribute("user") UserOperator user){
        userService.add(user);
        return "redirect:/admin/user/list";
    }
}