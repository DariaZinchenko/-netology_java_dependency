package ru.netology.manager;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@NoArgsConstructor
public class MovieManager {

    private Movie[] movies = new Movie[0];
    @Getter private int amount = 10;

    public MovieManager(int amount) {
        if (amount > 0)
            this.amount = amount;
        else
            this.amount = 0;
    }

    public void add(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getLastMovies() {
        int length;

        if (movies.length < amount) {
            length = movies.length;
        } else {
            length = amount;
        }
        Movie[] result = new Movie[length];

        for (int i = 0; i < result.length; i++){
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }

        return result;
    }
}