package model;

public class Database {
    private static String url = "jdbc:mysql://localhost:3306/election";
    private static String user = "root";
    private static String password = "admin";

    public static String getUrl(){
        return url;
    }

    public static String getUser(){
        return user;
    }

    public static String getPassword(){
        return password;
    }
}
