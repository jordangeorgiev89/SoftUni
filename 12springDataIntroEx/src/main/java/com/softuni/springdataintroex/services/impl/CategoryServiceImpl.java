package com.softuni.springdataintroex.services.impl;
import com.softuni.springdataintroex.constants.GlobalConstants;
import com.softuni.springdataintroex.entities.Category;
import com.softuni.springdataintroex.repositories.CategoryRepository;
import com.softuni.springdataintroex.services.CategoryService;
import com.softuni.springdataintroex.utils.FileUtil;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }
    @Override
    public void seedCategories() throws IOException {

        if (this.categoryRepository.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtil
                .readFileContent(GlobalConstants.CATEGORIES_FILE_PATH);

        Arrays.stream(fileContent).forEach(r -> {
            Category category = new Category(r);

            this.categoryRepository.saveAndFlush(category);
        });
    }

    @Override
    public Category getCategoryById(Long id) {
        return this.categoryRepository.getOne(id);
    }
}
