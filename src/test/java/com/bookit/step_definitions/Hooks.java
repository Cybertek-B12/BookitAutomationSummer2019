package com.bookit.step_definitions;

import com.bookit.utilities.Environment;
import io.cucumber.java.Before;
import static io.restassured.RestAssured.*;

public class Hooks {
    /**
     * This hook will work,
     * only if scenario or feature has @api annotation
     */
    @Before("@api")
    public void setupAPI(){
        baseURI = Environment.BASE_URI;
    }
}
