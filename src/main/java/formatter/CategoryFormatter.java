package formatter;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import service.category.CategoryService;
import service.category.ICategoryService;

import java.text.ParseException;
import java.util.Locale;


@Component
public class CategoryFormatter implements Formatter<Category> {


    private ICategoryService categoryService;

    public CategoryFormatter() {
    }

    public CategoryFormatter(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        Category category = categoryService.findById(Long.parseLong(text));
        return category;
    }

    @Override
    public String print(Category object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
