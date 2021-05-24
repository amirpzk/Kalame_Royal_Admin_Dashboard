package com.Prana.KalameRoyal.model;

import com.Prana.KalameRoyal.domain.Category;
import com.Prana.KalameRoyal.domain.Word;

import java.util.ArrayList;
import java.util.List;

public class WordWithInformationResponse {

    private String id;
    private String word;
    private int score;
    private boolean hidden;
    private List<DashboardCategoryResponse> categories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public List<DashboardCategoryResponse> getCategories() {
        return categories;
    }

    public void setCategories(List<DashboardCategoryResponse> categories) {
        this.categories = categories;
    }

    public WordWithInformationResponse domainToModel(Word word){
        this.setId(word.getId());
        this.setHidden(word.isHidden());
        this.setScore(word.getScore());
        this.setWord(word.getWord());

        List<DashboardCategoryResponse> categories = new ArrayList<>();
        for (Category category : word.getCategories()) {
            DashboardCategoryResponse response = new DashboardCategoryResponse();
            response.domainToModel(category);
            categories.add(response);
        }
        this.setCategories(categories);

        return this;
    }

}
