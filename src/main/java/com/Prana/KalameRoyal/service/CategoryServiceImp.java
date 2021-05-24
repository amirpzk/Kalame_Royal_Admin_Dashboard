package com.Prana.KalameRoyal.service;

import com.Prana.KalameRoyal.domain.Category;
import com.Prana.KalameRoyal.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {


    @Autowired
    private CategoryRepository repository;

    @Override
    public Category createCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public Category editCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public void deleteCategory(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Category getOneCategory(String id) {
        return repository.findById(id).get();
    }
}
