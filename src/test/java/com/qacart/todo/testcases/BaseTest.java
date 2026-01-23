package com.qacart.todo.testcases;

import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.BrowserActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://todo.qacart.com/");
        loginPage = new LoginPage(driver);
        configureTimeouts();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

    public BrowserActions getBrowserActions() {
        return new BrowserActions(driver);
    }

    /**
     * This is a private method to configue the timeout throughout the whole project's tests.
     * To set the amount of time to wait for a page load to complete before it throws an error.
     */
    private void configureTimeouts() {
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // this is on the whole project
        // driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10)); // To set the amount of time to wait for ((asynchronous)) scripts to finish executing.
    }
}
