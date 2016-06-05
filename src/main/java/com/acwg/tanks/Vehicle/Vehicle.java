package com.acwg.tanks.Vehicle;

public abstract class Vehicle {
    private int weight, speed, viewRange;
    private double degTurnTow, degTurnVeh, sidesArm, backArm, frontArm, weapCal;
    private boolean hasTower;
    private String country, tankName;

    public Vehicle(int weight, int speed, int viewRange, boolean hasTower, String country, String tankName) {
        this.weight = weight;
        this.speed = speed;
        this.viewRange = viewRange;
        this.hasTower = hasTower;
        this.country = country;
        this.tankName = tankName;
    }

    abstract void drive(int position);

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        sb.append("Name:").append(this.getTankName()).append(", Country:").append(this.getCountry()).append(", Weight:").append(this.getWeight());
        sb.append(", Speed:").append(this.getSpeed()).append(", ViewRange:").append(this.getViewRange());
        sb.append(", Calibre:").append(this.getWeapCal()).append(", BackArmory:").append(this.getBackArm()).append(", FrontArmory:").append(this.getFrontArm()).append(", SideArmory:").append(this.getSidesArm());

        return sb.toString();
    }

    @Override
    public boolean equals(Object inputTank){
        if(inputTank == null || getClass() != inputTank.getClass()) return false;
        if(inputTank == this) return true;
        Tank tank = (Tank) inputTank;
        if(this.getBackArm() == tank.getBackArm() && this.getDegTurnTow() == tank.getDegTurnTow() && this.getFrontArm() == tank.getFrontArm() && this.getSidesArm() == tank.getSidesArm() && this.getSpeed() == tank.getSpeed() && this.getViewRange() == tank.getViewRange() && this.getWeapCal() == tank.getWeapCal() && this.getWeight() == tank.getWeight()){
            return true;
        }
        return false;
    }

    public int compareTo(Object inputTank) throws Exception{
        if(inputTank == null) throw new Exception("The input Tank is null");
        if(inputTank == this) return 0;
        Tank tank = (Tank) inputTank;
        if(tank.equals(this)){
            return 0;
        }
        return -1;
    }

    abstract void fire(int position);

    abstract void towTurn();

    public void setArmory(double side, double front, double back){
        this.sidesArm = side;
        this.frontArm = front;
        this.backArm = back;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getViewRange() {
        return viewRange;
    }

    public void setViewRange(int viewRange) {
        this.viewRange = viewRange;
    }

    public double getDegTurnTow() {
        return degTurnTow;
    }

    public void setDegTurnTow(double degTurnTow) {
        this.degTurnTow = degTurnTow;
    }

    public double getDegTurnVeh() {
        return degTurnVeh;
    }

    public void setDegTurnVeh(double degTurnVeh) {
        this.degTurnVeh = degTurnVeh;
    }

    public double getSidesArm() {
        return sidesArm;
    }

    public void setSidesArm(double sidesArm) {
        this.sidesArm = sidesArm;
    }

    public double getBackArm() {
        return backArm;
    }

    public void setBackArm(double backArm) {
        this.backArm = backArm;
    }

    public double getFrontArm() {
        return frontArm;
    }

    public void setFrontArm(double frontArm) {
        this.frontArm = frontArm;
    }

    public double getWeapCal() {
        return weapCal;
    }

    public void setWeapCal(double weapCal) {
        this.weapCal = weapCal;
    }

    public boolean isHasTower() {
        return hasTower;
    }

    public void setHasTower(boolean hasTower) {
        this.hasTower = hasTower;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTankName() {
        return tankName;
    }

    public void setTankName(String tankName) {
        this.tankName = tankName;
    }
}
