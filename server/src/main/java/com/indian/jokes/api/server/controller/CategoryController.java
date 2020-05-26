package com.indian.jokes.api.server.controller;

import com.indian.jokes.api.server.models.Category;
import com.indian.jokes.api.server.models.Joke;
import com.indian.jokes.api.server.service.CategoryService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getCategories() {
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable long id) {
        Category category = categoryService.getById(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/jokes")
    public ResponseEntity<?> getCategoryJokes(@PathVariable long id) {
        Category category = categoryService.getById(id);
        if (category != null) {
            return new ResponseEntity<>(category.getJokes(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/jokes/random")
    public ResponseEntity<?> getCategoryJokeRandom(@PathVariable long id) {
        Category category = categoryService.getById(id);
        if (category != null) {
            List<Joke> jokeList = category.getJokes();
            if (jokeList.size() == 0)
                return new ResponseEntity<>(null, HttpStatus.OK);
            return new ResponseEntity<>(jokeList.get((int)Math.floor(Math.random() * jokeList.size())), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
