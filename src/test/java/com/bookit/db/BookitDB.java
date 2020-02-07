package com.bookit.db;

import com.bookit.utilities.DBUtility;
public class BookitDB {

    public String getUsersEmailById(int userId) {
        String query = "SELECT email FROM users WHERE id = " + userId;
        return DBUtility.getCellValue(query).toString();
    }
}
