package com.practice;


public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if(tonerLevel > -1 && tonerLevel <= 100)
            this.tonerLevel = tonerLevel;
        else //err
            this.tonerLevel = -1;
        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    //good practice to put this. in the methods even though method parameter is different than class attribute (class member)
    //this says that we are using the class attribute which is class field. we are not using method attribute
    public int addToner(int tonerAmount) {
        if(tonerAmount > -1 && tonerAmount <= 100)
            if(tonerAmount + this.tonerLevel > 100)
                return -1;
        this.tonerLevel += tonerAmount;
        return this.tonerLevel;

    }

    public int printPages(int pages) {
        int pagesToPrint = pages;
        if(this.duplex == true) {
            pagesToPrint = (pagesToPrint / 2) + (pagesToPrint % 2);
            System.out.println("Printing in duplex mode");
        }
        pagesPrinted  += pagesToPrint;
        return pagesToPrint;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
