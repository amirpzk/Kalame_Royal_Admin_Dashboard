package com.Prana.KalameRoyal.service;

import com.Prana.KalameRoyal.domain.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    Category editCategory(Category category);

    void deleteCategory(String id);

    List<Category> getAllCategories();

    Category getOneCategory(String id);

}
