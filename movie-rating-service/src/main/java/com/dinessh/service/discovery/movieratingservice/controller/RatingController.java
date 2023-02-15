package com.dinessh.service.discovery.movieratingservice.controller;

import com.dinessh.service.discovery.movieratingservice.model.Rating;
import com.dinessh.service.discovery.movieratingservice.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @GetMapping("/{userId}")
    public UserRating getUserRating(@PathParam("userId") String userId) {

        UserRating userRating = new UserRating();
        userRating.setRatings(List.of(new Rating("01", 5, 1),
                new Rating("01", 3, 2),
                new Rating("01", 1, 3),
                new Rating("01", 4, 4)));
        return userRating;
    }
}
