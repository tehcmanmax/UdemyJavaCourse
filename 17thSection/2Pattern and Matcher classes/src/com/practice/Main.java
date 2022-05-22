package com.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){
        //usingPatternAndMatcher();
        //matcherFindAndGroupMethods();
        //usingLogicalOperators();
        matchingPhoneNumber();
    }

    static private void matchingPhoneNumber(){
        //https://en.wikipedia.org/wiki/Telephone_numbers_in_Poland

/*        String regExPolishMobilePhoneNumberTest = "(45|50|51|53|57|60|66|69|72|73|78|79|88){1}\\d{3}";
        System.out.println("45111".matches(regExPolishMobilePhoneNumberTest));*/


        String regExPolishMobilePhoneNumber = "^(\\+?48)?[ ]?((45|50|51|53|57|60|66|69|72|73|78|79|88){1}(\\d{1}[ ]?\\d{3}[ ]?\\d{3}))$";
        System.out.println("+48 500 000 000".matches(regExPolishMobilePhoneNumber));
        System.out.println("48 500 000 000".matches(regExPolishMobilePhoneNumber));
        System.out.println("500 000 000".matches(regExPolishMobilePhoneNumber));
        System.out.println("500000 000".matches(regExPolishMobilePhoneNumber));
        System.out.println("500000000".matches(regExPolishMobilePhoneNumber));

        String phoneNumb1 = "+48 502 661 087";
        Pattern pattern = Pattern.compile(regExPolishMobilePhoneNumber);
        Matcher matcher = pattern.matcher(phoneNumb1);

        if(matcher.matches())
            System.out.println(matcher.group());
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));
        System.out.println(matcher.group(4));
    }

    static private void usingLogicalOperators(){
        String tvText = "tvbctvdtklmt";
        //Pattern pattern = Pattern.compile("t(?!v)"); // called "negative look ahead"
        //Pattern pattern = Pattern.compile("t[^v]"); //expects at least 1 character after t
        Pattern pattern = Pattern.compile("t(?=v)"); //equal to "tv" "positive look ahead"
        Matcher matcher = pattern.matcher(tvText);

        int count = 0;
        while(matcher.find()){
            count++;
            System.out.println("Occurrence " + count + " matches at " + matcher.start() + " and ends at " + matcher.end());
        }
    }

    static private void matcherFindAndGroupMethods(){
        String tongueTwister = "<br>She sells seashells by the seashore,</br> <br>The shells she sells are seashells, I'm sure</br>";
        System.out.println("The original text is:\n" + tongueTwister);
        Pattern sea = Pattern.compile("(<br>.*?</br>)"); // ONLY 1 GROUP
        Matcher matcher = sea.matcher(tongueTwister);

        while(matcher.find()){
            System.out.println("Occurrence " + matcher.group(1));
        }
        String brTextGroups2 = "(<br>)(.*?)(</br>)"; //3 GROUPS //RELUCTANT QUANTIFIER
        Pattern h2TextPatten = Pattern.compile(brTextGroups2);
        Matcher h2TextMatcher = h2TextPatten.matcher(tongueTwister);

        while(h2TextMatcher.find()){
            System.out.println("Occurrence: " + h2TextMatcher.group(2)); //LOOKING FOR THE 2ND GROUP
        }
    }

    static private void usingPatternAndMatcher(){
        StringBuilder htmlOnlyFans = new StringBuilder("<h1>Welcome to my onlyfans page!</h1>\n");
        htmlOnlyFans.append("<br>Choose your option to donate</br>\n");
        htmlOnlyFans.append("<p>- PayPal</p>\n");
        htmlOnlyFans.append("<p>- Bitcoin</p>\n");
        htmlOnlyFans.append("<p>- Debit card</p>\n");
        htmlOnlyFans.append("<br>See you in a private room</br>\n");

        System.out.println(htmlOnlyFans);

        Pattern paragraphs = Pattern.compile(".*|\\s*<p>.*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = paragraphs.matcher(htmlOnlyFans);
        System.out.println(matcher.matches()); //why false?

    }
}
