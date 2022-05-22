package com.practice;

import java.util.List;

public interface ISaveable {
    List<String> save();//, takes no arguments and returns a List containing objects of type String.
    void print(List<String> list);// takes a List of type String and doesn't return anything.
}
