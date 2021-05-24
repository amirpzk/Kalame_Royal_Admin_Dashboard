package com.Prana.KalameRoyal.model;

import com.Prana.KalameRoyal.domain.Package;
import com.Prana.KalameRoyal.domain.Word;

import java.util.ArrayList;
import java.util.List;

public class NormalModeGamePlayPackageResponse {

    private String id;
    private String name;
    private boolean completed;
    private String modifier;
    private List<NormalGamePlayWordResponse> threeLetterWords;
    private List<NormalGamePlayWordResponse> fourLetterWords;
    private List<NormalGamePlayWordResponse> fiveLetterWords;


    public NormalModeGamePlayPackageResponse() {
        this.threeLetterWords = new ArrayList<>();
        this.fourLetterWords = new ArrayList<>();
        this.fiveLetterWords = new ArrayList<>();
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

    public List<NormalGamePlayWordResponse> getThreeLetterWords() {
        return threeLetterWords;
    }

    public void setThreeLetterWords(List<NormalGamePlayWordResponse> threeLetterWords) {
        this.threeLetterWords = threeLetterWords;
    }

    public List<NormalGamePlayWordResponse> getFourLetterWords() {
        return fourLetterWords;
    }

    public void setFourLetterWords(List<NormalGamePlayWordResponse> fourLetterWords) {
        this.fourLetterWords = fourLetterWords;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public List<NormalGamePlayWordResponse> getFiveLetterWords() {
        return fiveLetterWords;
    }

    public void setFiveLetterWords(List<NormalGamePlayWordResponse> fiveLetterWords) {
        this.fiveLetterWords = fiveLetterWords;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public NormalModeGamePlayPackageResponse domainToModel(Package pack){
        this.setId(pack.getId());
        this.setName(pack.getName());
        this.setCompleted(pack.isCompleted());
        this.setModifier(pack.getModifier());

        List<NormalGamePlayWordResponse> threeLetterWordsModel = new ArrayList<>();
        for (Word threeLetterWord : pack.getThreeLetterWords()) {
            NormalGamePlayWordResponse threeLetterModel = new NormalGamePlayWordResponse();
            threeLetterModel.domainToModel(threeLetterWord);
            threeLetterWordsModel.add(threeLetterModel);
        }
        this.setThreeLetterWords(threeLetterWordsModel);

        List<NormalGamePlayWordResponse> fourLetterWordsModel = new ArrayList<>();
        for (Word fourLetterWord : pack.getFourLetterWords()) {
            NormalGamePlayWordResponse fourLetterModel = new NormalGamePlayWordResponse();
            fourLetterModel.domainToModel(fourLetterWord);
            fourLetterWordsModel.add(fourLetterModel);
        }
        this.setFourLetterWords(fourLetterWordsModel);

        List<NormalGamePlayWordResponse> fiveLetterWordsModel = new ArrayList<>();
        for (Word fiveLetterWord : pack.getFiveLetterWords()) {
            NormalGamePlayWordResponse fiveLetterModel = new NormalGamePlayWordResponse();
            fiveLetterModel.domainToModel(fiveLetterWord);
            fiveLetterWordsModel.add(fiveLetterModel);
        }
        this.setFiveLetterWords(fiveLetterWordsModel);

        return this;
    }
}
