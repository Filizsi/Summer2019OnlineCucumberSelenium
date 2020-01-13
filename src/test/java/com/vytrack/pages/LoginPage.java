package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//According to page object model design
//we have to create corresponding page class
//for each page application
//login page=login page class
//every page class will store web elements
//and methods related to that page
public class LoginPage extends BasePage{
    @FindBy(id="prependedInput")//this line will initialize webelement
    public WebElement userNameInput;

    @FindBy(id="prependedInput2")//without findBy webelement will be null
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(css = "[class='alert alert-error']")
    public WebElement warningMessage;

//    public LoginPage(){
//        //this class will get driver for finding webelements
//        //constructor is mandatory, if u want to use @FindBy annataion
//        //this means login page class
//        //Driver.get(), returns web driver object
//        PageFactory.initElements(Driver.get(),this);
//        //which driver will be used            //which page, this page
//
//    }
    /*
    reusable login method
    just call this method and provide username and password to login
    //provide username and password as parameters
    @param userName
    @param password
     */
    public void login(String userName, String password){
        userNameInput.sendKeys(userName);
        //Keys.ENTER to replace login click
        passwordInput.sendKeys(password, Keys.ENTER);

    }

    public void login(){
        login(ConfigurationReader.getProperty("driverUsername"),ConfigurationReader.getProperty("password"));
    }

    public void login(String role){
//        if(role.equals("driver")){
//            login(ConfigurationReader.getProperty("driverUsername"),ConfigurationReader.getProperty("password"));
//        }else if(role.equals("store.manager")){
//            login(ConfigurationReader.getProperty("storeManagerUsername"),ConfigurationReader.getProperty("password"));
//        }else if(role.equals("sales.manager")){
//            login(ConfigurationReader.getProperty("salesManagerUsername"),ConfigurationReader.getProperty("password"));
//        }

        String userName="";
        String password=ConfigurationReader.getProperty("password");
        switch(role){
            case "driver":
                userName=ConfigurationReader.getProperty("driverUsername");
                break;
            case "store manager":
                userName=ConfigurationReader.getProperty("storeManagerUsername");
                break;
            case "sales manager"  :
                userName=ConfigurationReader.getProperty("salesManagerUsername");
                break;
            default:
                throw new RuntimeException("Invalid role");
        }
        login(userName,password);
    }


}
