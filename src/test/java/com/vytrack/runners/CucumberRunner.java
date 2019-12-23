package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//this(RunWith) is from junit, junit is engine for cucumber
@CucumberOptions(//path of our features folder
        features = "src/test/resources/features",//path to feature
        glue="com/vytrack/step_definitions",//path to step_definitions
        dryRun = true,
        tags="@driver_with_data_table",//to specify the test specifically, I want to run all the scenarios, which has this tags
        //      others are ignored
        plugin={"html:target/default-cucumber-reports",
        "json:target/cucumber.json"
        }//default cucumber html report
        //if we put ~@negative_test or write not@negative_test in front of the @, we skip that test
        //we can create any tag name, @modules, @smoke, @regression, 2user story

)
public class CucumberRunner {//this class is our trigger


}
