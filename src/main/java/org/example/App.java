package org.example;

import static org.example.Port.getCombinations;
import static org.example.Port.parseIndexes;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        String[] arr = {"1,3-5", "2", "3-4"};

        System.out.println(parseIndexes(arr));
        System.out.println(getCombinations(parseIndexes(arr)));

    }
}
