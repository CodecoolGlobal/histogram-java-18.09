package com.codecool.histogram;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HistogramTest {

    private Histogram hist;

    @BeforeEach
    public void setup() {
        this.hist = new Histogram();

    }

    @Test
    public void whenGenerateRangesStep3Amount4_returnsCorrectRangesFrom1To12() {
        List<Range> expected = Arrays.asList(new Range(1, 3), new Range(4, 6), new Range(7, 9), new Range(10, 12));
        List<Range> ranges = hist.generateRanges(3, 4);
        assertEquals(expected, ranges);
    }

    @Test
    public void whenGenerateRangesNegativeStep_throwsException() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            hist.generateRanges(-3, 4);
        });
        assertEquals("Step must be positive.", illegalArgumentException.getMessage());
    }
}
