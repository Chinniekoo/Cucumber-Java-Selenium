package io.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortableTable extends Page {

    public SortableTable(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(id = "table1")
    private WebElement table1;

    public List<Map<String, String>> getTableData() {
        List<Map<String, String>> tableData = new ArrayList<>();

        List<WebElement> heading = table1.findElements(By.cssSelector("thead th"));
        List<String> headingText = new ArrayList<>();

        for (WebElement h : heading) {
            headingText.add(h.getText().trim());
        }

        List<WebElement> body = table1.findElements(By.cssSelector("tbody tr"));

        for (WebElement row : body) {

            List<WebElement> tdElements = row.findElements(By.tagName("td"));
            Map<String, String> rowData = new HashMap<>();

            for (int i = 0; i < headingText.size(); i++) {
                if (i < tdElements.size()) {
                    String thText = headingText.get(i);
                    String tdText = tdElements.get(i).getText().trim();
                    rowData.put(thText, tdText);
                }
            }

            tableData.add(rowData);
        }

        return tableData;
    }
}
