package com.qacart.todo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By email = By.id("email");
    By password = By.id("password");
    By submit = By.id("submit");

    public LoginPage(WebDriver driver) { this.driver = driver; }

    private void setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    private void setPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public TodoPage login(String email, String password) {
        setEmail(email);
        setPassword(password);
        driver.findElement(submit).click();

        return new TodoPage(driver);
    }
}
