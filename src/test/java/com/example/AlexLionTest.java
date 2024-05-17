package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {
    private final String expectedPlaceOfLiving = "Нью-Йоркский зоопарк";
    private final List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
    private final int expectedKittens = 0;
    AlexLion alex;

    @Mock
    Feline feline;

    @Before
    public void init() throws Exception {
        alex = new AlexLion(feline);
    }

    @Test
    public void getAlexFriendsTest() {
        List<String> actualFriends = alex.getFriends();
        assertEquals(expectedFriends, actualFriends);
    }

    @Test
    public void getAlexPlaceOfLivingTest() {
        String actualPlaceOfLiving = alex.getPlaceOfLiving();
        assertEquals(expectedPlaceOfLiving, actualPlaceOfLiving);
    }

    @Test
    public void getAlexKittensTest() {
        int actualKittens = alex.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }
}