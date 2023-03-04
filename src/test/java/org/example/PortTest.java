package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PortTest {

    @Test
    public void testParseIndexes() {
        String[] indexes = {"1,2,3", "4-6", "7-9,10,12-14"};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9, 10, 12, 13, 14)
        );
        assertEquals(expected, Port.parseIndexes(indexes));
    }

    @Test
    public void testGetCombinations() {
        List<List<Integer>> sequences = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4, 5),
                Arrays.asList(6, 7)
        );
        List<ArrayList<Integer>> expected = Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 3, 6)),
                new ArrayList<>(Arrays.asList(1, 3, 7)),
                new ArrayList<>(Arrays.asList(1, 4, 6)),
                new ArrayList<>(Arrays.asList(1, 4, 7)),
                new ArrayList<>(Arrays.asList(1, 5, 6)),
                new ArrayList<>(Arrays.asList(1, 5, 7)),
                new ArrayList<>(Arrays.asList(2, 3, 6)),
                new ArrayList<>(Arrays.asList(2, 3, 7)),
                new ArrayList<>(Arrays.asList(2, 4, 6)),
                new ArrayList<>(Arrays.asList(2, 4, 7)),
                new ArrayList<>(Arrays.asList(2, 5, 6)),
                new ArrayList<>(Arrays.asList(2, 5, 7))
        );
        assertEquals(expected, Port.getCombinations(sequences));
    }

}