package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    private final String expectedFelineFamily = "Кошачьи";
    private final List<String> expectedFelineFood = List.of("Животные", "Птицы", "Рыба");
    private final int expectedKittens = 4;
    private static final int EXPECTEDKITTEN = 1;


    @Spy
    Feline feline;

    @Test
    public void felineEatMeatTest() throws Exception {
        List<String> actualFood = feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
        assertEquals(expectedFelineFood, actualFood);
    }

    @Test
    public void getFelineFamilyTest() {
        String actualFamily = feline.getFamily();
        assertEquals(expectedFelineFamily, actualFamily);
    }

    @Test
    public void getFelineKittensTest() {
        int actualKittens = feline.getKittens(4);
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void getFelineKittenTest() {
        int actualKitten = feline.getKittens();
        Mockito.verify(feline).getKittens(1);
        assertEquals(EXPECTEDKITTEN, actualKitten);
    }
}