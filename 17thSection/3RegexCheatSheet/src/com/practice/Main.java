package com.practice;
//AUTHOR Jacob Van Laan
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static String validPhoneRegExp = "^\\s?((1-[1-9]{1,4}[ \\-]*)|([1]\\+[1-9]{1,4}[ \\-]*)|(\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?";
    public static Pattern validPhonePattern = Pattern.compile(validPhoneRegExp);

    public static void main(String[] args){

        String alphaNumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println("Replace every character -> string.replaceAll(\".\",\"*\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll(".", "*"));

        System.out.println("\nReplace every occurrence of 'abcDeee' at the beginning of the string -> string.replaceAll(\"^abcDeee\",\"***\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll("^abcDeee", "***"));

        System.out.println("\nReplace every occurrence of 'jkl99z' at the end of the string -> string.replaceAll(\"jkl99z$\",\"***\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll("jkl99z$", "***"));

        System.out.println("\nReplace every occurrence of 'a', 'e', or 'i' -> string.replaceAll(\"[aei]\",\"|*|\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll("[aei]", "|*|"));

        System.out.println("\nReplace every occurrence of 'a', 'e', or 'i' that is followed by an 'F' or a 'j' -> string.replaceAll(\"[aei][Fj]\",\"*\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll("[aei][Fj]", "*"));


        System.out.println("\nReplace all occurrences of 'Harry', case-insensitive -> \"[Hh][Aa][Rr][Rr][Yy]\"");
        System.out.println("\tMy name is HARRY -> " + "My name is HARRY".replaceAll("[Hh][Aa][Rr][Rr][Yy]", "Harry")); //order is important!
        System.out.println("\tMy name is HaRry -> " + "My name is HaRry".replaceAll("[Hh][Aa][Rr][Rr][Yy]", "Harry"));
        System.out.println("\tMy name is harry -> " + "My name is harry".replaceAll("[Hh][Aa][Rr][Rr][Yy]", "Harry"));

        System.out.println("Replace all occurrences of 'Harry', case-insensitive using '|' OR syntax -> \"[H|h][A|a][R|r][R|r][Y|y]\"");
        System.out.println("\tMy name is HARRY -> " + "My name is HARRY".replaceAll("[H|h][A|a][R|r][R|r][Y|y]", "Harry"));
        System.out.println("\tMy name is HaRry -> " + "My name is HaRry".replaceAll("[H|h][A|a][R|r][R|r][Y|y]", "Harry"));
        System.out.println("\tMy name is harry -> " + "My name is harry".replaceAll("[H|h][A|a][R|r][R|r][Y|y]", "Harry"));


        System.out.println("\nReplace every letter except 'e' and 'j' -> string.replaceAll(\"[^ej]\",\"*\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll("[^ej]", "*"));

        System.out.println("\nReplace all characters 'a' through 'f' or '3' through '8', inclusive -> string.replaceAll(\"[a-f3-8]\",\"*\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll("[a-f3-8]", "*"));
        System.out.println("Alternative Syntax 1 -> string.replaceAll(\"[a-fA-F3-8]\",\"*\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll("[a-fA-F3-8]", "*"));
        System.out.println("Alternative Syntax 2 -> using java case insensitive construct -> string.replaceAll(\"(?i)[a-f3-8]\",\"*\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll("(?i)[a-f3-8]", "*"));

        System.out.println("\nReplace all the numbers in a string -> string.replaceAll(\"\\\\d\",\"*\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll("\\d", "*"));
        //abcDeeeF12Ghhiiiijkl99z -> abcDeeeF**Ghhiiiijkl**z

        System.out.println("\nReplace all the non-digits in a string -> string.replaceAll(\"\\\\D\",\"*\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll("\\D", "*"));
        //abcDeeeF12Ghhiiiijkl99z -> ********12**********99*

        System.out.println("\nReplace all whitespace characters -> string.replaceAll(\"\\\\s\",\"\") : ");
        String blanksTabsAndNewline = "I have blanks and\ta tab, and also a \n\tnewline";
        System.out.println("\t" + blanksTabsAndNewline + " -> \n\t" + blanksTabsAndNewline.replaceAll("\\s", ""));

        System.out.println("\nReplace all non-whitespace characters -> string.replaceAll(\"\\\\S\",\".\") : ");
        System.out.println("\t" + blanksTabsAndNewline + " -> \n\t" + blanksTabsAndNewline.replaceAll("\\S", "."));


        System.out.println("\nReplace all characters 'a' through 'z', 'A' through 'Z', '0' through '9', and '_' -> string.replaceAll(\"\\\\w\",\".\") : ");
        System.out.println("\t" + blanksTabsAndNewline + " -> \n\t" + blanksTabsAndNewline.replaceAll("\\w", "."));

        System.out.println("\nReplace all characters EXCEPT 'a' through 'z', 'A' through 'Z', '0' through '9', and '_' -> string.replaceAll(\"\\\\W\",\".\") : ");
        System.out.println("\t" + blanksTabsAndNewline + " -> \n\t" + blanksTabsAndNewline.replaceAll("\\W", "."));
        //I.have.blanks.and.a.tab..and.also.a..newline

        System.out.println("\nReplace all word boundaries -> string.replaceAll(\"\\\\b\",\".\") : ");
        System.out.println("\t" + blanksTabsAndNewline + " -> \n\t" + blanksTabsAndNewline.replaceAll("\\b", "."));

        System.out.println("\nReplace all EXCEPT word boundaries -> string.replaceAll(\"\\\\B\",\".\") : ");
        System.out.println("\t" + blanksTabsAndNewline + " -> \n\t" + blanksTabsAndNewline.replaceAll("\\B", "."));


        System.out.println("\nReplace all occurrences of 'abcD' followed by 3 'e's -> string.replaceAll(\"abcDe{3}\",\"***\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll("abcDe{3}", "***"));


        System.out.println("\nReplace all occurrences of 'abcD' followed by 1 or more 'e's -> string.replaceAll(\"abcDe+\",\"***\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll("abcDe+", "***"));

        System.out.println("\nReplace all occurrences of 'abcD' followed by 0 or more 'e's -> string.replaceAll(\"abcDe*\",\"***\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll("abcDe*", "***"));

        System.out.println("\nReplace all occurrences of 'abcD' followed by 2 to 5 'e's -> string.replaceAll(\"abcDe{2,5}\",\"***\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll("abcDe{2,5}", "***"));
        System.out.println("\tabcDeF12Ghhiiiijkl99z" + " -> " + "abcDeF12Ghhiiiijkl99z".replaceAll("abcDe{2,5}", "***"));

        System.out.println("\nReplace all occurrences of 'h' followed by 0 or more 'i's followed by 1 or more 'j's -> string.replaceAll(\"h+i*j+\",\"***\") : ");
        System.out.println("\t" + alphaNumeric + " -> " + alphaNumeric.replaceAll("h+i*j+", "***"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>My Sub-Heading</h2>");
        htmlText.append("<p>My first paragraph.</p>");
        htmlText.append("<p>My second paragraph.</p>");
        htmlText.append("<h2>My Summary</h2>");
        htmlText.append("<p>My summary.</p>");
        htmlText.append("<h2></h2>");

        System.out.println("\nDetermine if string contains char sequence '<h2>' (return boolean) -> \n\tString = " + htmlText + "\n\tString h2Pattern = \".*<h2>.*\";\n\tPattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);\n\tMatcher matcher = pattern.matcher(htmlText);\n\tSystem.out.println(matcher.matches()) -> ");
        String h2Pattern = ".*<h2>.*";
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.print("\t\t" + matcher.matches());

        String h2Pattern2 = "h2";
        Pattern pattern2 = Pattern.compile(h2Pattern2, Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(htmlText);
        System.out.println("\n\nFind all occurrences of char sequence 'h2' and output their start and end index positions -> \n\tString = " + htmlText + "\n\tString h2Pattern2 = \"h2\";\n\tPattern pattern2 = Pattern.compile(h2Pattern2, Pattern.CASE_INSENSITIVE);\n\tMatcher matcher2 = pattern2.matcher(htmlText);" +
                                   "\n\tint count = 0;" +
                                   "\n\twhile(matcher2.find()) {" +
                                   "\n\t\tcount++;" +
                                   "\n\t\tSystem.out.println(\"Occurrence \" + count + \" : \" + matcher2.start() + \" to \" + matcher2.end());" +
                                   "\n\t} : ");
        int count = 0;
        while(matcher2.find()){
            count++;
            System.out.println("\tOccurrence " + count + " : " + matcher2.start() + " to " + matcher2.end());
        }

        System.out.println("\n\nFind all occurrences of char sequence '<h2>...</h2>' and output occurrence text using the .group() method and the '?' lazy quantifier to limit matches to 0 or 1 occurrences -> \n\tString = " + htmlText + "\n\tString h2GroupPattern = \"(<h2>.*?</h2>)\";\n\tPattern groupPattern = Pattern.compile(h2GroupPattern, Pattern.CASE_INSENSITIVE);\n\tMatcher groupMatcher = groupPattern.matcher(htmlText);" +
                                   "\n\twhile(groupMatcher.find()) {" +
                                   "\n\t\tSystem.out.println(\"Occurrence : \" + groupMatcher.group(0));" +
                                   "\n\t} : ");
        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        while(groupMatcher.find()){
            System.out.println("\tOccurrence : " + groupMatcher.group(0));
        }

        System.out.println("\n\nFind all NON-EMPTY ('+' quantifier) occurrences of char sequence '<h2>...</h2>' and output occurrences using the .group() method and the '?' lazy quantifier to limit matches to 0 or 1 occurrences -> \n\tString = " + htmlText + "\n\tString h2GroupPattern2 = \"(<h2>.+?</h2>)\";\n\tPattern groupPattern2 = Pattern.compile(h2GroupPattern2, Pattern.CASE_INSENSITIVE);\n\tMatcher groupMatcher2 = groupPattern2.matcher(htmlText);" +
                                   "\n\tcount = 0;" +
                                   "\n\twhile(groupMatcher2.find()) {" +
                                   "\n\t\tcount++;" +
                                   "\n\t\tSystem.out.println(\"Occurrence \" + count + \": \" + groupMatcher2.group(0));" +
                                   "\n\t} : ");
        count = 0;
        String h2GroupPattern2 = "(<h2>.+?</h2>)";
        Pattern groupPattern2 = Pattern.compile(h2GroupPattern2);
        Matcher groupMatcher2 = groupPattern2.matcher(htmlText);
        while(groupMatcher2.find()){
            count++;
            System.out.println("\tOccurrence " + count + ": " + groupMatcher2.group(0));
        }

        System.out.println("\n\nFind all NON-EMPTY ('+' quantifier) occurrences of char sequence '<h2>...</h2>' and output occurrence TEXT (between-tag chars) using the .group() method and the '?' lazy quantifier to limit matches to 0 or 1 occurrences -> \n\tString = " + htmlText + "\n\tString h2TextGroups = \"(<h2>.+?</h2>)\";\n\tPattern h2TextPattern = Pattern.compile(h2TextGroups, Pattern.CASE_INSENSITIVE);\n\tMatcher h2TextMatcher = h2TextPattern.matcher(htmlText);" +
                                   "\n\tcount = 0;" +
                                   "\n\twhile(h2TextMatcher.find()) {" +
                                   "\n\t\tcount++;" +
                                   "\n\t\tSystem.out.println(\"Occurrence \" + count + \": \" + h2TextMatcher.group(2));" +
                                   "\n\t} : ");
        count = 0;
        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);
        while(h2TextMatcher.find()){
            count++;
            System.out.println("\tOccurrence " + count + ": " + h2TextMatcher.group(2));
        }

        String tvTest = "tstvtkt";
        System.out.println("\n\nFind all occurrences of 't' followed by 'v' using negative look-ahead modifier syntax '(?!v)' instead of standard bracket syntax '[^v]' because the latter consumes a character and will therefore not match on the last occurrence -> \n\tString = " +
                                   tvTest +
                                   "\n\tString tNotVRegExp = \"t(?!v)\";\n\tPattern tNotVPattern = Pattern.compile(tNotVRegExp, Pattern.CASE_INSENSITIVE);\n\tMatcher tNotVMatcher = tNotVPattern.matcher(tvTest);" +
                                   "\n\tcount = 0;" +
                                   "\n\twhile(tNotVMatcher.find()) {" +
                                   "\n\t\tcount++;" +
                                   "\n\t\tSystem.out.println(\"Occurrence \" + count + \": \"+ tNotVMatcher.start() + \" to \" + tNotVMatcher.end());" +
                                   "\n\t} : ");
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);
        count = 0;
        while(tNotVMatcher.find()){
            count++;
            System.out.println("\tOccurrence " + count + ": " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        System.out.println("\n\nFind all occurrences of 't' followed by 'v' using positive look-ahead modifier syntax '(?!v)'. This will look-ahead to the next character for matching but will not include the look-ahead char in the match result  -> \n\tString = " +
                                   tvTest +
                                   "\n\tString tNotVRegExp2 = \"t(?=v)\";\n\tPattern tNotVPattern2 = Pattern.compile(tNotVRegExp2, Pattern.CASE_INSENSITIVE);\n\tMatcher tNotVMatcher2 = tNotVPattern2.matcher(tvTest);" +
                                   "\n\tcount = 0;" +
                                   "\n\twhile(tNotVMatcher2.find()) {" +
                                   "\n\t\tcount++;" +
                                   "\n\t\tSystem.out.println(\"Occurrence \" + count + \": \"+ tNotVMatcher2.start() + \" to \" + tNotVMatcher2.end());" +
                                   "\n\t} : ");
        String tNotVRegExp2 = "t(?=v)";
        Pattern tNotVPattern2 = Pattern.compile(tNotVRegExp2);
        Matcher tNotVMatcher2 = tNotVPattern2.matcher(tvTest);
        count = 0;
        while(tNotVMatcher2.find()){
            count++;
            System.out.println("\tOccurrence " + count + ": " + tNotVMatcher2.start() + " to " + tNotVMatcher2.end());
        }

        System.out.println("\nUS Phone Number Validator -> \"^\\s?((1-[1-9]{1,4}[ \\-]*)|([1]\\+[1-9]{1,4}[ \\-]*)|(\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?\"");
        String phone1 = "(800) 123-4567";
        String phone2 = "8001234567";
        String phone3 = "800-123-4567";
        String phone4 = "800 123 4567";
        String phone5 = "(800) 123 4567";
        String phone6 = "18001234567";
        String phone7 = "1-8001234567";
        System.out.println("\t" + phone1 + " -> " + isValidPhone(phone1));
        System.out.println("\t" + phone2 + " -> " + isValidPhone(phone2));
        System.out.println("\t" + phone3 + " -> " + isValidPhone(phone3));
        System.out.println("\t" + phone4 + " -> " + isValidPhone(phone4));
        System.out.println("\t" + phone5 + " -> " + isValidPhone(phone5));
        System.out.println("\t" + phone6 + " -> " + isValidPhone(phone6));
        System.out.println("\t" + phone7 + " -> " + isValidPhone(phone7));


        System.out.println("\n\"Mastering Regular Expressions: Powerful Techniques for Perl and Other Tools\"\n\tBy: Jeffrey Friedl \n\turl: http://ww2.ii.uj.edu.pl/~tabor/prII09-10/perl/master.pdf");
        System.out.println("\nOracle java.util.regex.Pattern Documentation \n\turl: https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html");
        System.out.println("\nOracle java.util.regex.Matcher Documentation \n\turl: https://docs.oracle.com/javase/7/docs/api/java/util/regex/Matcher.html");


    }

    public static boolean isValidPhone(String phoneNumber){
        Matcher validPhoneMatcher = validPhonePattern.matcher(phoneNumber);
        return validPhoneMatcher.matches();
    }
}
