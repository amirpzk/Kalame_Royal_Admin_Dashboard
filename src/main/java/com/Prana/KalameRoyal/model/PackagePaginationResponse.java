package com.Prana.KalameRoyal.model;

import com.Prana.KalameRoyal.domain.Package;

public class PackagePaginationResponse {

    private String id;
    private String name;
    private boolean completed;
    private String modifier;

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

    public PackagePaginationResponse domainToModel(Package pack){
        this.setId(pack.getId());
        this.setName(pack.getName());
        this.setCompleted(pack.isCompleted());
        this.setModifier(pack.getModifier());
        return this;
    }
}
