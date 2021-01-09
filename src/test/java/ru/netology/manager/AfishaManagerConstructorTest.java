package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

//@ExtendWith(MockitoExtension.class)
public class AfishaManagerConstructorTest {
    private AfishaRepository repository;

    @ParameterizedTest(name = "{index} {0}")
    @CsvSource({
      "initialize MovieManager Object amount under lower limit, -1, 0",
      "initialize MovieManager Object amount equal lower limit, 0, 0",
      "initialize MovieManager Object amount over lower limit, 1, 1",
      "initialize MovieManager Object amount average value, 23, 23"})
    public void customConstructorTest(String testName, int amount, int expected) {
        AfishaManager manager = new AfishaManager(repository, amount);
        assertEquals(expected, manager.getAmount());
    }

    @Test
    public void noArgsConstructorTest() {

        AfishaManager manager = new AfishaManager();
        assertEquals(10, manager.getAmount());
    }
}
