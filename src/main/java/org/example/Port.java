package org.example;

import java.util.ArrayList;
import java.util.List;

public class Port {
    public static List<List<Integer>> parseIndexes(String[] indexes) {
        List<List<Integer>> result = new ArrayList<>();
        for (String index : indexes) {
            String[] parts = index.split(",");
            List<Integer> sequence = new ArrayList<>();
            for (String part : parts) {
                if (part.contains("-")) {
                    String[] range = part.split("-");
                    int start = Integer.parseInt(range[0]);
                    int end = Integer.parseInt(range[1]);
                    for (int i = start; i <= end; i++) {
                        sequence.add(i);
                    }
                } else {
                    sequence.add(Integer.parseInt(part));
                }
            }
            result.add(sequence);
        }
        return result;
    }

    public static List<ArrayList<Object>> getCombinations(List<List<Integer>> sequences) {
        List<ArrayList<Object>> result = new ArrayList<>();
        if (sequences.isEmpty()) {
            result.add(new ArrayList<>());
            return result;
        }
        List<Integer> firstSequence = sequences.get(0);
        List<List<Integer>> remainingSequences = sequences.subList(1, sequences.size());
        for (int element : firstSequence) {
            List<ArrayList<Object>> combinations = getCombinations(remainingSequences);
            for (ArrayList<Object> combination : combinations) {
                ArrayList<Object> temp = new ArrayList<>();
                temp.add(element);
                temp.addAll(combination);
                result.add(temp);
            }
        }
        return result;
    }

}
