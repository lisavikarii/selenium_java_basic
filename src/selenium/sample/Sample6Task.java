package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
//         TODO:
//        2 ways to find text: "Heading 2 text":
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "Test Text 4"
//        1-2 ways to find text: "Test Text 5"
//        1-2 ways to find text: "This is also a button"
        System.out.println("Find element by id using xPath:");
        System.out.println("First way: ");
        System.out.println("\t text of element with id 'heading_2' is '" +
                driver.findElement(By.xpath("//*[@id='heading_2']")).getText() + "'");
                System.out.println("Second way: " + "\n" + "'" +
                driver.findElement(By.xpath("//h2[2]")).getText() + "'");
        System.out.println("First way: ");
                System.out.println("text of element with class 'test' is '" +
              driver.findElement(By.xpath("//div[@id='test1']/p[@class='test' and 1]")).getText() + "'");
        System.out.println("Second way: " + "\n" + "'" +
                driver.findElement(By.xpath("//*[@id='test1']/p[contains(@class, 'test')]")).getText() + "'");
        System.out.println("First way: ");
        System.out.println("text of element with class 'twoTest' is '" +
                driver.findElement(By.xpath("//p[@class='twoTest']")).getText() + "'");
        System.out.println("Second way: " + "\n" + "'" +
                driver.findElement(By.xpath("//*[@id='test1']/p[contains(@class, 'twoTest')]")).getText() + "'");
        System.out.println("First way: ");
        System.out.println("text of element with class 'twoTest' is '" +
                driver.findElement(By.xpath("//div[5]/p[@class='test' and 1]")).getText() + "'");
        System.out.println("Second way: " + "\n" + "'" +
                driver.findElement(By.xpath("//*[@id='test3']/p[contains(@class, 'test')]")).getText() + "'");
        System.out.println("First way: ");
        System.out.println("text of element with class 'test' is '" +
                driver.findElement(By.xpath("//div[5]//p[2]")).getText() + "'");
       System.out.println("Second way: " + "\n" + "'" +
                driver.findElement(By.xpath("//*[@id='test3']/p[2]")).getText() + "'");
        System.out.println("text of element with class 'Test' is '" +
                driver.findElement(By.xpath("//div[@id='test2']/p[@class='Test' and 1]")).getText() + "'");
        System.out.println("Second way: " + "\n" + "'" +
                driver.findElement(By.xpath("//div[6]//p[1]")).getText() + "'");
        System.out.println("First way: ");
        System.out.println("Value of element with name 'randomButton2' is '" +
                driver.findElement(By.xpath("//*[@name='randomButton2']")).getAttribute("value") + "'");
        System.out.println("Second way: " + "\n" + "'" +
                driver.findElement(By.xpath("//*[@id='buttonId']")).getAttribute("value") + "'");




    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "This is also a button"
        System.out.println("Find element by id using CSS:");
        System.out.println("First way: ");
        System.out.println("\t text of element with id 'heading_2' is '" +
                driver.findElement(By.cssSelector("#heading_2")).getText() + "'");
        System.out.println("Second way: " + "\n" + "'" +
                driver.findElement(By.cssSelector("h2:nth-of-type(2)")).getText() + "'");
        System.out.println("First way: ");
        System.out.println("\t text of element with class 'test' is '" +
                driver.findElement(By.cssSelector(".test")).getText() + "'");
        System.out.println("Second way: " + "\n" + "'" +
                driver.findElement(By.cssSelector("div:nth-of-type(4) > p:nth-child(1)")).getText() + "'");
        System.out.println("First way: ");
        System.out.println("\t text of element with class 'twoTest' is '" +
                driver.findElement(By.cssSelector(".twoTest")).getText() + "'");
        System.out.println("Second way: " + "\n" + "'" +
                driver.findElement(By.cssSelector("div:nth-of-type(4) > p:nth-child(2)")).getText() + "'");
        System.out.println("First way: ");
        System.out.println("\t text of element with id 'test3' and first child of it is '" +
                driver.findElement(By.cssSelector("#test3 > p:nth-child(1)")).getText() + "'");
        System.out.println("Second way: " + "\n" + "'" +
                driver.findElement(By.cssSelector("div:nth-of-type(5) > p:nth-child(1)")).getText() + "'");
        System.out.println("First way: ");
        System.out.println("\t value of element with name 'randomButton2' is '" +
        driver.findElement(By.cssSelector("[name='randomButton2']")).getAttribute("value") + "'");
        System.out.println("Second way: " + "\n" + "'" +
                driver.findElement(By.cssSelector("[id='buttonId']")).getAttribute("value") + "'");

    }
}
