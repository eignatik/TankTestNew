package com.acwg.tanks.DBase;

import com.acwg.tanks.Util.ValueException;
import com.acwg.tanks.Vehicle.Tank;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.HashMap;

/**
 * Created by Eugen on 5/31/2016.
 */
public class ModelDataApp {
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
            statement.execute(sqlStr);
            System.out.println(">SQL (insert) had been executed.");
        } catch (SQLException e){
            System.err.println(">insert is not successful: " + e.getMessage());
        }
    }

    public static void updateTank(String column, String updData, String condition) throws ValueException {
        if(column==null) throw new ValueException(column, " Key value is null");
        if(updData==null) throw new ValueException(updData, " data for updating value is null");
        if(condition==null) throw new ValueException(condition, " data for updating value is null");
        String cond = " WHERE " + condition + ";";
        try(Connection connection = DriverManager.getConnection(URL, username, password); Statement statement = connection.createStatement()){
            statement.executeUpdate("UPDATE tanklist SET " + column + "='" + updData + "'" + cond);
            System.out.println(">SQL (update) had been executed\n");
        } catch(SQLException e){
            System.err.println(">updating is not successeful: " + e.getMessage());
        }
    }

    public static Tank getTank(int id) throws ValueException{
        if(id == 0) throw new ValueException(Integer.toString(id), " id is zero.");
        Tank tank = new Tank();
        try(Connection connection = DriverManager.getConnection(URL, username, password); Statement statement = connection.createStatement()){
            ResultSet res = statement.executeQuery("SELECT * FROM tanklist WHERE id=" + id +";");
            while(res.next()){
                tank.setTankName(res.getString("tankname"));
                tank.setCountry(res.getString("country"));
                tank.setSpeed(res.getInt("speed"));
                tank.setWeight(res.getInt("weight"));
                tank.setViewRange(res.getInt("viewrange"));
                tank.setSidesArm(res.getDouble("sidesarm"));
                tank.setFrontArm(res.getDouble("frontarm"));
                tank.setWeapCal(res.getDouble("weapcal"));
                tank.setHasTower(res.getBoolean("hastower"));

            }

        } catch (SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return tank;
    }

    public static HashMap<String, Tank> getTanks(){
        try(Connection connection = DriverManager.getConnection(URL, username, password); Statement statement = connection.createStatement()){
            ResultSet res = statement.executeQuery("SELECT * FROM tanklist;");

            //Tank tank = new Tank();
            while(res.next()){
                System.out.println(res.getString("tankname"));
            }

        } catch (SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return new HashMap();
    }

    public static boolean deleteTank(int id) throws ValueException{
        if(id == 0) throw new ValueException(Integer.toString(id), " id is zero.");
        try(Connection connection = DriverManager.getConnection(URL, username, password); Statement statement = connection.createStatement()){
            statement.executeUpdate("DELETE FROM tanklist WHERE id=" + id +";");
            System.out.println(">SQL (delete) had been executed\n");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return true;
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
