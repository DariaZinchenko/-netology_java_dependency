package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerNonEmptyTest {

    private Movie first = new Movie("1", "url 1", "name 1", "genre 1");
    private Movie second = new Movie("2", "url 2", "name 2", "genre 2");
    private Movie third = new Movie("3", "url 3", "name 3", "genre 3");
    private Movie fourth = new Movie("4", "url 4", "name 4", "genre 4");
    private Movie fifth = new Movie("5", "url 5", "name 5", "genre 5");

    public void setUp(MovieManager movieManager) {
        movieManager.add(first);
        movieManager.add(second);
        movieManager.add(third);
        movieManager.add(fourth);
        movieManager.add(fifth);
    }

    @Test
    public void getLastMoviesAmountOverMoviesTest() {
        MovieManager movieManager = new MovieManager(7);
        setUp(movieManager);

        Movie[] actual = movieManager.getLastMovies();
        Movie[] expected = new Movie[] {fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastThreeMoviesAmountUnderMoviesTest() {
        MovieManager movieManager = new MovieManager(3);
        setUp(movieManager);

        Movie[] actual = movieManager.getLastMovies();
        Movie[] expected = new Movie[] {fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }
}