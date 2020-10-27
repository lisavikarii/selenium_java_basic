package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Sample9Task {
    WebDriver driver;
    private static WebDriverWait wait;
    static long startTime;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/loading_color");
        startTime = System.currentTimeMillis();
        wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
    }

    @After
    public void closeBrowser() {
        long endTime = System.currentTimeMillis();
        System.out.println("Total time was: " + (endTime - startTime));
        driver.quit();
    }

    @Test
    public void loadGreenSleep() throws Exception {
//         TODO:
//         * 1) click on start loading green button
//         * 2) check that button does not appear,

//         * but loading text is seen instead   "Loading green..."
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        WebElement greenbut = driver.findElement(By.id("start_green"));
        greenbut.click();
        assertFalse(greenbut.isDisplayed());
        Thread.sleep(100);
        WebElement loadgreen = driver.findElement(By.id("loading_green"));
        assertTrue(loadgreen.isDisplayed());
        Thread.sleep(4500);
        WebElement finishgreen = driver.findElement(By.id("finish_green"));
        assertTrue(finishgreen.isDisplayed());
        assertFalse(greenbut.isDisplayed());
        assertFalse(loadgreen.isDisplayed());

    }

    @Test
    public void loadGreenImplicit() throws Exception {
//         TODO:
//         * 1) click on start loading green button
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        WebElement greenbut = driver.findElement(By.id("start_green"));
        greenbut.click();
        assertFalse(greenbut.isDisplayed());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement loadgreen = driver.findElement(By.id("loading_green"));
        assertTrue(loadgreen.isDisplayed());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement finishgreen = driver.findElement(By.id("finish_green"));
        assertTrue(finishgreen.isDisplayed());
        assertFalse(greenbut.isDisplayed());
        assertFalse(loadgreen.isDisplayed());

    }

    @Test
    public void loadGreenExplicitWait() throws Exception {
//         TODO:
//         * 1) click on start loading green button
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        WebElement greenbut = driver.findElement(By.id("start_green"));
        greenbut.click();
        assertFalse(greenbut.isDisplayed());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loading_green")));
        WebElement loadgreen = driver.findElement(By.id("loading_green"));
        assertTrue(loadgreen.isDisplayed());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish_green")));
        WebElement finishgreen = driver.findElement(By.id("finish_green"));
        assertTrue(finishgreen.isDisplayed());
        assertFalse(greenbut.isDisplayed());
        assertFalse(loadgreen.isDisplayed());

    }

    @Test
    public void loadGreenAndBlueBonus() {
        /* TODO:
         * 0) wait until button to load green and blue appears
         * 1) click on start loading green and blue button
         * 2) check that button does not appear, but loading text is seen instead for green
         * 3) check that button does not appear, but loading text is seen instead for green and blue
         * 4) check that button and loading green does not appear,
         * 		but loading text is seen instead for blue and success for green is seen
         * 5) check that both button and loading text is not seen, success is seen instead
         */
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement gbbut = driver.findElement(By.id("start_green_and_blue"));
        gbbut.click();
        assertFalse(gbbut.isDisplayed());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement gwb = driver.findElement(By.id("loading_green_without_blue"));
        assertTrue(gwb.isDisplayed());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement bwg = driver.findElement(By.id("loading_green_with_blue"));
        assertFalse(gbbut.isDisplayed());
        assertTrue(gwb.isDisplayed());
        assertTrue(bwg.isDisplayed());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement lbwg = driver.findElement(By.id("loading_blue_without_green"));
        assertFalse(gbbut.isDisplayed());
        assertFalse(gwb.isDisplayed());
        assertTrue(lbwg.isDisplayed());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement fgab = driver.findElement(By.id("finish_green_and_blue"));
        assertFalse(gbbut.isDisplayed());
        assertFalse(bwg.isDisplayed());
        assertFalse(gwb.isDisplayed());
        assertFalse(lbwg.isDisplayed());
        assertTrue(fgab.isDisplayed());


    }

}