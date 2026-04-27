package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class BasicAuth extends Page {
    public BasicAuth(ChromeDriver driver) {
        super(driver);
    }

    public void visitURL(String url) {
        driver.get(url);
    }

    @FindBy(css = "p")
    private WebElement successMessage;

    public String displaySuccessfulMessage(){
        return successMessage.getText();
    }
}
