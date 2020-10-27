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

        System.out.println(driver.findElement(By.xpath("//*[@id='heading_2']")).getText());
        System.out.println(driver.findElement(By.xpath("//h2[2]")).getText());

        System.out.println(driver.findElement(By.xpath("//*[@id='test1']/p[@class='test']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id='test1']/p[contains(@class, 'tes')]")).getText());

        System.out.println(driver.findElement(By.xpath("//*[@id='test1']/p[contains(@class, 'two')]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@class='twoTest']")).getText());

        System.out.println(driver.findElement(By.xpath("//*[@id='test3']/p[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[contains(text(), 'Text 3')]")).getText());


        System.out.println(driver.findElement(By.xpath("//*[contains(text(), 'Text 4')]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id='test3']/p[2]")).getText());


        System.out.println(driver.findElement(By.xpath("//*[@id='test2']/p[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id='test2']/p[contains(@class, 'Test')]")).getText());



        System.out.println(driver.findElement(By.xpath("//*[@id='buttonId']")).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath("//*[@name='randomButton2']")).getAttribute("value"));


        //         TODO:
//        2 ways to find text: "Heading 2 text":
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "Test Text 4"
//        1-2 ways to find text: "Test Text 5"
//        1-2 ways to find text: "This is also a button"
    }

    @Test
    public void findElementByCssName() throws Exception {


        System.out.println(driver.findElement(By.cssSelector("#heading_2")).getText());
        System.out.println(driver.findElement(By.cssSelector("h2:nth-of-type(2)")).getText());


        System.out.println(driver.findElement(By.cssSelector("#test1 > p")).getText());
        System.out.println(driver.findElement(By.cssSelector("#test1 .test")).getText());


        System.out.println(driver.findElement(By.cssSelector("#test1 > p:nth-child(2)")).getText());
        System.out.println(driver.findElement(By.cssSelector(".twoTest")).getText());


        System.out.println(driver.findElement(By.cssSelector("#test3 > p:nth-child(1)")).getText());
        System.out.println(driver.findElement(By.cssSelector("#test3 p.test")).getText());


        System.out.println(driver.findElement(By.cssSelector("#buttonId")).getAttribute("value"));

//         TODO:
//        1-2 ways to find text: "Heading 2 text"
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "This is also a button"
    }
}
