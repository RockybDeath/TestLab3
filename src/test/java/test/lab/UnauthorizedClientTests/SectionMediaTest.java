package test.lab.UnauthorizedClientTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.lab.BrowserConfigTest;

import java.util.ArrayList;
import java.util.List;

public class SectionMediaTest extends BrowserConfigTest {

    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setupMedia(){
        javascriptExecutor = (JavascriptExecutor) driver;
        mainPage.clickMedia();
    }

    @Test
    public void openVideo(){
        mediaPage.clickVideo();
        wait.until(webDriver -> (javascriptExecutor.executeScript("return document.readyState").equals("complete")));
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/media/9/"));
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openArt(){
        mediaPage.clickArt();
        wait.until(webDriver -> (javascriptExecutor.executeScript("return document.readyState").equals("complete")));
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/media/1/"));
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openModel() {
        mediaPage.clickModel();
        wait.until(webDriver -> (javascriptExecutor.executeScript("return document.readyState").equals("complete")));
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/media/10"));
        String window = driver.getWindowHandle();
        mediaPage.clickLink();
        wait.until(webDriver -> (javascriptExecutor.executeScript("return document.readyState").equals("complete")));
        driver.switchTo().window(window);
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openComic(){
        mediaPage.clickComic();
        wait.until(webDriver -> (javascriptExecutor.executeScript("return document.readyState").equals("complete")));
        Assertions.assertTrue(driver.getCurrentUrl().startsWith("https://worldoftanks.ru/ru/media/12"));
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @AfterAll
    public static void  quit() {
        driver.quit();
    }
}
