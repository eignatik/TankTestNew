package com.acwg.tanks.Util;

import java.util.Random;

/**
 * Created by Eugen on 6/1/2016.
 */
public class RandSet {
    private static final String[] country = {"USA", "Russia", "England", "France", "China", "Germany"};
    private String name = "Tank";
    private final Random random = new Random();


    public String getCountry(){
        return country[random.nextInt(6)];
    }

    public double getDouble(){
        return 0.0 + (150.0 - 0.0) * random.nextDouble();
    }

    public int getInt(){
        return random.nextInt(200);
    }

    public String getName(int i){
        return this.name + i;
    }

    public boolean getBool(){
        return random.nextBoolean();
    }
}
