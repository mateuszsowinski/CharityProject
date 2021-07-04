package pl.sowinski.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sowinski.charity.model.UserOperator;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserOperator, Long> {

    UserOperator findByEmail(String email);
    UserOperator findByUserName(String name);
    @Query(value = "SELECT * FROM user_role JOIN user_operator uo on uo.id = user_role.user_id WHERE role_id = ?1", nativeQuery = true)
    List<UserOperator> findByRole(int roleId);

}
