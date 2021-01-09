package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerConstructorTest {

    @ParameterizedTest(name = "{index} {0}")
    @CsvSource({
      "initialize MovieManager Object amount under lower limit, -1, 0",
      "initialize MovieManager Object amount equal lower limit, 0, 0",
      "initialize MovieManager Object amount over lower limit, 1, 1",
      "initialize MovieManager Object amount average value, 23, 23"})
    public void customConstructorTest(String testName, int amount, int expected) {
        MovieManager movieManager = new MovieManager(amount);
        assertEquals(expected, movieManager.getAmount());
    }

    @Test
    public void noArgsConstructorTest() {
        MovieManager movieManager = new MovieManager();
        assertEquals(10, movieManager.getAmount());
    }
}
