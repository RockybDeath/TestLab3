package test.lab.AuthorizedClientTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import test.lab.AuthorizationConfig;
import test.lab.BrowserConfigTest;

public class PersonalAreaTest extends AuthorizationConfig {

    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setupPersonalArea(){
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @Test
    public void test(){
        profilePage.entryMenu();
        profilePage.goToPersonalArea();
        Assertions.assertEquals("A_V_U_1", profilePage.getNickname());
        Assertions.assertEquals("lexa200004@mail.ru", profilePage.getMail());
        profilePage.clickManageAccess();
        Assertions.assertEquals("https://ru.wargaming.net/personal/external_applications/edit/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
        profilePage.clickSubscribe();
        Assertions.assertEquals("https://ru.wargaming.net/personal/subscriptions/", driver.getCurrentUrl());
        Assertions.assertTrue(profilePage.getStatusCheckboxAccount());
        profilePage.setCheckboxAccount();
        Assertions.assertFalse(profilePage.getStatusCheckboxAccount());
        Assertions.assertTrue(profilePage.getStatusCheckboxEvents());
        profilePage.setCheckboxEvents();
        Assertions.assertFalse(profilePage.getStatusCheckboxEvents());
        profilePage.setCheckboxEvents();
        profilePage.setCheckboxAccount();
        javascriptExecutor.executeScript("window.history.go(-1)");
        profilePage.clickSecurityData();
        Assertions.assertEquals("https://ru.wargaming.net/personal/privacy/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
        profilePage.clickMyCards();
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://card.wargaming.net/cards"));
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void testChangePassword(){
        profilePage.clickPasswordEditorButton();
        profilePage.changePassword("AVU0707avu");
        profilePage.submitPassword();
        profilePage.clickFinishChange();
    }

    @Test
    public void testBonusCode(){
        profilePage.entryMenu();
        profilePage.clickBonusCode();
        driver.findElement(By.xpath("//span[contains(text(), \"Понятно!\")]")).click();
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://ru.wargaming.net/shop/redeem/"));
    }

    @AfterAll
    public static void quit() {
        BrowserConfigTest.profilePage.entryMenu();
        BrowserConfigTest.profilePage.clickLogout();
        BrowserConfigTest.driver.quit();
    }

}
