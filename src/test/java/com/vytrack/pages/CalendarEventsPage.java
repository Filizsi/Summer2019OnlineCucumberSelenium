package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarEventsPage extends BasePage{

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//tr[4]//td[@class='action-cell grid-cell grid-body-cell']")
    public WebElement dots;

    @FindBy(xpath = "//div[@class='actions-panel pull-right form-horizontal']//div//div/a")
    public WebElement gridButton;


    //label[contains(text(),‘View per page:’)]/..//button
    //button[class*=‘btn dropdown-toggle’]
    //button[@class='btn dropdown-toggle ']
    //we can use above ones too
    @FindBy(css="button[class*=‘btn dropdown-toggle’]")
    public WebElement viewPerPageToggle;

    @FindBy(css="span[class='grid-header-cell__label']")
    public List<WebElement> ColumnsNames;

    @FindBy(css="[class*='btn-group'] [class='dropdown-menu pull-right'] li")
    public List<WebElement> viewPerPageOptions;




   public void titleBoxIsChecked(){
       List<WebElement> boxes= Driver.get().findElements(By.xpath("//table[@class='grid table-hover table table-condensed']//tr//td[3]"));
       for(int i=2;i<boxes.size();i++){
           boxes.get(i).click();
           BrowserUtils.wait(1);

       }
       Assert.assertTrue(Driver.get().findElement(By.id("column-c93")).isDisplayed());
   }





    public void clickToCreateCalendarEvent(){
        BrowserUtils.waitForVisibility(createCalendarEvent, 5);
        BrowserUtils.waitForClickablility(createCalendarEvent, 5);
       createCalendarEvent.click();
    }


    public List<String> getColumnNames(){

       return BrowserUtils.getListOfStrings(ColumnsNames);
    }

    //retrieve the viewperpage option from application
    public List<String> getViewPerPageOptions(){
        BrowserUtils.waitForVisibility(viewPerPageToggle, 10);
        BrowserUtils.clickWithWait(viewPerPageToggle);
        return BrowserUtils.getListOfStrings(viewPerPageOptions);
    }

}
