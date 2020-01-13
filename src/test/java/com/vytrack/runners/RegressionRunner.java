package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//this(RunWith) is from junit, junit is engine for cucumber
@CucumberOptions(//path of our features folder
        features = {"src/test/resources/features/Activities",
                    "src/test/resources/features/Fleet"},//path to feature
        glue="com/vytrack/step_definitions",//path to step_definitions
        dryRun = false,

        plugin={"html:target/default-cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        }//default cucumber html report
)
public class RegressionRunner {
}
