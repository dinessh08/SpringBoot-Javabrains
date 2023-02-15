package com.dinessh.service.discovery.moviecatalogservice.controller;

import com.dinessh.service.discovery.moviecatalogservice.model.Movie;
import com.dinessh.service.discovery.moviecatalogservice.model.UserCatalog;
import com.dinessh.service.discovery.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<UserCatalog> getMovieCatalog(@PathVariable("userId") String userId) {

        List<UserCatalog> userCatalog = new ArrayList<>();
        //Call the rating service to get rating information by userId
        UserRating userRating = getUserRating(userId);
        //Call the movie service to get movie information by movieId
        getUserCatalog(userCatalog, userRating);
        return userCatalog;
    }

    private void getUserCatalog(List<UserCatalog> userCatalog, UserRating userRating) {

        //Set the timeout factory to the restTemplate client calling the other APIs
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(2);
        RestTemplate restTemplate = new RestTemplate(factory);
        userRating.getRatings().stream().forEach(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/info/" + rating.getMovieId(), Movie.class);
            //Consolidate them to movie catalog
            UserCatalog catalog = new UserCatalog();
            userCatalog.add(new UserCatalog(movie.getId(), movie.getTitle(), rating.getRating(), movie.getDescription()));
        });
    }

    private UserRating getUserRating(String userId) {
        UserRating userRating = restTemplate.getForObject("http://localhost:8083/rating/" + userId, UserRating.class);
        return userRating;
    }
}
