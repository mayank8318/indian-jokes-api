package com.indian.jokes.api.server;

import com.indian.jokes.api.server.models.Category;
import com.indian.jokes.api.server.models.Joke;
import com.indian.jokes.api.server.service.CategoryService;
import com.indian.jokes.api.server.service.JokeService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(CategoryService categoryService, JokeService jokeService) {
        return args -> {
//            File file[] = (new File(getClass().getResource("jokes").toURI())).listFiles();
            File file[] = new ClassPathResource("jokes").getFile().listFiles();
            for (File f : file) {
                StringBuilder jokeText = new StringBuilder();
                String start = "JOKE_START";
                String end = "JOKE_END";
                boolean jokerunnning = false;

                Category category = new Category(f.getName().substring(0, f.getName().indexOf('.')), new ArrayList<>());
                category = categoryService.save(category);

                Scanner scanner = new Scanner(f);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (jokerunnning) {
                        if (line.contentEquals(end)) {
                            jokerunnning = false;
                            Joke joke = new Joke(jokeText.toString(), category);
                            jokeService.save(joke);

                            jokeText = new StringBuilder();
                        } else {
                            jokeText.append(line).append("\n");
                        }
                    } else {
                        if (line.contentEquals(start))
                        {
                            jokerunnning = true;
                        }
                    }
                }
                scanner.close();
            }

//            Category category = new Category("santabanta", new ArrayList<>());
//            category = categoryService.save(category);
//
//            Joke joke = new Joke("This is a fun joke", null);
//            joke.setCategory(category);
//            jokeService.save(joke);
//
//            Joke joke2 = new Joke("This is another fun joke", null);
//            joke2.setCategory(category);
//            jokeService.save(joke2);
        };
    }

}
