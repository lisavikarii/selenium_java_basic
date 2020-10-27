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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static java.util.Calendar.MONTH;
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
//         TODO:
//        check that none of the checkboxes are ticked
//        tick  "Option 2"
//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
//        tick  "Option 3"
//        click result
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));

        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected()); // checkboxes are NOT selected
            checkBox.click();
            assertTrue(checkBox.isSelected()); // checkboxes are selected
            checkBox.click();
            assertFalse(checkBox.isSelected()); // checkboxes are NOT selected
        }

        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='checkbox']"));
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox']"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
        option2.click();
        assertFalse(option1.isSelected());
        assertTrue(option2.isSelected());
        assertFalse(option3.isSelected());
        option3.click();
        assertFalse(option1.isSelected());
        assertTrue(option2.isSelected());
        assertTrue(option3.isSelected());
        driver.findElement(By.id("result_button_checkbox")).click();
        WebElement text = driver.findElement(By.id("result_checkbox"));
        assertEquals(text.getText(), ("You selected value(s): " + driver.findElement(By.cssSelector("[id='vfb-6-1']")).getAttribute("value")  + ", " + driver.findElement(By.cssSelector("[id='vfb-6-2']")).getAttribute("value") ));
    }


    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
//        check that none of the radio are selected
//        select  "Option 3"
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
//        select  "Option 1"
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
//        click result
//        check that 'You selected option: Option 1' text is being displayed
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));

        for (WebElement radioButton : radioButtons) {
            assertFalse(radioButton.isSelected()); // radio are NOT selected
            radioButton.click();
            assertTrue(radioButton.isSelected()); // radio are selected
        }

        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='radio'"));
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio'"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='radio'"));
        option3.click();
        assertFalse(option1.isSelected());
        assertFalse(option2.isSelected());
        assertTrue(option3.isSelected());
        option1.click();
        assertTrue(option1.isSelected());
        assertFalse(option2.isSelected());
        assertFalse(option3.isSelected());
        driver.findElement(By.id("result_button_ratio")).click();
        WebElement text = driver.findElement(By.id("result_radio"));
        assertEquals(text.getText(), ("You selected option: " + driver.findElement(By.cssSelector("[id='vfb-7-1']")).getAttribute("value")));

    }

    @Test
    public void selectOption() throws Exception {
//        select "Option 3" in Select
//        check that selected option is "Option 3"
//        select "Option 2" in Select
//        check that selected option is "Option 2"
//        click result
//        check that 'You selected option: Option 2' text is being displayed
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        assertEquals("Choose your option", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByIndex(3);
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByIndex(2);
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());
        driver.findElement(By.id("result_button_select")).click();
        WebElement text = driver.findElement(By.id("result_select"));
        assertEquals(text.getText(), ("You selected option: " + dropdown.getFirstSelectedOption().getText()));
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -159);
        String result = new SimpleDateFormat("MM/04/yyyy").format(cal.getTime());

        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        assertEquals("", dateBox.getAttribute("value"));

        dateBox.click();
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
//    go back 159 month in calendar on page
        for (int i = 0; i < 159; i++) {
            dateWidget.findElement(By.className("ui-datepicker-prev")).click();
        }
//    select date 4
        dateWidget.findElement(By.xpath("//a[text()='4']")).click();

        assertEquals(result, dateBox.getAttribute("value"));
        driver.findElement(By.id("result_button_date")).click();
        WebElement text = driver.findElement(By.id("result_date"));
        assertEquals(text.getText(), ("You entered date: " + driver.findElement(By.cssSelector("[id='vfb-8']")).getAttribute("value")));

    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
//        enter date '2 of May 1959' using text
//        check that correct date is added
        String dateToEnter = "05/02/1959";

        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        assertEquals("", dateBox.getAttribute("value"));

        dateBox.clear();
        dateBox.sendKeys(dateToEnter);
        assertEquals(dateToEnter, dateBox.getAttribute("value"));
        driver.findElement(By.className("w3-third")).click();
        driver.findElement(By.id("result_button_date")).click();
        WebElement text = driver.findElement(By.id("result_date"));
        assertEquals(text.getText(), ("You entered date: " + driver.findElement(By.cssSelector("[id='vfb-8']")).getAttribute("value")));

    }
}
