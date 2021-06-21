package pl.sowinski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sowinski.charity.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
