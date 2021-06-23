package pl.sowinski.charity.user;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.sowinski.charity.model.Institution;
import pl.sowinski.charity.model.UserOperator;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    UserOperator add(UserOperator addUser);
    Optional<UserOperator> getUserById(Long idUser);
    List<UserOperator> getUser();
    void update(UserOperator updateUser);
    void delete(Long idUser);
}
