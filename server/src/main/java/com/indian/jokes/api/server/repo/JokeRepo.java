package com.indian.jokes.api.server.repo;

import com.indian.jokes.api.server.models.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeRepo extends JpaRepository<Joke, Long> {
}
