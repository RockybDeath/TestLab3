package test.lab.UnauthorizedClientTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.lab.BrowserConfigTest;

public class CarsTest extends BrowserConfigTest{

    @Test
    public void historyWrongCheck(){
        mainPage.hoverClickInfo();
        historyPage.inputVIN("dwdw");
        historyPage.checkVin();
        Assertions.assertEquals("https://auto.ru/history/", driver.getCurrentUrl());
        Assertions.assertTrue(historyPage.visibleError());
    }

    @Test
    public void historyRightCheck(){
        mainPage.hoverClickInfo();
        historyPage.inputVIN("Z0NZWE00054341234");
        historyPage.checkVin();
        Assertions.assertEquals("https://auto.ru/history/Z0NZWE00054341234/", driver.getCurrentUrl());
        Assertions.assertEquals("Марка и модель", carInfoPage.checkMarkText());
        Assertions.assertEquals("Транспортный налог", carInfoPage.checkTransportText());
        Assertions.assertEquals("Оценка стоимости", carInfoPage.checkCostText());
    }

    @AfterAll
    public static void quit(){
        driver.quit();
    }
}
