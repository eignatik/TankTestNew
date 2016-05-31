package com.acwg.tanks.DBase;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Eugen on 5/31/2016.
 */
public class ConnectionDB {
    private static String URL = "jdbc:mysql://localhost:3306/tanks?useSSL=false";
    private static String username = "root";
    private static  String password = "root";
    private static Connection connection;

    public static void connect(){

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, username, password);
            if(!connection.isClosed()){
                System.out.println("Connection is sucessed");
            }
        } catch (SQLException e){
            System.err.println("Driver is not founded");
        }
    }

    public static void disconnect(){
        try {
            connection.close();
            if(connection.isClosed()){
                System.out.println("Connection had been disconnected.");
            }
        } catch (SQLException e){
            System.err.println("Disconnecting failure");
        }
    }

    public static void insertTank(String tankName, String country, int speed, int weight, int viewrange, double sideArm, double frontArm, double backArm, double weapCal, boolean hasTower){
        try(Connection connection = DriverManager.getConnection(URL, username, password);
        Statement statement = connection.createStatement()) {
            int hasTowerInt;
            if(hasTower) hasTowerInt = 1;
            else hasTowerInt = 0;

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tanklist (tankname, country, speed, weight, viewrange, sidesarm, frontarm, backarm, weapcal, hastower) VALUES ('").append(tankName + "', ").append("'"+ country + "', ");
            sql.append(speed + ", ").append(weight + ", ").append(viewrange + ", ").append(sideArm + ", ").append(frontArm + ", ").append(backArm + ", ").append(weapCal + ", ").append(hasTowerInt + ");");
            String sqlStr = new String(sql);
            System.out.println(sqlStr + " will be executed");
            statement.execute(sqlStr);
            System.out.println("SQL executed.");
        } catch (SQLException e){
            System.err.println("Connection failure: " + e.getMessage());
        }
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
