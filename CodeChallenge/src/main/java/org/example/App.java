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
     * Complejidad del algoritmo O(n + m + p)
     * 
     */
    public boolean checkAnagrama(String word1, String word2) {  // O(n) + O(p) + O(m) = O(n + m + p)
        Map<Character, Integer> mapWord1 = new HashMap<>();
        Map<Character, Integer> mapWord2 = new HashMap<>();

        if(word1 == null || word2 == null) return false;

        char[] arrayWord1 = word1.toCharArray();
        char[] arrayWord2 = word2.toCharArray();

        for(char charWord: arrayWord1) {                        // O(n)
            Character character = Character.valueOf(charWord);
            Integer value = mapWord1.get(character);

            if (value == null) {
                mapWord1.put(character, 1);
            } else {
                mapWord1.computeIfPresent(character, (k, v) -> v + 1);
            }

        }

        for(char charWord: arrayWord2) {                        // O(m)
            Character character = Character.valueOf(charWord);
            Integer value = mapWord2.get(character);

            if (value == null) {
                mapWord2.put(character, 1);
            } else {
                mapWord2.computeIfPresent(character, (k, v) -> v + 1);
            }

        }

        if(mapWord1.size() != mapWord2.size()) return false;

        for(var keyValue: mapWord1.entrySet()) {                // O(p)
            Integer num = mapWord2.get(keyValue.getKey());
            if(num == null) return false;
            if(num != keyValue.getValue()) return false;
        }

        return true;
    }
}
