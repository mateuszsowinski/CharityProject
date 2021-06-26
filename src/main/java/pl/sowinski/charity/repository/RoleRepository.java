package pl.sowinski.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sowinski.charity.model.Role;
@Repository
@Transactional

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
    @Modifying
    @Query(value = "UPDATE user_role SET role_id = ?1 WHERE user_id = ?2", nativeQuery = true)
    void updateRole(Integer roleId, Integer userId);
}