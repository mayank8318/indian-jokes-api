package com.indian.jokes.api.server.service;


import com.indian.jokes.api.server.models.Joke;
import com.indian.jokes.api.server.repo.JokeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JokeService {
    private final JokeRepo jokeRepo;

    public JokeService(JokeRepo jokeRepo) {
        this.jokeRepo = jokeRepo;
    }

    public List<Joke> getAll() {
        return jokeRepo.findAll();
    }

    public Joke save(Joke joke) {
        return jokeRepo.save(joke);
    }
}
