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
        // 2 ways to find text: "Heading 2 text":
        System.out.println("First way to find element by id using xPath");
        System.out.println("\t text of element with id 'heading_2' is " + driver.findElement(By.xpath("//*[@id = 'heading_2']")).getText() + " '");

        System.out.println("Second way to find element nth using xPath");
        System.out.println("\t text of 2-nd element with tag name 'h2' is " + driver.findElement(By.xpath("//h2[2]")).getText() + "'");

        // 1-2 ways to find text: "Test Text 1"
        System.out.println("First way to find element by all classes using xPath");
        System.out.println("\t text of element with class 'test' is " + driver.findElement(By.xpath("//*[@class='test']")).getText() + "'");

        //1-2 ways to find text: "Test Text 2"
        System.out.println("First way to find element by all classes using xPath");
        System.out.println("\t text of element with class 'twoTest' is " + driver.findElement(By.xpath("//*[@class='twoTest']")).getText() + "'");

        //1-2 ways to find text: "Test Text 3"
        System.out.println("First way to find element by id using xPath");
        System.out.println("\t text of element with id 'test3' is " + driver.findElement(By.xpath("//*[@id= 'test3']/p[1]")).getText() + "'");

        //1-2 ways to find text: "Test Text 4"
        System.out.println("First way to find element by id using xPath");
        System.out.println("\t text of element with id 'test3' is " + driver.findElement(By.xpath("//*[@id= 'test3']/p[2]")).getText() + "'");

        //1-2 ways to find text: "Test Text 5"
        System.out.println("First way to find element by id using xPath");
        System.out.println("\t text of element with id 'test2' is "  + driver.findElement(By.xpath("//*[@id= 'test2']/p[1]")).getText() + "'");

        //1-2 ways to find text: "This is also a button"
        System.out.println("First way to find element by other attributes using xPath");
        System.out.println("\t value of element with name 'randomButton2' is " + driver.findElement(By.xpath("//*[@name='randomButton2']")).getAttribute("value") + "'");

        System.out.println("Second way to find element by other attributes using xPath");
        System.out.println("\t name of element with value 'This is also a button' is " + driver.findElement(By.xpath("//*[@value='This is also a button']")).getAttribute("name") + "'");


    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//       // 1-2 ways to find text: "Heading 2 text"
        System.out.println("First way to find element by id using CSS");
        System.out.println("\t text of element with id 'heading_2' is " + driver.findElement(By.cssSelector("#heading_2")).getText() + "'");

        System.out.println("Second way to find element by element nth using CSS");
        System.out.println("\t text of 2-nd element with tag name 'h2' is " + driver.findElement(By.cssSelector("#heading_2")).getText() + "'");

//       // 1-2 ways to find text: "Test Text 1"
        System.out.println("First way to find element by all classes using CSS");
        System.out.println("\t text of element with class 'test' is " + driver.findElement(By.cssSelector("#test1 > p.test")).getText() + "'");

//        //1-2 ways to find text: "Test Text 2"
        System.out.println("First way to find element by all classes using CSS");
        System.out.println("\t text of element with class 'twoTest' is " + driver.findElement(By.cssSelector("#test1 > p.twoTest")).getText() + "'");

//       // 1-2 ways to find text: "Test Text 3"
        System.out.println("First way to find element by id using CSS");
        System.out.println("\t text of element with id 'test3' is " + driver.findElement(By.cssSelector("#test3 > p:nth-child(1)")).getText() + "'");

        System.out.println("Second way to find child element using CSS ");
        System.out.println("\t text of element with tag name 'p' which 8-th a direct child of element with tag name 'div' is " + driver.findElement(By.cssSelector("#test3 > p:nth-child(1)")).getText() + "'");

//       //1-2 ways to find text: "This is also a button"
        System.out.println("First way to find element by other attributes using CSS");
        System.out.println("\t value of element with name 'randomButton2' is " + driver.findElement(By.cssSelector("#buttonId")).getAttribute("value") + "'");

        System.out.println("Second way to find element by other attributes using CSS");
        System.out.println("\t name of element with value 'This is also a button' is " + driver.findElement(By.cssSelector("#buttonId")).getAttribute("name") + "'");
    }
}
