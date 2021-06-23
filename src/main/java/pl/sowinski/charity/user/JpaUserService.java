package pl.sowinski.charity.user;

import org.springframework.stereotype.Service;
import pl.sowinski.charity.model.UserOperator;
import pl.sowinski.charity.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JpaUserService implements UserService {
    public final UserRepository userRepository;

    public JpaUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserOperator add(UserOperator addUser) {
        return userRepository.save(addUser);
    }

    @Override
    public Optional<UserOperator> getUserById(Long idUser) {
        return userRepository.findById(idUser);
    }

    @Override
    public List<UserOperator> getUser() {
        return userRepository.findAll();
    }

    @Override
    public void update(UserOperator updateUser) {
        userRepository.save(updateUser);
    }

    @Override
    public void delete(Long idUser) {
        userRepository.deleteById(idUser);
    }
}
