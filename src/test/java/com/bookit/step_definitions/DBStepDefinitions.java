package com.bookit.step_definitions;

import com.bookit.db.BookitDB;
import com.bookit.utilities.DBUtility;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class DBStepDefinitions {

    BookitDB db = new BookitDB();

    @Given("user verifies that user with id {int} has email {string}")
    public void user_verifies_that_user_with_id_has_email(Integer int1, String string) {
        Assert.assertEquals(string, db.getUsersEmailById(int1));
    }
}
