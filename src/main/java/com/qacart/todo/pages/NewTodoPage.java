package com.qacart.todo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTodoPage {
    WebDriver driver;

    By headerTxt = By.cssSelector("[data-testid=\"header\"]");
    By todoItem = By.cssSelector("[data-testid=\"new-todo\"]");
    By submitBtn = By.cssSelector("[data-testid=\"submit-newTask\"]");

    public NewTodoPage(WebDriver driver) { this.driver = driver; }

    public String getHeaderText() { return driver.findElement(headerTxt).getText(); }

    public TodoPage createNewTodo(String todoItem) {
        driver.findElement(this.todoItem).sendKeys(todoItem);
        driver.findElement(submitBtn).click();

        return new TodoPage(driver);
    }
}
