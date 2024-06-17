package com.erf.task_manager.entities;

public class Task {
    private int id;
    private String description;
    private Boolean isCompleted;

    public Task(int id, String description, boolean b) {
        this.id = id;
        this.description = description;
        this.isCompleted = false;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for isCompleted
    public Boolean getIsCompleted() {
        return isCompleted;
    }

    // Setter for isCompleted
    public void setIsCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
