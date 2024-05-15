package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private static final String UNKNOWN = "UNKNOWN";
    private final List<String> expectedLionFood = List.of("Животные", "Птицы", "Рыба");
    private final int expectedLionKitten = 1;

    @Spy
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        int actualKitten = lion.getKittens();
        Mockito.verify(feline).getKittens();
        assertEquals(expectedLionKitten, actualKitten);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> actualLionFood = lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
        assertEquals(expectedLionFood, actualLionFood);
    }

    @Test
    public void doesHaveManeExceptionTest(){
        try {
            Lion lion = new Lion(UNKNOWN, feline);
        } catch (Exception exception){
            assertEquals(exception.getMessage(), "Используйте допустимые значения пола животного - самец или самка");
        }
    }
}