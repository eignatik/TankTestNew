package com.acwg.tanks;

import com.acwg.tanks.DBase.ConnectionDB;

public class Main {
    public static void main(String[] args){

//        ConnectionDB.connect();
//        ConnectionDB.disconnect();
        ConnectionDB.insertTank("Patton", "USA", 48, 2500, 410, 90.0, 120.0, 75.0, 122.0, true);

    }
}
