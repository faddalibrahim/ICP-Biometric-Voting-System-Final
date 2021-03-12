package model;

import java.sql.*;
import java.util.HashMap;

public class Person {
    private double id;
    private String name;
    private String dob;
    private String gender;
    private int authStatus = 0;

    /**
     * Constructor
     * @param name
     * @param dob
     * @param gender
     */
    public Person(double id, String name, String dob, String gender){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    public Person(){}

    /**
     * Accessor Method:getId()
     * @return id
     */
    public double getId(){
        return this.id;
    }

    /**
     * Accessor Method:getName()
     * @return name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Accessor Method:getDob()
     * @return dob
     */
    public String getDob(){
        return this.dob;
    }

    /**
     * Accessor Method:getGender()
     * @return gender
     */
    public String getGender(){
        return this.gender;
    }

    /**
     * Accessor Method:getAuthStatus()
     * @return authStatus
     */
    public int getAuthStatus(){
        return this.authStatus;
    }





    /**
     * Mutator Method:setId()
     * @param newId
     */
    public void setName(double newId){
        this.id = newId;
    }

    /**
     * Mutator Method:setName()
     * @param newName
     */
    public void setName(String newName){
        this.name = newName;
    }

    /**
     * Mutator Method:setDob()
     * @param newDob
     */
    public void setDob(String newDob){
        this.dob = newDob;
    }

    /**
     * Mutator Method:setGender()
     * @param newGender
     */
    public void setGender(String newGender){
        this.name = newGender;
    }

    /**
     * Mutator Method:setAuthStatus()
     * @param newAuthStatus
     */
    public void setAuthStatus(int newAuthStatus){
        this.authStatus = newAuthStatus;
    }

    public static Connection getConnection(){
        Connection conn;
        try {
            conn = DriverManager.getConnection(Database.getUrl(), Database.getUser(), Database.getPassword());
            System.out.println("yoooo database is connected successfully");
            return conn;
        } catch (Exception err) {
            System.out.println(err.getMessage());
            return null;
        }
    }

}
