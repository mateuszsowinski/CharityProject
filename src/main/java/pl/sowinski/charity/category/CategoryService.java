package pl.sowinski.charity.category;

import org.springframework.stereotype.Service;
import pl.sowinski.charity.model.Category;
import pl.sowinski.charity.model.Institution;

import java.util.List;
import java.util.Optional;
@Service
public interface CategoryService {

        Category add(Category addCategory);
        Optional<Category> getCategoryById(Long idCategory);
        List<Category> getCategory();
        void update(Category updateCategory);
        void delete(Long idCategory);


}
