package com.softuni.springdataintroex.services;
import com.softuni.springdataintroex.entities.Category;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface CategoryService {
        void seedCategories() throws IOException;

        Category getCategoryById(Long id);
}
