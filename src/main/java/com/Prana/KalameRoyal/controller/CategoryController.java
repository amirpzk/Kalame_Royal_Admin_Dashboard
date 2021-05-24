package com.Prana.KalameRoyal.controller;


import com.Prana.KalameRoyal.domain.Category;
import com.Prana.KalameRoyal.model.CategoryResponse;
import com.Prana.KalameRoyal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody Category category){
        Category saved = service.createCategory(category);
        CategoryResponse response = new CategoryResponse().domainToModel(saved);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getOne(@PathVariable("id") String id){
        Category founded = service.getOneCategory(id);
        CategoryResponse response = new CategoryResponse().domainToModel(founded);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll(){
        List<Category> categories = service.getAllCategories();
        List<CategoryResponse> responses = new ArrayList<>();
        for (Category category : categories) {
            CategoryResponse response = new CategoryResponse().domainToModel(category);
            responses.add(response);
        }
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CategoryResponse> editCategory(@RequestBody Category category){
        Category edited = service.editCategory(category);
        CategoryResponse response = new CategoryResponse().domainToModel(edited);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        service.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
