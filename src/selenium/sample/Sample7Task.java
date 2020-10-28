package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
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
        List <WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
//         TODO:
         // check that none of the checkboxes are ticked
        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected());
        }
        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='checkbox']"));
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox']"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
        // tick  "Option 2"
        option2.click();

        //check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
        assertTrue(!option1.isSelected() && option2.isSelected() && !option3.isSelected());

        // tick  "Option 3"
        option3.click();

        WebElement resultButton = driver.findElement(By.cssSelector("#result_button_checkbox"));
        // click result
        resultButton.click();

        WebElement resultText = driver.findElement(By.cssSelector("#result_checkbox"));
        // check that text 'You selected value(s): Option 2, Option 3' is being displayed
        assertTrue(resultText.isDisplayed());

    }


    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
     //        check that none of the radio are selected
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));

        for (WebElement radioButton : radioButtons) {
            assertFalse(radioButton.isSelected());
        }
        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='radio'"));
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio'"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='radio'"));
    //        select  "Option 3"
        option3.click();
        assertTrue(option3.isSelected());

    //        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
        assertTrue(!option1.isSelected()&&!option2.isSelected()&& option3.isSelected());

    //        select  "Option 1"
        option1.click();

    //        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
        assertTrue(option1.isSelected()&& !option2.isSelected()&& !option3.isSelected());

    //        click result
        WebElement resultButton = driver.findElement(By.cssSelector("#result_button_ratio"));
        resultButton.click();

        // check that 'You selected option: Option 1' text is being displayed
        WebElement resultText = driver.findElement(By.cssSelector("#result_radio"));
        assertTrue(resultText.isDisplayed());
    }

    @Test
    public void selectOption() throws Exception {
     // select "Option 3" in Select
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        assertEquals("Choose your option", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Option 3");

        //check that selected option is "Option 3"
        assertEquals("Option 3",dropdown.getFirstSelectedOption().getText());

      //        select "Option 2" in Select
        dropdown.selectByIndex(2);

        //        check that selected option is "Option 2"
        assertEquals("Option 2",dropdown.getFirstSelectedOption().getText());

    //        click result
        WebElement resultButton = driver.findElement(By.id("result_button_select"));
        resultButton.click();

    //        check that 'You selected option: Option 2' text is being displayed
        WebElement resultSelect = driver.findElement(By.id("result_select"));
        assertTrue(resultSelect.isDisplayed());
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
        // enter date '4 of July 2007' using calendar widget
        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        dateBox.click();

        Period diff = Period.between(
                LocalDate.parse("2007-07-04").withDayOfMonth(1),
                LocalDate.now().withDayOfMonth(1));
        int monthCount = (int) diff.toTotalMonths();

        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        for (int i = 0; i < monthCount; i++) {
            Thread.sleep(1000);
            dateWidget.findElement(By.className("ui-datepicker-prev")).click();
        }
        dateWidget.findElement(By.xpath("//a[text()='4']")).click();
        assertEquals("07/04/2007", dateBox.getAttribute("value"));











    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
    // enter date '2 of May 1959' using text
        String dateToEnter = "5/2/1959";
        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        assertEquals("", dateBox.getAttribute("value"));

        dateBox.clear();
        dateBox.sendKeys(dateToEnter);

    // check that correct date is added
        assertEquals(dateToEnter, dateBox.getAttribute("value"));
    }
}
