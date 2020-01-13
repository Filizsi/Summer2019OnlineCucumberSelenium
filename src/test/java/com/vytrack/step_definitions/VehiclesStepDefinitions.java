package com.vytrack.step_definitions;

import com.vytrack.pages.VehiclesPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

public class VehiclesStepDefinitions {
    VehiclesPage vehiclesPage=new VehiclesPage();
    @Then("user verifies  column names are displayed")
    public void userVerifiesColumnNamesAreDisplayed() {
        vehiclesPage.waitUntilLoaderMaskDisappear();
       vehiclesPage.getColumnNames();
    }
}
