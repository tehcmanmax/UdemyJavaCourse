package com.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a book.";
        System.out.println(challenge1.matches("^.*$"));

        Pattern pattern2 = Pattern.compile(".*(book|bike)\\.");
        Matcher matcher2 = pattern2.matcher(challenge2);
        System.out.println("matcher.matches() -> " + matcher2.matches());

        String challenge4 = "Replace blanks with the underscores.";
        System.out.println(challenge4.replaceAll("[ ]", "_"));
        //or
        System.out.println(challenge4.replaceAll("\\s", "_"));

        String challenge5 = "wwwwwwwwwefsdfesfefscx";
        System.out.println(challenge5.matches("\\w+"));

        String challenge7 = "adaws.32423";
        System.out.println(challenge7.matches("^\\w+\\.\\d+$"));

        String challenge8 = "adaws.135adawd.7rdt.999";
        //System.out.println(challenge8.replaceAll("\\D", ""));

        String regex8 = ".+?\\.(\\d+)"; //matching only a part of the string
        Pattern pattern8 = Pattern.compile(regex8);
        Matcher matcher8 = pattern8.matcher(challenge8);

        int occurrence = 0;
        while(matcher8.find()){
            System.out.println("Occurrences " + occurrence + ": " + matcher8.group(1));
            occurrence++;
        }

        String challenge9 = "adaws.135\tadawd.7\trdt.999\n";

        String regex9 = "(\\d+)"; //matching only a part of the string
        Pattern pattern9 = Pattern.compile(regex9);
        Matcher matcher9 = pattern9.matcher(challenge9);

        occurrence = 0;
        while(matcher9.find()){
            System.out.println("New occurrences " + occurrence + ": " + matcher9.group());
            occurrence++;
        }

        String challenge10 = "adaws.135\tadawd.7\trdt.999\n";

        String regex10 = "(\\d+)"; //matching only a part of the string
        Pattern pattern10 = Pattern.compile(regex10);
        Matcher matcher10 = pattern10.matcher(challenge10);

        occurrence = 0;
        while(matcher10.find()){
            System.out.println("New occurrences " + occurrence + ": " + matcher10.group() + " starts at "
                                       + matcher10.start() + " ends at " + (matcher10.end() - 1));
            occurrence++;
        }

        System.out.println("{}&^%".matches("\\W+"));

        String challenge11 = "{0,2}, {0,5}, {1,3}, {2,4}, {a,b}";


        String regex11 = "(\\W(\\d,\\d)\\W)"; //matching only a part of the string
        Pattern pattern11 = Pattern.compile(regex11);
        Matcher matcher11 = pattern11.matcher(challenge11);

        occurrence = 0;
        while(matcher11.find()){
            System.out.println("New occurrences " + occurrence + ": " + matcher11.group(2));
            occurrence++;
        }

        String regex11a = "\\{(.{3})}"; //matching only a part of the string
        pattern11 = Pattern.compile(regex11a);
        matcher11 = pattern11.matcher(challenge11);

        occurrence = 0;
        while(matcher11.find()){
            System.out.println("New new occurrences " + occurrence + ": " + matcher11.group(1));
            occurrence++;
        }


        String usZipCode12 = "11111";
        Pattern pattern12 = Pattern.compile("^\\d{5}$");
        Matcher matcher12 = pattern12.matcher(usZipCode12);
        System.out.println("Challenge 12: " + matcher12.matches());

        String usZipCode13 = "11111 2323";

        //says: must be 5 digits \d{5} and optionally blank or dash [ |-] with 4 digits \d{4}
        Pattern pattern13 = Pattern.compile("^\\d{5}([ |-]?\\d{4})?$");

        Matcher matcher13 = pattern13.matcher(usZipCode13);
        System.out.println("Challenge 13: " + matcher13.matches());
    }
}
