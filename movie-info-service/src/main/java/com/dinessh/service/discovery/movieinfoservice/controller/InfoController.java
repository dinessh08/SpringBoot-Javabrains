package com.dinessh.service.discovery.movieinfoservice.controller;

import com.dinessh.service.discovery.movieinfoservice.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("info")
public class InfoController {

    static List<Movie> movies = List.of(new Movie(1, "Vikram", "Action", "One of LCU best movie"),
            new Movie(2, "Love Today", "RomCom", "Best movie this pongal"),
            new Movie(3, "Thunivu", "Action", "AK's best"),
            new Movie(4, "Varisu", "Senti", "Some dialogurs are good"),
            new Movie(5, "Cobra", "Action", "Vikram wasted his efforts"));

    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") int movieId) {

        return movies.stream().filter(m -> m.getId() == movieId).findFirst().orElse(null);
    }
}
