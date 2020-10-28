package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Sample8Task {
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
        driver.get("https://kristinek.github.io/site/examples/po");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void styleChecks() throws Exception {
    //         TODO:
        WebElement div_h2 = driver.findElement(By.xpath("//div[h2]"));

        // check h1 element font-size 64px
        WebElement h1 = driver.findElement(By.cssSelector("h1"));
        assertEquals("64px", h1.getCssValue("font-size"));

        //check the background of top 2 sections
        WebElement section = driver.findElement(By.cssSelector(".w3-pale-red"));
        assertEquals("rgba(255, 221, 221, 1)", section.getCssValue("background-color"));
        WebElement section1 = driver.findElement(By.className("w3-pale-yellow"));
        assertEquals("rgba(255, 255, 204, 1)", section1.getCssValue("background-color"));

        //rgba(255, 221, 221, 1);
        assertEquals("rgba(255, 221, 221, 1)", div_h2.getCssValue("background-color"));





//        check the background of top 2 sections
//        rgba(255, 221, 221, 1);
//        check h1 element font-size 64px
    }
}
