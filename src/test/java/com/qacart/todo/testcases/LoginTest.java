package com.qacart.todo.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest {
    WebDriver driver;
    By email = By.id("email");
    By password = By.id("password");
    By submit = By.id("submit");
    By welcomeMsg = By.cssSelector("[data-testid=\"welcome\"]");

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://todo.qacart.com/login");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @Test
    public void validateLoginWithValidCredentials() {
        WebElement emailInput = driver.findElement(email);
        WebElement passwordInput = driver.findElement(password);
        WebElement submitButton = driver.findElement(submit);

        emailInput.sendKeys("jihadowais@example.com");
        passwordInput.sendKeys("12345Jo#");
        submitButton.click();

        driver.navigate().refresh();
        WebElement welcomeMessage = driver.findElement(welcomeMsg);
        String currentURL = driver.getCurrentUrl();
        String currentTitle = driver.getTitle();
        boolean isWelcomeMessageAppears = welcomeMessage.isDisplayed();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("https://todo.qacart.com/todo", currentURL, "The login redirected to wrong page url!");
        softAssert.assertEquals("QAcart Todo App - Todos page", currentTitle, "Wrong page title!");
        softAssert.assertEquals(isWelcomeMessageAppears, true, "Welcome Message is not appearing!");
        softAssert.assertAll();
    }
}
