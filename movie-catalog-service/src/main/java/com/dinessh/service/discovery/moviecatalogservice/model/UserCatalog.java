package com.dinessh.service.discovery.moviecatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCatalog {

    private int movieId;
    private String movieTitle;
    private int rating;
    private String movieDescription;
}
