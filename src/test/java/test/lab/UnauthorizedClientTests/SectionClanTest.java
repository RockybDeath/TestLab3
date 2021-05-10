package test.lab.UnauthorizedClientTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.lab.BrowserConfigTest;

public class SectionClanTest extends BrowserConfigTest {

    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setupSectionClan() {
        mainPage.clickClan();
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @Test
    public void test(){
        String window = driver.getWindowHandle();
        clanPage.clickFindClan();
        wait.until(webDriver -> (javascriptExecutor.executeScript("return document.readyState").equals("complete")));
        Assertions.assertEquals("https://worldoftanks.ru/ru/clanwars/?link_place=wotp_link_main-menu", driver.getCurrentUrl());
        driver.switchTo().window(window);
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }
}
