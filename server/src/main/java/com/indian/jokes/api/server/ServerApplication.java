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

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
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
            System.out.println("test");
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("santabanta.txt");
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            String line = "";

            StringBuilder jokeText = new StringBuilder();
            String start = "JOKE_START";
            String end = "JOKE_END";
            boolean jokerunnning = false;

            Category category = new Category("santabanta.txt".substring(0, "santabanta.txt".indexOf('.')), new ArrayList<>());
            category = categoryService.save(category);

            while((line = bf.readLine()) != null) {
                System.out.println(line);
                if (jokerunnning) {
                    if (line.contentEquals(end)) {
                        jokerunnning = false;
                        Joke joke = new Joke(jokeText.toString(), category);
                        jokeService.save(joke);
                        System.out.println("jokes");
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
                /*InputStream in2 = getClass().getClassLoader().getResourceAsStream("jokes/" + fileName);
                BufferedReader bf2 = new BufferedReader(new InputStreamReader(in2));

                StringBuilder jokeText = new StringBuilder();
                String start = "JOKE_START";
                String end = "JOKE_END";
                boolean jokerunnning = false;

                Category category = new Category(fileName.substring(0, fileName.indexOf('.')), new ArrayList<>());
                category = categoryService.save(category);

                String line = "";
                while((line = bf2.readLine()) != null) {
                    if (jokerunnning) {
                        if (line.contentEquals(end)) {
                            jokerunnning = false;
                            Joke joke = new Joke(jokeText.toString(), category);
                            jokeService.save(joke);
                            System.out.println("jokes");
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

                bf2.close();*/
            }
            bf.close();
        };
    }

}
