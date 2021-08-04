package pl.sowinski.charity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sowinski.charity.config.JavaMailSenderImpl;
import pl.sowinski.charity.institution.InstitutionService;
import pl.sowinski.charity.model.Institution;
import pl.sowinski.charity.model.UserOperator;
import pl.sowinski.charity.repository.DonationRepository;
import pl.sowinski.charity.user.UserService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LandingPageController {


    private final Logger logger = LoggerFactory.getLogger(LandingPageController.class);

    public final InstitutionService institutionService;
    public final DonationRepository donationRepository;
    public final UserService userService;
    public final JavaMailSenderImpl javaMailSenderImpl;


    public LandingPageController(InstitutionService institutionService, DonationRepository donationRepository, UserService userService, JavaMailSenderImpl javaMailSenderImpl) {
        this.institutionService = institutionService;
        this.donationRepository = donationRepository;
        this.userService = userService;
        this.javaMailSenderImpl = javaMailSenderImpl;
    }


    @GetMapping("")
    public String startingPage(Model model) {
        List<Institution> institutions = institutionService.getInstitution();
        Integer quantity = donationRepository.sumQuantity();
        Integer count = donationRepository.countDonationById();
        model.addAttribute("institution", institutions);
        model.addAttribute("quantity", quantity);
        model.addAttribute("count", count);
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("userName", new UserOperator());
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        UserOperator user = new UserOperator();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerForm(@ModelAttribute("user") UserOperator user) throws MessagingException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userService.add(user);
        javaMailSenderImpl.sendMail(user.getEmail(), "Witaj, zarejestrowałeś się na stronie...","Witaj, "+ user.getUserName()+" zostałeś zarejestrowany na stronie",true);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

}
