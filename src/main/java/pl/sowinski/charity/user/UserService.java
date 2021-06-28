package pl.sowinski.charity.user;

import org.springframework.stereotype.Service;
import pl.sowinski.charity.model.UserOperator;

import java.util.List;

@Service
public interface UserService {
    UserOperator add(UserOperator addUser);
    UserOperator getUserById(Long idUser);
    List<UserOperator> getUser();
    void update(UserOperator updateUser);
    void delete(Long idUser);
}
