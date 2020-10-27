package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Sample6Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void findElementByXPath() throws Exception {
        System.out.println("Find element by id using xPath:");

//        2 ways to find text: "Heading 2 text":
        System.out.println("\t text of element with id 'heading_2' is '" +
                driver.findElement(By.xpath("//*[@id='heading_2']")).getText() + "'");
        System.out.println("\t text of element which contains text 'Heading 2' is '" +
                driver.findElement(By.xpath("//*[contains(text(), 'Heading 2')]")).getText() + "'");

//        1-2 ways to find text: "Test Text 1"
        System.out.println("\t text of element with class 'test' is '" +
                driver.findElement(By.xpath("//*[contains(@class, 'test')]")).getText() + "'");

//        1-2 ways to find text: "Test Text 2"
        System.out.println("\t text of element with class 'twoRest' is '" +
                driver.findElement(By.xpath("//*[contains(@class, 'twoTest')]")).getText() + "'");

//        1-2 ways to find text: "Test Text 3"
        System.out.println("\t text of element with class 'test' which is a direct child of element with id 'test3' is '" +
                driver.findElement(By.xpath("//*[@id='test3']/p[contains(@class, 'test')]")).getText() + "'");
        System.out.println("\t text of 1st element with tag name 'test3' is '" +
                driver.findElement(By.xpath("//div[@id='test3']/p[@class='test'][1]")).getText());

//        1-2 ways to find text: "Test Text 4"
        System.out.println("\t text of element which contains text 'Text 4' is '" +
                driver.findElement(By.xpath("//*[contains(text(), 'Text 4')]")).getText() + "'");
        System.out.println("\t text of 2nd element with tag name 'test3' is '" +
                driver.findElement(By.xpath("//div[@id='test3']/p[@class='test'][2]")).getText());

//        1-2 ways to find text: "Test Text 5"
        System.out.println("\t text of element which contains text 'Text 5' is '" +
                driver.findElement(By.xpath("//*[contains(text(), 'Text 5')]")).getText() + "'");
        System.out.println("\t text of element with tag name 'Test' in 'test2' is '" +
                driver.findElement(By.xpath("//div[@id='test2']/p[@class='Test']")).getText());

//        1-2 ways to find text: "This is also a button"
        System.out.println("\t value of element with id 'buttonId' is '" +
                driver.findElement(By.xpath("//*[@id='buttonId']")).getAttribute("value") + "'");
        System.out.println("\t value of 2nd input element is '" +
                driver.findElement(By.xpath("//input[2]")).getAttribute("value") + "'");
    }

    @Test
    public void findElementByCssName() throws Exception {
        System.out.println("Find element by id using CSS:");

//        1-2 ways to find text: "Heading 2 text"
        System.out.println("\t text of element with id 'heading_2' is '" +
                driver.findElement(By.cssSelector("#heading_2")).getText() + "'");

//        1-2 ways to find text: "Test Text 1"
        System.out.println("\t text of element with class 'test' is '" +
                driver.findElement(By.cssSelector(".test")).getText() + "'");

//        1-2 ways to find text: "Test Text 2"
        System.out.println("\t text of element with class 'twoTest' is '" +
                driver.findElement(By.cssSelector(".twoTest")).getText() + "'");

//        1-2 ways to find text: "Test Text 3"
        System.out.println("\t text of element class 'test' which is a direct child of element with id 'test3' is '" +
                driver.findElement(By.cssSelector("#test3 .test")).getText() + "'");

//        1-2 ways to find text: "This is also a button"
        System.out.println("\t value of element with id 'buttonId' is '" +
                driver.findElement(By.cssSelector("#buttonId")).getAttribute("value") + "'");
    }
}
