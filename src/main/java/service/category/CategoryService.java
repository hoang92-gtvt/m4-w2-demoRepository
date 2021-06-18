package service.category;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ICategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService{
    @Autowired
    public ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void save(Category category) {
       categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
      categoryRepository.delete(id);
    }
}
