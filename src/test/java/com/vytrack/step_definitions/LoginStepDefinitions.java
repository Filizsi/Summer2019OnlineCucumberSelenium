package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.*;

import org.junit.Assert;

import java.util.Map;

public class LoginStepDefinitions {
    LoginPage loginPage=new LoginPage();//created login page object for all methods

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
//        System.out.println("I am on the login page");
        Driver.get().get(ConfigurationReader.getProperty("url"));


    }

    @Then("user logs in as store manager")
    public void user_logs_in_as_store_manager() {
//        System.out.println("login as storemanager");
        //we read username and password from properties file
        String username=ConfigurationReader.getProperty("username");
        String password=ConfigurationReader.getProperty("password");
        loginPage.login(username,password);


    }


    //user verifies that "Dashboard" page subtitle is displayed//double coutes"" is parameter for step definition method
    @Then("user verifies that {string} page subtitle is displayed")
    public void user_verifies_that_page_subtitle_is_displayed(String string) {
        Assert.assertEquals(string,loginPage.getPageSubTitle());
        System.out.println("verifying page subtitle"+string);
    }


    @Then("user logs in as driver")
    public void user_logs_in_as_driver() {

        System.out.println("login as driver");
    }

    @Then("user logs in as sales manager")
    public void user_logs_in_as_sales_manager() {

        System.out.println("login as sales manager");
    }
    @Then("user enters {string} username and {string}Password")
    public void user_enters_username_and_Password(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("user verifies that {string}message is displayed")
    public void user_verifies_that_message_is_dsiplayed(String string) {
        System.out.println("verified that warning message is displayed as "+string);


    }
    //    Then user logs in as driver with following credentials
//            | username | user160     |
//            | password | UserUser123 |

    @Then("user logs in as driver with following credentials")
    public void user_logs_in_as_driver_with_following_credentials(Map<String,String> dataTable) {
        System.out.println(dataTable);
        loginPage.login(dataTable.get("username"),dataTable.get("password"));

    }


    @Then("user login as {string}")
    public void userLoginAs(String role) {
        loginPage.login(role);
    }

    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expected) {
        String actual=Driver.get().getTitle();
        Assert.assertEquals(expected,actual);
    }
}
