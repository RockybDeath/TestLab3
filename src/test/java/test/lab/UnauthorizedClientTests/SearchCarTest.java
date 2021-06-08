package test.lab.UnauthorizedClientTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.lab.BrowserConfigTest;

public class SearchCarTest extends BrowserConfigTest{

    @Test
    public void sliderCheck(){
        mainPage.slideCost();
        mainPage.showCars();
        Assertions.assertEquals("Купить автомобиль", buyCarPage.checkListeningTitle());
    }

    @Test
    public void lastCorrectCar(){
        mainPage.clickRandomCar();
        String name1 = carQuickInfoPage.getNameCar();
        mainPage.goToMainPage();
        mainPage.clickLastSawCar();
        Assertions.assertEquals(name1, carQuickInfoPage.getNameCar());
    }

    @Test
    public void lastInCorrectCar(){
        mainPage.clickRandomCar();
        String name1 = carQuickInfoPage.getNameCar();
        mainPage.goToMainPage();
        mainPage.clickRandomCar();
        mainPage.goToMainPage();
        mainPage.clickLastSawCar();
        Assertions.assertNotEquals(name1, carQuickInfoPage.getNameCar());
    }

    @AfterAll
    public static void quit(){
        driver.quit();
    }

}
