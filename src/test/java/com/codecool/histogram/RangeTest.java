package com.codecool.histogram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {

    @Test
    public void whenFromIsNegative_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Range range = new Range(-1, 5);
        });
    }

    @Test
    public void whenToISmallerThenFrom_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Range range = new Range(5, 3);
        });
    }

    @Test
    public void whenWordInRange_ReturnTrue() {
        String word = "Harry";
        Range range = new Range(0, 6);
        assertTrue(range.isInRange(word));
    }

    @Test
    public void whenWordLengthEqualsRangeStartFrom_ReturnTrue() {
        String word = "Harry";
        Range range = new Range(5, 10);
        assertTrue(range.isInRange(word));
    }

    @Test
    public void whenWordLengthEqualsRangeEnd_ReturnTrue() {
        String word = "Harry";
        Range range = new Range(0, 5);
        assertTrue(range.isInRange(word));
    }

    @Test
    public void whenWordLengthIsOutOfRange_ReturnFalse() {
        String word = "Harry";
        Range range = new Range(0, 4);
        assertFalse(range.isInRange(word));
    }

    @Test
    public void whenRangeToString_ReturnCorrectDisplayedString(){
        Range range = new Range(0, 10);
        assertEquals("0  - 10", range.toString());
    }
}
