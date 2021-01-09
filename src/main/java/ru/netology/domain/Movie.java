package ru.netology.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {

    private int id;
    private String imageUrl;
    private String name;
    private String genre;
}
