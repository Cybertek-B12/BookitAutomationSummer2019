package com.bookit.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
          "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "com/bookit/step_definitions",
        dryRun = true,
        tags = "@delete_student"
)
public class CucumberRunner {
}
