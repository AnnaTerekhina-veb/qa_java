package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionConstructorSexParameterizedTest {

    private final String sex;
    private final boolean expectedHasMane; // Ожидаемое значение hasMane
    private final Feline feline;


    public LionConstructorSexParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;

        this.feline = Mockito.mock(Feline.class);
    }

    @Parameterized.Parameters(name = "Пол: {0}, Ожидается hasMane: {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                // Тест 1: Самец
                {"Самец", true},
                // Тест 2: Самка
                {"Самка", false},
        };
    }

    @Test
    public void testLionConstructorSetsHasManeCorrectlyForValidSex() throws Exception {
        Lion lion = new Lion(this.sex, this.feline);

        assertEquals(expectedHasMane, lion.hasMane);
    }
}