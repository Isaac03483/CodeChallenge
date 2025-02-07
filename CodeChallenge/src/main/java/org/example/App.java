package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        new App().checkAnagrama("espada", "espada");
    }

    /*
     * Complejidad del algoritmo: O(n + m + p)
     * 
     */
    public boolean checkAnagrama(String word1, String word2) {  // O(n) + O(m) = O(n + m) = O(n)
        Map<Character, Integer> mapWord1 = new HashMap<>();
        Map<Character, Integer> mapWord2 = new HashMap<>();

        if(word1 == null || word2 == null) return false;
        char[] arrayWord1 = word1.toCharArray();
        char[] arrayWord2 = word2.toCharArray();

        if(arrayWord1.length != arrayWord2.length) return false;

        for(int i = 0; i < arrayWord1.length; i++) {                        // O(n)
            Character character1 = Character.valueOf(arrayWord1[i]);
            Integer value1 = mapWord1.get(character1);

            
            if (value1 == null) {
                mapWord1.put(character1, 1);
            } else {
                mapWord1.computeIfPresent(character1, (k, v) -> v + 1);
            }

            Character character2 = Character.valueOf(arrayWord2[i]);
            Integer value2 = mapWord2.get(character2);

            if (value2 == null) {
                mapWord2.put(character2, 1);
            } else {
                mapWord2.computeIfPresent(character2, (k, v) -> v + 1);
            }
        }

        if(mapWord1.size() != mapWord2.size()) return false;

        // { a: 1, p: 2, s: 3}
        return mapWord1.entrySet().stream().allMatch(v -> v.getValue() == mapWord2.get(v.getKey()));

        // return true;
    }
}
