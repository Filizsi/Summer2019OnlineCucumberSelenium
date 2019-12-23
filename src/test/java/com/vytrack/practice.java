package com.vytrack;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class practice {
    public static void main(String[] args) {
        Driver.get().get(ConfigurationReader.getProperty("url"));
        LoginPage loginPage=new LoginPage();
        loginPage.login(ConfigurationReader.getProperty("user_name"),ConfigurationReader.getProperty("password"));
        loginPage.navigateTo("Fleet","Vehicles");
        BrowserUtils.wait(3);
        List<WebElement> list= Driver.get().findElements(By.cssSelector("span[class='grid-header-cell__label']"));
        BrowserUtils.getListOfStrings(list);
        }
    }

