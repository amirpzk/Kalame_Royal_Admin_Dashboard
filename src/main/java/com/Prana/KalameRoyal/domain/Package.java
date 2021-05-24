package com.Prana.KalameRoyal.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "package")
public class Package {

    @Id
    private String id;
    private String name;
    private String modifier;
    private List<Word> threeLetterWords;
    private List<Word> fourLetterWords;
    private List<Word> fiveLetterWords;
    private boolean completed;

    public Package() {
        this.threeLetterWords = new ArrayList<>();
        this.fourLetterWords = new ArrayList<>();
        this.fiveLetterWords = new ArrayList<>();
        this.completed = false;
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

    public List<Word> getThreeLetterWords() {
        return threeLetterWords;
    }

    public void setThreeLetterWords(List<Word> threeLetterWords) {
        this.threeLetterWords = threeLetterWords;
    }

    public List<Word> getFourLetterWords() {
        return fourLetterWords;
    }

    public void setFourLetterWords(List<Word> fourLetterWords) {
        this.fourLetterWords = fourLetterWords;
    }

    public List<Word> getFiveLetterWords() {
        return fiveLetterWords;
    }

    public void setFiveLetterWords(List<Word> fiveLetterWords) {
        this.fiveLetterWords = fiveLetterWords;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return id.equals(aPackage.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
