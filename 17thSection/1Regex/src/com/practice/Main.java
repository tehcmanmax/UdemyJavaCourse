package com.practice;

public class Main {

    public static void main(String[] args) {
	    String wishing = "Happy wee1end!";
        System.out.println(wishing.replaceAll("\\d","k").replace("!", ""));

        System.out.println(wishing.replaceAll("\\d|!","k")); //I cannot write it like "\\d!"
        System.out.println(wishing.replaceAll("[^Hapy]", ""));
    //    Character and predefined classes have a different meaning for the AND operator

        String whiteSpaces = " I have   white spaces, and \ttabs with new\nline";
        System.out.println(whiteSpaces.replaceAll("\\s+", " ").strip());

        //Strip is better!
        Character c = '\u2000';
        String s = c + "abc" + c;
        System.out.println(s.strip());
        System.out.println(s.trim());
        String wrappingWithQuotes = "Mr. Robot";
        System.out.println(wrappingWithQuotes.replaceAll("\\b", "\""));

    }
}
