package com.jmurray.namemangler;

import java.util.Random;

/**
 * Created by Joshua on 10/10/2017.
 */

public class Name {//copied your implementation from class today (10/11)
    private String mFirstName;
    private String[] mMangledNames =  {"Magnificent","Stupendous","The Vexor","The Wonder","The Studious"};
    private Random rand = new Random();

    public Name() {
        mFirstName = "Default";
    }

    public String getMangled(String firstName) {
        return firstName + " " + mMangledNames[rand.nextInt((mMangledNames.length)-0)];
    }
}