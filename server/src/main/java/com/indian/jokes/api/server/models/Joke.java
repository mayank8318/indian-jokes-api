package com.indian.jokes.api.server.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Joke {
    @Id
    @GeneratedValue
    private Long id;

    private String text;

    @ManyToOne()
    private Category category;

    public Joke(String text, Category category) {
        this.text = text;
        this.category = category;
    }

    public Joke() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
