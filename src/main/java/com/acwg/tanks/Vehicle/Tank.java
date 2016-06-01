package com.acwg.tanks.Vehicle;

public class Tank extends Vehicle {
    public Tank(){
        super(0, 0, 0, false, null, null); //default data
    }
    public Tank(int weight, int speed, int viewRange, boolean hasTower, String country, String tankName) {
        super(weight, speed, viewRange, hasTower, country, tankName);
    }

    @Override
    public void drive(int position) {
        System.out.println(this.getTankName() + " Drive to '" + position + "' with next speed " + this.getSpeed());
    }

    @Override
    public void fire(int position) {
        System.out.println(this.getTankName() + ":open fire (" + this.getWeapCal() + "mm. weapon) on '" + position + "' square.");
    }

    @Override
    public void towTurn() {

    }
}
