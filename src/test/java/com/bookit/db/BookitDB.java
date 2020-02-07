package com.bookit.db;

import com.bookit.utilities.DBUtility;

/**
 * The idea of this class is very similar to the page class:
 * get actual results, bu not from the UI, from the data base.
 *
 * Here, I am gonna write methods that return some information from the DB based on queries
 */

public class BookitDB {

    /**
     * return users email based on id
     * @param userId
     * @return email
     */
    public String getUsersEmailById(int userId) {
        //SQL query to get email based on user id
        String query = "SELECT email FROM users WHERE id = " + userId;
        return DBUtility.getCellValue(query).toString();
    }
}
