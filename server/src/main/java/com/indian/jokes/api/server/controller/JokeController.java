package com.indian.jokes.api.server.controller;

import com.indian.jokes.api.server.models.Joke;
import com.indian.jokes.api.server.service.JokeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/jokes")
public class JokeController {
    private final JokeService jokeService;


    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getAllJokes() {
        return new ResponseEntity<>(jokeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJokeById(@PathVariable long id) {
        Joke joke = jokeService.getById(id);
        if (joke != null) {
            return new ResponseEntity<>(joke, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/random")
    public ResponseEntity<?> randomJoke() {
        return new ResponseEntity<>(jokeService.getRandom(), HttpStatus.OK);
    }
}
