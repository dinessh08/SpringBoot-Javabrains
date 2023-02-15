package com.dinessh.service.discovery.moviecatalogservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserRating {

    private List<Rating> ratings;
}
