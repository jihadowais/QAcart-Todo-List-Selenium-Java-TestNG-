package com.qacart.todo.testcases;

import com.qacart.todo.pages.TodoPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {
    @Test
    public void validateLoginWithValidCredentials() {
        TodoPage todoPage =
                loginPage.login("jihadowais@example.com", "12345Jo#");

        boolean isWelcomeMessageVisible =
                todoPage.isWelcomeMessageVisible();

        String currentURL = getBrowserActions().getCurrentUrl();
        String currentTitle = getBrowserActions().getPageTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("https://todo.qacart.com/todo", currentURL, "The login redirected to wrong page url!");
        softAssert.assertEquals("QAcart Todo App - Todos page", currentTitle, "Wrong page title!");
        softAssert.assertEquals(isWelcomeMessageVisible, true, "Welcome Message is not appearing!");
        softAssert.assertAll();
    }
}
