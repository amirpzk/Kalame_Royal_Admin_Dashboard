package com.Prana.KalameRoyal.model;

import com.Prana.KalameRoyal.domain.Category;

public class DashboardCategoryResponse {


    private String id;
    private String name;

    public DashboardCategoryResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public DashboardCategoryResponse domainToModel(Category category){
        this.setId(category.getId());
        this.setName(category.getName());
        return this;
    }
}
