package com.example.ibf2021d13.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Contacts {
    private final List<String> alphabet= Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
            "v", "w", "x", "y", "z");

    private final List<String> numbers= Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    public String fileNameGenerator(){
        Collections.shuffle(alphabet);
        Collections.shuffle(numbers);
        String fileName = alphabet.get(0);

        for (int i=0; i<3; i++){
            fileName = fileName + alphabet.get(i);
        }
        for (int i=0; i<4; i++){
            fileName = fileName + numbers.get(i);
        }
        return fileName;
    }
    public List<String> getAlphabet() {
        return alphabet;
    }

    public List<String> getNumbers() {
        return numbers;
    }
}

