package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//this(RunWith) is from junit, junit is engine for cucumber
@CucumberOptions(//path of our features folder
        features = "src/test/resources/features"
)
public class CucumberRunner {//this class is our trigger


}
