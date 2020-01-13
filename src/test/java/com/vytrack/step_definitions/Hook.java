package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {
    //based on the annotation, hook knows it has to run before and after method with every scenario
    @Before//it is coming Io.cucumber java
    public void setup(){
        Driver.get().manage().window().maximize();
        System.out.println("Test setup");
    }
    @After//coming from cucumber java

    public void teardown(Scenario scenario){
        if(scenario.isFailed()){
            System.out.println("Test failed");
            byte[] screenshot=((TakesScreenshot)Driver.get()).getScreenshotAs((OutputType.BYTES));
            scenario.embed(screenshot,"image/png","Smoke test");
        }else{
            System.out.println("Cleanup");
            System.out.println("Test completed!");

        }
        //after every test we gonna close browser
        Driver.close();

    }
}
