package com.practice;

public class Main {

    public static void higScore(String name, int score){
        System.out.println(name + ", managed to get into position"+ score);
    }

    public static int calcHighScore(int highScr){
        if(highScr > 1000){
            System.out.println("Again, the scr is "+highScr);
        return highScr;
        }

        return -1;
    }


        public static int calculation(boolean game, int scr, int lvl, int bns){
            if(scr < 5000 && scr >1000) {
            System.out.println("This was was less than 5000 but greater than 1000");
        } else if(scr > 1000) {
            System.out.println("Your score was less than 1000");
        } else {
            System.out.println("Got here");
        }

        if(game) {
            int finalScore = scr + (lvl * bns);
            finalScore += 1000;
            return finalScore;
        }
        return scr;
    }

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;
        String name = "Vasya";


//        int finalScore = calculation (gameOver, score, levelCompleted, bonus);
//        System.out.println("After an update \nYour final score was " + calculation (gameOver, score, levelCompleted, bonus));
        higScore(name, calculation (gameOver, score, levelCompleted, bonus));
        calcHighScore(calculation (gameOver, score, levelCompleted, bonus));

    }
}