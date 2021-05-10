package test.lab.UnauthorizedClientTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import test.lab.BrowserConfigTest;

public class SectionRatingTest extends BrowserConfigTest {

    private static JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setupRating(){
        javascriptExecutor = (JavascriptExecutor) driver;
        mainPage.clickRating();
    }

    @Test
    public void testRatingAchievements() {
        ratingPage.clickRatingAchievements();
        Assertions.assertEquals("https://worldoftanks.ru/ru/ratings/achievements/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void testRatingVehicle(){
        ratingPage.clickRatingVehicle();
        Assertions.assertEquals("https://worldoftanks.ru/ru/ratings/vehicles/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-1)");
    }

    @Test
    public void testConnectionBetweenRatings() {
        ratingPage.clickRatingAchievements();
        ratingPage.moveToAnotherRating();
        Assertions.assertEquals("https://worldoftanks.ru/ru/ratings/vehicles/", driver.getCurrentUrl());
        ratingPage.moveToAnotherRating();
        Assertions.assertEquals("https://worldoftanks.ru/ru/ratings/achievements/", driver.getCurrentUrl());
        javascriptExecutor.executeScript("window.history.go(-2)");
    }

    @AfterAll
    public static void  quit() {
        driver.quit();
    }
}
