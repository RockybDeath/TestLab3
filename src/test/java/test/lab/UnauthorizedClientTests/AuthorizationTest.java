package test.lab.UnauthorizedClientTests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import test.lab.BrowserConfigTest;

public class AuthorizationTest extends BrowserConfigTest {

    @Test
    public void testLogin(){
//        mainPage.clickLogin();
        BrowserConfigTest.loginPage.inputLogin("Abysstur");
        BrowserConfigTest.loginPage.inputPassword("qweasw123");
        BrowserConfigTest.loginPage.clickRobot();
//        BrowserConfigTest.loginPage.clickSubmit();
//        String user = BrowserConfigTest.profilePage.getUsername();
//        Assertions.assertEquals("A_V_U_1", user);
//        BrowserConfigTest.profilePage.entryMenu();
//        BrowserConfigTest.profilePage.clickLogout();
    }

    @Test
    public void testFailedLogin(){
        mainPage.clickLogin();
        loginPage.inputLogin("lexa200004@mail.ru");
        loginPage.inputPassword("error");
        loginPage.clickSubmit();
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://ru.wargaming.net/id/signin/"));
        ((JavascriptExecutor) driver).executeScript("window.history.go(-1)");
    }

    @AfterAll
    public static void quit(){
        BrowserConfigTest.driver.quit();
    }
}
