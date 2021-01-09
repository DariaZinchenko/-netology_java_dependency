package ru.netology.manager;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

@NoArgsConstructor
public class AfishaManager {

    private AfishaRepository repository;
    @Getter private int amount = 10;

    public AfishaManager(AfishaRepository repository, int amount) {
        if (amount > 0)
            this.amount = amount;
        else
            this.amount = 0;

        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void add(Movie item) {
        repository.save(item);
    }

    public Movie[] getLastMovies() {
        Movie[] movies = repository.findAll();
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
