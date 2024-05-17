package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    Cat cat;
    private final List<String> expectedCatFood = List.of("Животные", "Птицы", "Рыба");
    private final String expectedCatSound = "Мяу";

    @Mock
    Feline feline;

    @Before
    public void init() {
        cat = new Cat(feline);
    }

    @Test
    public void getCatSoundTest() {
        String actualCatSound = cat.getSound();
        assertEquals(expectedCatSound, actualCatSound);
    }

    @Test
    public void getCatFoodTest() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualCatFood = cat.getFood();
        Mockito.verify(feline).eatMeat();
        assertEquals(expectedCatFood, actualCatFood);
    }
}