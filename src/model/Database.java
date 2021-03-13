package model;

public class Database {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/election";
    private static final String user = "excel";
    private static final String password = "Galatians2:20";

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
