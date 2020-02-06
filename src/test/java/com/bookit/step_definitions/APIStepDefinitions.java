package com.bookit.step_definitions;

import com.bookit.utilities.APIUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.*;

public class APIStepDefinitions {
    private Response response;
    private String token;
    private JsonPath jsonPath;
    private ContentType contentType;

    @Given("authorization token is provided for {string}")
    public void authorization_token_is_provided_for(String role) {
        token = APIUtilities.getToken(role);
    }

    @Given("user accepts content type as {string}")
    public void user_accepts_content_type_as(String string) {
        if(string.toLowerCase().contains("json")){
            contentType = ContentType.JSON;
        }else if(string.toLowerCase().contains("xml")){
            contentType = ContentType.XML;
        }
    }

    @When("user sends GET request to {string}")
    public void user_sends_GET_request_to(String string) {
        response = given().
                        accept(contentType).
                        auth().oauth2(token).
                    when().
                        get(string);
    }

    //Then user should be able to see 18 rooms
    @Then("user should be able to see {int} rooms")
    public void user_should_be_able_to_see_rooms(int expected) {
        List<?> rooms = response.jsonPath().get();
        Assert.assertEquals(expected, rooms.size());
    }

    // And user verifies that response status code is 200
    @Then("user verifies that response status code is {int}")
    public void user_verifies_that_response_status_code_is(int expected) {
        Assert.assertEquals(expected, response.statusCode());
    }
    /**
     * Any number in cucumber test step, becomes step definition  (variable)
     * By changing this number, you are not changing a context of test step
     */
}
