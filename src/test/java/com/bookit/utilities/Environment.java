package com.bookit.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {
    public static final String URL;
    public static final String DB_USERNAME;
    public static final String DB_PASSWORD;
    public static final String DB_HOST;
    public static final String BASE_URI;
    public static final String TEACHER_USERNAME;
    public static final String TEACHER_PASSWORD;
    public static final String MEMBER_USERNAME;
    public static final String MEMBER_PASSWORD;
    public static final String LEADER_USERNAME;
    public static final String LEADER_PASSWORD;
    public static final String API_BASE_PATH;

    static {
        Properties properties = null;
        String environment = ConfigurationReader.getProperty("environment");
        try {
            //https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
            String path = System.getProperty("user.dir") + String.format("/src/test/resources/environment/%s.properties", environment);
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        URL = properties.getProperty("url");
        DB_HOST = properties.getProperty("db_host");
        API_BASE_PATH = properties.getProperty("db_host");
        DB_USERNAME = properties.getProperty("db_username");
        DB_PASSWORD = properties.getProperty("db_password");
        BASE_URI = properties.getProperty("base_url");
        TEACHER_USERNAME = properties.getProperty("teacher_email");
        TEACHER_PASSWORD = properties.getProperty("teacher_password");
        MEMBER_USERNAME = properties.getProperty("team_member_email");
        MEMBER_PASSWORD = properties.getProperty("team_member_password");
        LEADER_USERNAME = properties.getProperty("team_leader_email");
        LEADER_PASSWORD = properties.getProperty("team_leader_password");
    }
}