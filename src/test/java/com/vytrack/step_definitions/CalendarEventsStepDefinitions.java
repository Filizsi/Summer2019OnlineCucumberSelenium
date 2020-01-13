package com.vytrack.step_definitions;

import com.vytrack.pages.CalendarEventsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class CalendarEventsStepDefinitions {

    CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
    @Then("user verifies that column names are displayed")
    public void user_verifies_that_column_names_are_displayed(List<String> dataTable) {
        // List<String> dataTable=this are list of strings now(data table, which in feature file)
        System.out.println(dataTable);
        calendarEventsPage.waitUntilLoaderMaskDisappear();

        Assert.assertEquals(dataTable,calendarEventsPage.getColumnNames());

    }

}
