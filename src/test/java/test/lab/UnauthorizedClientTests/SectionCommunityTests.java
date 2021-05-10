package test.lab.UnauthorizedClientTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.lab.BrowserConfigTest;

public class SectionCommunityTests extends BrowserConfigTest {

    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setupCommunity(){
        javascriptExecutor = (JavascriptExecutor) driver;
        mainPage.clickCommunity();
    }


    @Test
    public void openForum(){
        communityPage.clickForum();
        Assertions.assertTrue( driver.getCurrentUrl().startsWith("http://forum.worldoftanks.ru/"));
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openYouTube(){
        mainPage.clickCommunity();
        communityPage.clickYouTube();
        wait.until(ExpectedConditions.urlMatches("https://www.youtube.com/channel/UCVnah-S-sByndtg9cHBxlOA"));
        Assertions.assertEquals("https://www.youtube.com/channel/UCVnah-S-sByndtg9cHBxlOA", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openDiscord(){
        mainPage.clickCommunity();
        communityPage.clickDiscord();
        wait.until(ExpectedConditions.urlMatches("https://discord.com/invite/wotcis"));
        Assertions.assertEquals("https://discord.com/invite/wotcis", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void openSmallTopics(){
        communityPage.clickFunSuite();
        wait.until(ExpectedConditions.urlMatches("https://worldoftanks.ru/ru/soft/fan-pages/"));
        Assertions.assertEquals("https://worldoftanks.ru/ru/soft/fan-pages/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
        communityPage.clickWarspot();
        wait.until(ExpectedConditions.urlMatches("https://warspot.ru/"));
        Assertions.assertEquals("https://warspot.ru/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
        communityPage.clickModes();
        wait.until(ExpectedConditions.urlMatches("https://wgmods.net/"));
        Assertions.assertEquals("https://wgmods.net/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
        communityPage.clickWiki();
        wait.until(ExpectedConditions.urlMatches("https://wiki.wargaming.net/ru/Tank:World_of_Tanks"));
        Assertions.assertEquals("https://wiki.wargaming.net/ru/Tank:World_of_Tanks", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
        communityPage.clickFM();
        wait.until(ExpectedConditions.urlMatches("https://wargaming.fm/"));
        Assertions.assertEquals("https://wargaming.fm/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
        communityPage.clickReplay();
        wait.until(ExpectedConditions.urlMatches("http://wotreplays.ru/"));
        Assertions.assertEquals("http://wotreplays.ru/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");


    }



    @AfterAll
    public static void quit() {
        driver.quit();
    }
}
