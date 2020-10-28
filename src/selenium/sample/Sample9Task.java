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

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();

        wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        driver.get("https://kristinek.github.io/site/examples/loading_color");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void loadGreenSleep() throws Exception {
//         TODO:
//         * 1) click on start loading green button
        WebElement startGreenButton = driver.findElement(By.id("start_green"));
        startGreenButton.click();
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
        WebElement loadingGreen = driver.findElement(By.id("loading_green"));
        assertTrue(!startGreenButton.isDisplayed() && loadingGreen.isDisplayed());
        Thread.sleep(5000);

//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        WebElement greenLoaded = driver.findElement(By.id("finish_green"));
        assertTrue(!startGreenButton.isDisplayed() && !loadingGreen.isDisplayed() && greenLoaded.isDisplayed());

    }

    @Test
    public void loadGreenImplicit() throws Exception {
//         TODO:
//         * 1) click on start loading green button
        WebElement startGreenButton = driver.findElement(By.id("start_green"));
        startGreenButton.click();
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
        WebElement loadingGreen = driver.findElement(By.id("loading_green"));
        assertTrue(!startGreenButton.isDisplayed() && loadingGreen.isDisplayed());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        WebElement greenLoaded = driver.findElement(By.id("finish_green"));
        assertTrue(!startGreenButton.isDisplayed() && !loadingGreen.isDisplayed() && greenLoaded.isDisplayed());
    }

    @Test
    public void loadGreenExplicitWait() throws Exception {
//         TODO:
//         * 1) click on start loading green button
        WebElement startGreenButton = driver.findElement(By.id("start_green"));
        startGreenButton.click();
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
        WebElement loadingGreen = driver.findElement(By.id("loading_green"));
        assertTrue(!startGreenButton.isDisplayed() && loadingGreen.isDisplayed());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish_green")));
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        WebElement greenLoaded = driver.findElement(By.id("finish_green"));
        assertTrue(!startGreenButton.isDisplayed() && !loadingGreen.isDisplayed() && greenLoaded.isDisplayed());
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start_green_and_blue")));
        WebElement greenBlue = driver.findElement(By.id("start_green_and_blue"));
        greenBlue.click();

        WebElement greenLoading = driver.findElement(By.id("loading_green_without_blue"));
        assertTrue(!greenBlue.isDisplayed() && greenLoading.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading_green_with_blue")));
        WebElement blueLoading = driver.findElement(By.id("loading_green_with_blue"));
        assertTrue(!greenBlue.isDisplayed() && greenLoading.isDisplayed() && blueLoading.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading_blue_without_green")));
        WebElement blueLoadingWithoutGreen = driver.findElement(By.id("loading_blue_without_green"));
        assertTrue(!greenBlue.isDisplayed() && !greenLoading.isDisplayed() && blueLoadingWithoutGreen.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish_green_and_blue")));
        WebElement finishText = driver.findElement(By.id("finish_green_and_blue"));
        assertTrue(!greenBlue.isDisplayed() && !greenLoading.isDisplayed() && !blueLoading.isDisplayed() && finishText.isDisplayed());





    }

}