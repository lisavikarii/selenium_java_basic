package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;


import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void selectCheckBox() throws Exception {
//        check that none of the checkboxes are ticked
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected()); // checkboxes are NOT selected
        }
//        tick  "Option 2"
        checkBoxes.get(1).click();

//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
        assertFalse(checkBoxes.get(0).isSelected()||checkBoxes.get(2).isSelected()); // checkboxes are NOT selected
        assertTrue(checkBoxes.get(1).isSelected()); // checkbox is selected

//        tick  "Option 3"
        checkBoxes.get(2).click();

//        click result
        driver.findElement(By.cssSelector("#result_button_checkbox")).click();

//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
        assertEquals("You selected value(s): Option 2, Option 3",
                driver.findElement(By.cssSelector("#result_checkbox")).getText());
    }


    @Test
    public void selectRadioButton() throws Exception {
//        check that none of the radio buttons are selected
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));
        for (WebElement radioButton : radioButtons) {
            assertFalse(radioButton.isSelected()); // radio buttons are NOT selected
        }
//        select  "Option 3"
        radioButtons.get(2).click();

//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
        assertFalse(radioButtons.get(0).isSelected()||radioButtons.get(1).isSelected()); // checkboxes are NOT selected
        assertTrue(radioButtons.get(2).isSelected()); // checkbox is selected

//        select  "Option 1"
        radioButtons.get(0).click();

//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
        assertFalse(radioButtons.get(2).isSelected()||radioButtons.get(1).isSelected()); // checkboxes are NOT selected
        assertTrue(radioButtons.get(0).isSelected()); // checkbox is selected

//        click result
        driver.findElement(By.cssSelector("#result_button_ratio")).click();

//        check that 'You selected option: Option 1' text is being displayed
        assertEquals("You selected option: Option 1",
                driver.findElement(By.cssSelector("#result_radio")).getText());
    }

    @Test
    public void selectOption() throws Exception {
//        select "Option 3" in Select
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        dropdown.selectByVisibleText("Option 3");

//        check that selected option is "Option 3"
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());

//        select "Option 2" in Select
        dropdown.selectByVisibleText("Option 2");

//        check that selected option is "Option 2"
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());

//        click result
        driver.findElement(By.cssSelector("#result_button_select")).click();

//        check that 'You selected option: Option 2' text is being displayed
        assertEquals("You selected option: Option 2",
                driver.findElement(By.cssSelector("#result_select")).getText());
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//        enter date '4 of July 2007' using calendar widget
        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        dateBox.click();

        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        assertEquals("October 2020", driver.findElement(By.cssSelector(".ui-datepicker-title")).getText());

        while(!(driver.findElement(By.cssSelector(".ui-datepicker-title")).getText().equals("July 2007"))){
            dateWidget.findElement(By.className("ui-datepicker-prev")).click();
        }
        dateWidget.findElement(By.xpath("//a[text()='4']")).click();

//        click result
        driver.findElement(By.cssSelector("#result_button_date")).click();

//        check that correct date is added
        assertEquals("You entered date: 07/04/2007",
                driver.findElement(By.cssSelector("#result_date")).getText());
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//        enter date '2 of May 1959' using text
        String dateToEnter = "05/02/1959";
        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        dateBox.clear();
        dateBox.sendKeys(dateToEnter);
        dateBox.sendKeys(Keys.ENTER);

//        click result
        driver.findElement(By.cssSelector("#result_button_date")).click();

//        check that correct date is added
        assertEquals("You entered date: 05/02/1959",
                driver.findElement(By.cssSelector("#result_date")).getText());
    }
}