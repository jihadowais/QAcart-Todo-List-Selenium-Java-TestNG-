package com.qacart.todo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TodoPage {
    WebDriver driver;

    By welcomeMsg = By.cssSelector("[data-testid=\"welcome\"]");
    By plusIconBtn = By.cssSelector("[data-testid=\"add\"]");
    By todoItem = By.cssSelector("[data-testid=\"todo-text\"]");

    public TodoPage(WebDriver driver) { this.driver = driver; }

    public boolean isWelcomeMessageVisible() {
        // avoid driver.findElement(welcomeMsg).isDisplayed() directly
        // because it throws exceptions when element is not exists
        // findElements return empty list instead of exceptions
        List<WebElement> elements = driver.findElements(welcomeMsg);
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    public NewTodoPage addNewTodo() {
        driver.findElement(plusIconBtn).click();
        return new NewTodoPage(driver);
    }

    public String getLastInsertedTodo() {
        List<WebElement> todos = driver.findElements(todoItem);

        if (todos.isEmpty())
            return " ";
        else
            return todos.get(0).getText();
    }
}
