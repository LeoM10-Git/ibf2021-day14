package com.example.ibf2021d13.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Contacts {
    private final List<String> alphabet= Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
            "v", "w", "x", "y", "z");

    private final List<String> numbers= Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    public String idGenerator(){
        Collections.shuffle(alphabet);
        Collections.shuffle(numbers);
        String id = alphabet.get(0);

        for (int i=0; i<3; i++){
            id = id + alphabet.get(i);
        }
        for (int i=0; i<4; i++){
            id = id + numbers.get(i);
        }
        return id;
    }
    public List<String> getAlphabet() {
        return alphabet;
    }

    public List<String> getNumbers() {
        return numbers;
    }
}

