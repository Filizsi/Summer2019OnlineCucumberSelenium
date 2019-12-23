package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;

import java.util.List;

public class VehiclesPage extends BasePage{

    @FindBy(css="[title='Create Car']")
    public WebElement createACarElement;

    @FindBy(css="span[class='grid-header-cell__label']")
    public List<WebElement> columnName;

    //use this method to click on "Create a Car "button
    //method already contains waits to handle synchronization issues
    public void clickToCreateACar(){
        BrowserUtils.waitForVisibility(createACarElement,10);
        BrowserUtils.waitForClickablility(createACarElement,10);
        createACarElement.click();
    }

    //retrieve the column names from application
    public List<String> getColumnNames(){

       return  BrowserUtils.getListOfStrings(columnName);


    }

}
