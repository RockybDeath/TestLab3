package test.lab.UnauthorizedClientTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.lab.BrowserConfigTest;

import java.util.ArrayList;

public class CarDetailsTest extends BrowserConfigTest{

    @Test
    public void AudiDetailsCheck(){
        mainPage.clickDetails();
        detailsOfCar.clickAudiDetails();
        detailsOfCar.clickRandomDetail();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        detailsOfCar.checkDetailForAudi();
    }

    @AfterAll
    public static void quit(){
        driver.quit();
    }

}
