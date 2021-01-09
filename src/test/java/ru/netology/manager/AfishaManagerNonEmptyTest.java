package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerNonEmptyTest {

    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;

    private Movie first = new Movie(1, "url 1", "name 1", "genre 1");
    private Movie second = new Movie(2, "url 2", "name 2", "genre 2");
    private Movie third = new Movie(3, "url 3", "name 3", "genre 3");
    private Movie fourth = new Movie(4, "url 4", "name 4", "genre 4");
    private Movie fifth = new Movie(5, "url 5", "name 5", "genre 5");

    @Test
    public void getLastMoviesAmountOverMoviesTest() {
        Movie[] returned = new Movie[] {first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        manager = new AfishaManager(repository, 7);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastThreeMoviesAmountUnderMoviesTest() {
        Movie[] returned = new Movie[] {first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        manager = new AfishaManager(repository, 3);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }
}
