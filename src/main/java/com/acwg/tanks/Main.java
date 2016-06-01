package com.acwg.tanks;

import com.acwg.tanks.DBase.ModelDataApp;
import com.acwg.tanks.Util.ValueException;
import com.acwg.tanks.Vehicle.Tank;

public class Main {
    public static void main(String[] args){

//        ModelDataApp.connect();
//        ModelDataApp.disconnect();
//        ModelDataApp.insertTank("Patton", "USA", 48, 2500, 410, 90.0, 120.0, 75.0, 122.0, true);
            ModelDataApp.getTanks();
        //Tank tank = new Tank();
    }
}
