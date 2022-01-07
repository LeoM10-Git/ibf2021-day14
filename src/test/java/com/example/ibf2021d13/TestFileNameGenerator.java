package com.example.ibf2021d13;

import com.example.ibf2021d13.model.Contacts;


public class TestFileNameGenerator {
    public static void main(String[] args) {
        Contacts contacts = new Contacts();
        System.out.println(contacts.getAlphabet());
        System.out.println(contacts.getNumbers());
        System.out.println(contacts.fileNameGenerator());
    }
}
