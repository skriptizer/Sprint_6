package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DoesHaveManeTest {
    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private final String sex;
    private final boolean hasMane;
    Feline feline = new Feline();

    @Before
    public void init() {
        feline = Mockito.spy(feline);
    }

    public DoesHaveManeTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getGenders() {
        return new Object[][]{
                {MALE, true},
                {FEMALE, false},
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(hasMane, actualHasMane);
    }
}