package model;

import java.sql.*;

public class Person {
    private String name;
    private String dob;
    private String gender;

    /**
     * Constructor
     * @param name
     * @param dob
     * @param gender
     */
    public Person(String name, String dob, String gender){
        this.name = name;
        this.dob = dob;
        this.gender = gender;
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

    public static Connection getConnection(){
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/election", "root", "admin");
            System.out.println("yoooo database is connected successfully");
            return conn;
        } catch (Exception err) {
            System.out.println(err.getMessage());
            return null;
        }
    }
}
