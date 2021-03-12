package model;

public class Database {
    private static final String url = "jdbc:mysql://localhost:3306/election";
    private static final String user = "root";
    private static final String password = "admin";

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
