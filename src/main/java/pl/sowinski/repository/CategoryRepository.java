package pl.sowinski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sowinski.charity.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
