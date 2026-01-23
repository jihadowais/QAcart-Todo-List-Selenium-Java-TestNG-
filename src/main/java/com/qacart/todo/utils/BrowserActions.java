package com.qacart.todo.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class BrowserActions {
    WebDriver driver;

    public BrowserActions(WebDriver driver) { this.driver = driver; }

    public void navigate(String url) { driver.navigate().to(url); }

    public void navigateBack() { driver.navigate().back(); }

    public void navigateForward() { driver.navigate().forward(); }

    public void refresh() { driver.navigate().refresh(); }

    public void maximize() { driver.manage().window().maximize(); }

    public void minimize() { driver.manage().window().maximize(); }

    private void setSize(int width, int height) { driver.manage().window().setSize(new Dimension(width, height)); }

    public void iPhoneSizeActivation() { setSize(390, 844); }

    public void iPadSizeActivation() { setSize(1366, 1024); }

    public String getCurrentUrl() { return driver.getCurrentUrl(); }

    public String getPageTitle() { return driver .getTitle(); }

    public void printSiteInfo() {
        System.out.println("Current URL: " + getCurrentUrl());
        System.out.println("Page Title: " + getPageTitle());
    }

    public String getWindowHandle() {
        System.out.println(driver.getWindowHandle());
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        System.out.println(driver.getWindowHandles());
        return driver.getWindowHandles();
    }

    private void openNewTab() { driver.switchTo().newWindow(WindowType.TAB); }

    private void openNewWindow() { driver.switchTo().newWindow(WindowType.WINDOW); }

}
