package com.practice;

//DOWNLOAD THE SOURCE CODE
public class Main {

    public static void main(String[] args){
        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < 10){
            utils.addChar(sb, 'a');
        }
        System.out.println(sb);
            System.out.println(utils.addSuffix(utils.addPrefix(sb.toString())));
    }
}
