package pl.sowinski.charity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sowinski.charity.donation.DonationService;
import pl.sowinski.charity.model.Donation;
import pl.sowinski.charity.model.UserOperator;
import pl.sowinski.charity.user.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/rest")
public class PageRestController {

    private final UserService userService;
    private final DonationService donationService;

    public PageRestController(UserService userService, DonationService donationService) {
        this.userService = userService;
        this.donationService = donationService;
    }

    @GetMapping
    public List<UserOperator> getUser() {
        return userService.getUser();
    }

    @GetMapping("/{userId:\\d+}")
    public ResponseEntity<UserOperator> getByUserId(@PathVariable Long userId) {
        try {
            UserOperator userOperator = userService.getUserById(userId);
            return new ResponseEntity<UserOperator>(userOperator, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return  new ResponseEntity<UserOperator>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public UserOperator addUser(@RequestBody UserOperator user) {
        return userService.add(user);
    }

    @PutMapping("/{userId:\\d+}")
    public UserOperator update(@PathVariable Long userId, @RequestBody UserOperator userOperator) {
        userOperator.setId(userId);
        userService.update(userOperator);
        return userOperator;
    }

    @DeleteMapping("/{userId:\\d+}")
    public void deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
    }

}
