package pl.sowinski.charity.category;

import org.springframework.stereotype.Service;
import pl.sowinski.charity.model.Category;
import pl.sowinski.charity.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JpaCategoryService implements CategoryService {

    private final CategoryRepository categoryRepository;

    public JpaCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category add(Category addCategory) {
        return categoryRepository.save(addCategory);
    }

    @Override
    public Category getCategoryById(Long idCategory) {
        Optional<Category> getCategoryById = categoryRepository.findById(idCategory);
        return getCategoryById.get();
    }

    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void update(Category updateCategory) {
        categoryRepository.save(updateCategory);
    }

    @Override
    public void delete(Long idCategory) {
        categoryRepository.deleteById(idCategory);
    }
}
