package test.lab.UnauthorizedClientTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.lab.BrowserConfigTest;

import java.util.concurrent.TimeUnit;

public class CarPeopleSayTest extends BrowserConfigTest{

    @Test
    public void sayAboutBMW(){
        mainPage.triggerSite();
        mainPage.clickReviews();
        reviewCarPage.dropBoxMarksAndClickBMW();
        Assertions.assertTrue(reviewCarPage.getInfo().contains("BMW"));
    }

    @Test
    public void videoAboutBMW(){
        mainPage.triggerSite();
        mainPage.clickReviews();
        reviewCarPage.dropBoxMarksAndClickBMW();
        reviewCarPage.clickVideo();
        Assertions.assertTrue(reviewCarPage.getNameOfVideo().contains("BMW"));
    }

    @AfterAll
    public static void quit(){
        driver.quit();
    }

}