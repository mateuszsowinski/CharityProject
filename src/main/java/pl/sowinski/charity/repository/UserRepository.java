package pl.sowinski.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sowinski.charity.model.UserOperator;

@Repository
public interface UserRepository extends JpaRepository<UserOperator, Long> {

}
