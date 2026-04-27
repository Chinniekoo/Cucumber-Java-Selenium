package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.pages.SortableTable;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortableTableSteps extends Context {

    public SortableTableSteps(Manager manager) {
        super(manager);
    }

    @Then("^the Example 1 table displays the following results")
    public void the_example_table_displays_the_following_results(DataTable dataTable) {
        SortableTable sortableTablePage = new SortableTable(getDriver());
        List<Map<String, String>> actualData = sortableTablePage.getTableData();
        List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);

        assertEquals(expectedData.size(), actualData.size(),
                "The number of rows in the table did not match the expected count.");

        for (int i = 0; i < expectedData.size(); i++) {
            Map<String, String> expectedResultRow = expectedData.get(i);
            Map<String, String> actualResultRow = actualData.get(i);

            for (String expectedColumn : expectedResultRow.keySet()) {
                assertEquals(
                        expectedResultRow.get(expectedColumn),
                        actualResultRow.get(expectedColumn),
                        "Column value mismatch at row " + (i + 1) + " for column: " + expectedColumn);
            }
        }
    }
}
