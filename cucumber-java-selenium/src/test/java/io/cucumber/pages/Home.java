package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Home extends Page {

  public Home(ChromeDriver driver) {
    super(driver);
  }

  @FindBy(css = "h1")
  private WebElement title;

  @FindBy(css = "li > a")
  private List<WebElement> exampleLinks;

  public WebElement getTitle() {
    return title;
  }

  public List<String> getExampleLinksText() {
    List<String> exampleLinksText = new ArrayList<>();

    for (WebElement element : exampleLinks) {
      exampleLinksText.add(element.getText());
    }

    return exampleLinksText;
  }
}