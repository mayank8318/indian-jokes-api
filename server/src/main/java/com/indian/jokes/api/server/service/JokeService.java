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

    public Joke getById(long id) {
        return jokeRepo.findById(id)
                .orElse(null);
    }

    public Joke save(Joke joke) {
        return jokeRepo.save(joke);
    }

    public Joke getRandom() {
        List<Joke> jokeList = jokeRepo.findAll();
        if (jokeList.size() < 1)
            return null;

        return jokeList.get((int)Math.floor(Math.random() * jokeList.size()));
    }
}
