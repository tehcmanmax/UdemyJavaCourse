package com.practice;

public class StringUtilities {
    private StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0;

    public void addChar(StringBuilder sBuilder, char c){
        this.sBuilder = sBuilder;
        this.sBuilder.append(c);
         charsAdded++;
    }
    public String addSuffix(String str){
        return str + "_Suffix";
    }
    public String addPrefix(String str){
        return "Prefix_" + str;
    }
}
