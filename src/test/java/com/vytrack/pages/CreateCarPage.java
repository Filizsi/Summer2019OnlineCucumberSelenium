package com.vytrack.pages;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;

public class CreateCarPage extends BasePage{

    @FindBy(css = "[id*='custom_entity_type_LicensePlate']")
    public WebElement licensePlateElement;

    @FindBy(name = "custom_entity_type[Driver]")
    public WebElement driverElement;

    @FindBy(name = "custom_entity_type[Location]")
    public WebElement locationElement;

    @FindBy(css = "[class='btn btn-success action-button']")
    public WebElement saveAndCloseButtonElement;

    @FindBy(css = "div[id*='FuelType']")
    public WebElement fuelTypeElement;

    //if this locator doesn't work, use [id^='uniform-custom_entity_type_Logo_file'] > span[class='action']
    @FindBy(name = "custom_entity_type[Logo][file]")
    public WebElement logoElement;

    @FindBy(name="custom_entity_type[ModelYear]")
    public WebElement modelYearElement;

    @FindBy(name="custom_entity_type[Color]")
    public WebElement colorElement;

    @FindBy(css="[title='Create Car']")
    public WebElement createCarButton;

    @FindBy(xpath = "//li//button[contains(text(),'Save and New')]")
    public WebElement saveAndNew;

    @FindBy(css = "div[class='btn-group pull-right'] > a[data-toggle='dropdown']")
    public WebElement saveASndCloseToggle;

    @FindBy(xpath = "//li//button[contains(text(),'Save and Close')]")
    public WebElement saveAndCloseButtonFromMenuElement;





    public void clickSaveAndAddNew(){
        waitUntilLoaderMaskDisappear();
        BrowserUtils.wait(3);
        BrowserUtils.clickWithWait(saveASndCloseToggle);
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(saveAndNew,5);
        BrowserUtils.clickWithWait(saveAndNew);

    }

    public void clickSaveAndClose(){
        waitUntilLoaderMaskDisappear();
        BrowserUtils.clickWithWait(saveASndCloseToggle);
        BrowserUtils.waitForVisibility(saveAndCloseButtonFromMenuElement, 5);
        BrowserUtils.clickWithWait(saveAndCloseButtonFromMenuElement);
    }

    public void uploadLogo(String pathToTheFile){
       logoElement.sendKeys(pathToTheFile);
    }

    /**
     * Select fuel type by visible text
     *
     * @param fuelType - Diesel, Electric, Hybrid
     *  <p>
     *  usage: CreateCarPage createCarPage = new CreateCarPage();
     *  <p>
     *  to select gasoline type
     *  createCarPage.selectFuelType("Diesel"); - if you want to select Diesel as fuel type
     */





    public void selectFuelType(String fuelType){
        String locator="//div[@class='select2-result-label' and text()='"+fuelType+"']";
        BrowserUtils.waitForClickablility(Driver.get().findElement(By.cssSelector("div[id*='FuelType']")),20);
        Driver.get().findElement(By.cssSelector("div[id*='FuelType']")).click();
        WebElement fuelTypeSelectionElement=Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForClickablility(fuelTypeSelectionElement,15);
        fuelTypeSelectionElement.click();
    }





    /**
     * This method stands for selecting tags
     * Provide tag name to select
     * If checkbox already selected, it will not do anything
     *
     * @param tagName - represents name of tag that has to be selected, like Junior, Senior or Purchased
     * @return webelement of checkbox that was selected
     * <p>
     * CreateCarPage createCarPage = new CreateCarPage();
     * <p>
     * createCarPage.selectTags("Senior"); // Senior tag will be selected
     */

    public WebElement selectTags(String tagName){
        //locator for checkbox is based on label name
        //label and checkbox are siblings
        String locator = "//label[text()='" + tagName + "']/preceding-sibling::input[@type='checkbox']";
        WebElement checkBox= Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForClickablility(checkBox,15);
        BrowserUtils.waitForVisibility(checkBox,15);
        if(!checkBox.isSelected()){
            checkBox.click();
        }
        return checkBox;
    }









}
