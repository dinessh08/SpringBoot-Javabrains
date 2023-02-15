package com.dinessh.service.discovery.moviecatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private int Id;
    private String title;
    private String genere;
    private String description;
}
