package javaprojects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class FuzzyFinderTest {

    @Test
    public void testLinearSearchSorted() {

        FuzzyListGenerator generator = new FuzzyListGenerator();
        FuzzyFinder finder = new FuzzyFinder();

        ArrayList<Fuzzy> sortedList = generator.sortedRainbowFuzzies();

        int result = finder.linearSearch(sortedList);

        assertEquals(1000, result);
    }

    @Test
    public void testLinearSearchRandomized() {

        FuzzyListGenerator generator = new FuzzyListGenerator();
        FuzzyFinder finder = new FuzzyFinder();

        ArrayList<Fuzzy> randomList = generator.randomizedRainbowFuzzies();

        int result = finder.linearSearch(randomList);

        assertTrue(result >= 0 && result < randomList.size());
        assertEquals("gold", randomList.get(result).color);
    }


    @Test
    public void testBinarySearchSorted() {

        FuzzyListGenerator generator = new FuzzyListGenerator();
        FuzzyFinder finder = new FuzzyFinder();

        ArrayList<Fuzzy> sortedList = generator.sortedRainbowFuzzies();

        int result = finder.binarySearch(sortedList);

        assertEquals(1000, result);
    }

    @Test
    public void testBinarySearchRandom() {

        FuzzyFinder finder = new FuzzyFinder();

        ArrayList<Fuzzy> fuzzies = new ArrayList<>();

        fuzzies.add(new Fuzzy("blue"));
        fuzzies.add(new Fuzzy("green"));
        fuzzies.add(new Fuzzy("red"));

        int result = finder.binarySearch(fuzzies);

        assertEquals(-1, result);
    }
}