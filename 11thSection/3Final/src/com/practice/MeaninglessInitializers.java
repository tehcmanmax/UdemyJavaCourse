package com.practice;

public class MeaninglessInitializers {
    private final static String CONCATENATED;
    private int failedOverwrittenDigit;
    private final int finalDigit;
    private final int finalInstanceInitializer;

    {//works because I don't have this variable in the constructor
        finalInstanceInitializer = 999999999;
    }

    static {
        final String _1stHalf = "Alba"; //means, I cannot modify _1stHalf
        String _2ndHalf = "tros";
        CONCATENATED = _1stHalf + _2ndHalf;
    }

    {//doesnt work if I have a constructor
        failedOverwrittenDigit = 62;
    }

    public MeaninglessInitializers(int failedOverwrittenDigit, int finalDigit) {
        System.out.println("Initialization from a constructor:");
        this.failedOverwrittenDigit = failedOverwrittenDigit;
        this.finalDigit = finalDigit;
        System.out.println(this.failedOverwrittenDigit + ", " + this.finalDigit);
        System.out.println("======================");
    }

    public MeaninglessInitializers() { //constructor chain; backup constructor
        this(0, 0);
    }

    {//doesnt work if I have a constructor
        failedOverwrittenDigit = 62;
    }







    public static String getCONCATENATED() {
        return CONCATENATED;
    }


    public int getFinalInstanceInitializer() {
        return finalInstanceInitializer;
    }
}
