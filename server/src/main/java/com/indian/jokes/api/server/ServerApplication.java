package com.indian.jokes.api.server;

import com.indian.jokes.api.server.models.Category;
import com.indian.jokes.api.server.models.Joke;
import com.indian.jokes.api.server.service.CategoryService;
import com.indian.jokes.api.server.service.JokeService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(CategoryService categoryService, JokeService jokeService) {
        return args -> {
            Category category = new Category("santabanta", new ArrayList<>());
            category = categoryService.save(category);

            Joke joke = new Joke("This is a fun joke", null);
            joke.setCategory(category);
            jokeService.save(joke);
        };
    }

}
