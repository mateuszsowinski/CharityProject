package pl.sowinski.charity.role;

import org.springframework.stereotype.Service;
import pl.sowinski.charity.model.Role;
import pl.sowinski.charity.model.UserOperator;

import java.util.List;
@Service
public interface RoleService {
    List<Role> getRole();

}
