package pl.sowinski.charity.user;

import org.springframework.web.bind.annotation.*;
import pl.sowinski.charity.model.UserOperator;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserControllerRest {

    private final UserService userService;

    public UserControllerRest(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserOperator> getUser() {
        return userService.getUser();
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

//
//    // Żądanie do Book Resource
//    @DeleteMapping("/{bookId:\\d+}")
//    public void deleteBook(@PathVariable Long bookId) {
//        bookService.deleteBook(bookId);
//    }
//}