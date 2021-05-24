package com.Prana.KalameRoyal.model;

import com.Prana.KalameRoyal.domain.Word;

import java.util.UUID;

public class NormalGamePlayWordResponse {

    private String id;
    private String word;
    private int score;


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


    public NormalGamePlayWordResponse domainToModel(Word word){
        this.setId(word.getId());
        this.setScore(word.getScore());
        this.setWord(word.getWord());
        return this;
    }

}
