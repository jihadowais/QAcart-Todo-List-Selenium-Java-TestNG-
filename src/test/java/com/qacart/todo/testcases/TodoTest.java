package com.qacart.todo.testcases;

import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TodoTest extends BaseTest {
    @Test
    public void validateAddNewTodo() {
        TodoPage todoPage =
                loginPage.login("jihadowais@example.com", "12345Jo#");

        NewTodoPage newTodoPage = todoPage.addNewTodo();
        String headerText = newTodoPage.getHeaderText();

        newTodoPage.createNewTodo("Todo Task 1");
        String todoText = todoPage.getLastInsertedTodo();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("CREATE A NEW TODO", headerText, "Header is not correct or not exist!");
        softAssert.assertEquals(todoText, "Todo Task 1");

        softAssert.assertAll();
    }
}
