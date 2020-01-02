package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.*;

public class TopMenuStepDefinitions {
    LoginPage loginPage=new LoginPage();
    @When("user navigates to {string} then to {string}")
    public void user_navigates_to_then_to(String module, String submodule) {
        BrowserUtils.wait(3);
        loginPage.navigateTo(module,submodule);

    }


}
