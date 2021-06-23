package pl.sowinski.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sowinski.charity.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
    }