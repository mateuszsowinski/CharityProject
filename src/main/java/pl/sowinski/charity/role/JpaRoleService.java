package pl.sowinski.charity.role;

import org.springframework.stereotype.Service;
import pl.sowinski.charity.model.Role;
import pl.sowinski.charity.repository.RoleRepository;

import java.util.List;

@Service
public class JpaRoleService implements RoleService {

    public final RoleRepository roleRepository;

    public JpaRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getRole() {
        return roleRepository.findAll() ;
    }
}
