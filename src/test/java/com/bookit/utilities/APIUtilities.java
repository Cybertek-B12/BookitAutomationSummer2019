package com.bookit.utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class APIUtilities {
    private static String URI = ConfigurationReader.getProperty("bookit.api.qa1");

    /**
     * Method that generates access token
     *
     * @return bearer token
     */
    public static String getToken() {
        Response response = given().
                queryParam("email", ConfigurationReader.getProperty("team.leader.email")).
                queryParam("password", ConfigurationReader.getProperty("team.leader.password")).
                when().
                get("/sign").prettyPeek();
        return response.jsonPath().getString("accessToken");
    }

    /**
     * Method that generates access token
     * @param role - type of user. allowed types: student team leader, student team member and teacher
     * @return bearer token
     */
    public static String getToken(String role) {
        String userName = "";
        String password = "";
        if (role.toLowerCase().contains("lead")) {
            userName = ConfigurationReader.getProperty("team.leader.email");
            password = ConfigurationReader.getProperty("team.leader.password");
        } else if (role.toLowerCase().contains("teacher")) {
            userName = ConfigurationReader.getProperty("teacher.email");
            password = ConfigurationReader.getProperty("teacher.password");
        } else if (role.toLowerCase().contains("member")) {
            userName = ConfigurationReader.getProperty("team.member.email");
            password = ConfigurationReader.getProperty("team.member.password");
        } else {
            throw new RuntimeException("Invalid user type!");
        }
        Response response = given().
                queryParam("email", userName).
                queryParam("password", password).
                when().
                get("/sign").prettyPeek();
        return response.jsonPath().getString("accessToken");
    }


    /**
     * Method to find duplicates in the list of objects. Override equals method for your custom class and provide strategy of equality.
     *
     * @param list of objects to search for duplicates
     * @return true or false
     */
    public static boolean hasDuplicates(List list) {
        boolean hasDuplicates = false;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j)) && i != j) {
                    hasDuplicates = true;
                    System.out.println("Duplicate: " + list.get(i));
                    break;
                }
            }
        }
        return hasDuplicates;
    }
}
