package com.indian.jokes.api.server.service;

import com.indian.jokes.api.server.models.Category;
import com.indian.jokes.api.server.repo.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    public Category getById(long id) {
        return categoryRepo.findById(id)
                .orElse(null);
    }

    public Category save(Category c) {
        return categoryRepo.save(c);
    }
}
