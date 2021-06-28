package pl.sowinski.charity.category;

import org.springframework.stereotype.Service;
import pl.sowinski.charity.model.Category;

import java.util.List;

@Service
public interface CategoryService {

        Category add(Category addCategory);
        Category getCategoryById(Long idCategory);
        List<Category> getCategory();
        void update(Category updateCategory);
        void delete(Long idCategory);


}
