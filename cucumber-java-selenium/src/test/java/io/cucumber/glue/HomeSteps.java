package io.cucumber.glue;

import io.cucumber.datatable.DataTable;
import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.pages.Home;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeSteps extends Context {

  public HomeSteps(Manager manager) {
    super(manager);
  }

  @Then("the homepage displays the following example links")
  public void the_homepage_displays_the_following_example_links(DataTable dataTable) {
    Home homePage = new Home(getDriver());

    List<String> actualData = homePage.getExampleLinksText();
    List<String> expectedData = dataTable.asList();

    assertEquals(expectedData, actualData, "The displayed example links do not match the expected list.");
  }
}