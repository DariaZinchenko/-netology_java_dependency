package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class AfishaRepositoryTest {

    private Movie first = new Movie(1, "url 1", "name 1", "genre 1");
    private Movie second = new Movie(2, "url 2", "name 2", "genre 2");
    private Movie third = new Movie(3, "url 3", "name 3", "genre 3");
    private Movie fourth = new Movie(4, "url 4", "name 4", "genre 4");
    private Movie fifth = new Movie(5, "url 5", "name 5", "genre 5");

    public void setUp(AfishaRepository repository) {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }

    @Test
    public void saveTest() {
        AfishaRepository repository = new AfishaRepository();
        repository.save(first);

        Movie[] expected = new Movie[] {first};

        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void findByIdIfIdExistTest() {
        AfishaRepository repository = new AfishaRepository();
        setUp(repository);
        Movie expected = fourth;

        Movie actual = repository.findById(4);

        assertEquals(expected, actual);
    }

    @Test
    public void findByIdIfIdNotExistTest() {
        AfishaRepository repository = new AfishaRepository();
        setUp(repository);

        Movie actual = repository.findById(11);

        assertNull(actual);
    }

    @Test
    public void removeByIdIfIdExistTest() {
        AfishaRepository repository = new AfishaRepository();
        setUp(repository);
        Movie[] expected = new Movie[] {first, second, fourth, fifth};

        repository.removeById(3);

        assertArrayEquals(expected, repository.findAll());
    }
/*
    @Test
    public void removeByIdIfIdNotExistTest() {
        AfishaRepository repository = new AfishaRepository();
        setUp(repository);
        Movie[] expected = new Movie[] {first, second, third, fourth, fifth};

        repository.removeById(11);

        assertArrayEquals(expected, repository.findAll());
    }*/
}
