package com.dinessh.service.discovery.movieratingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    private String userId;
    private int rating;
    private int movieId;
}
