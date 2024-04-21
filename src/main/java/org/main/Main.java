package org.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        String fileName = "src/main/text.txt";

        HashMap<Character, Integer> vowelCount = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    char lowercase = Character.toLowerCase(c);
                    if (isVowel(lowercase)) {
                        vowelCount.put(lowercase, vowelCount.getOrDefault(lowercase, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Count of each vowel in the text:");

        for (char vowel : new char[]{'a', 'e', 'i', 'o', 'u'}) {
            int count = vowelCount.getOrDefault(vowel, 0);

            System.out.println(vowel + ": " + count);
        }
    }
    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

}