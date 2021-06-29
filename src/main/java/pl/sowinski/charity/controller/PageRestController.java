package pl.sowinski.charity.controller;

import org.springframework.web.bind.annotation.*;
import pl.sowinski.charity.donation.DonationService;
import pl.sowinski.charity.model.Donation;
import pl.sowinski.charity.model.UserOperator;
import pl.sowinski.charity.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class PageRestController {

    private final UserService userService;
    private final DonationService donationService;

    public PageRestController(UserService userService, DonationService donationService) {
        this.userService = userService;
        this.donationService = donationService;
    }

    @GetMapping("/user")
    public List<UserOperator> getUser() {
        return userService.getUser();
    }
    @GetMapping("/donation")
    public List<Donation> getDonation() {
        return donationService.getDonation();
    }

    @GetMapping("/{userId:\\d+}")
    public UserOperator getByUserId(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/addUser")
    public UserOperator addUser(@RequestBody UserOperator user) {
        return userService.add(user);
    }
    @PutMapping("/update/{userId:\\d+}")
    public UserOperator update(@PathVariable Long userId, @RequestBody UserOperator userOperator){
        userOperator.setId(userId);
        userService.update(userOperator);
        return userOperator;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/delete/{userId:\\d+}")
    public void deleteUser(@PathVariable Long userId){
        userService.delete(userId);
    }

}
