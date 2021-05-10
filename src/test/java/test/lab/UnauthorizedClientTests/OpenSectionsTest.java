package test.lab.UnauthorizedClientTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.lab.BrowserConfigTest;

public class OpenSectionsTest extends BrowserConfigTest {


    @Test
    public void openSections(){
        mainPage.clickRating();
        Assertions.assertEquals("https://worldoftanks.ru/ru/ratings/", driver.getCurrentUrl());
        Assertions.assertEquals("РЕЙТИНГИ", ratingPage.getTitle());
        ratingPage.clickLogo();
        mainPage.clickGame();
        Assertions.assertEquals("https://worldoftanks.ru/ru/game/", driver.getCurrentUrl());
        Assertions.assertEquals("ЛЕГЕНДАРНАЯ ТАНКОВАЯ ОНЛАЙН-ИГРА", gamePage.getTitle());
        gamePage.clickLogo();
        mainPage.clickClan();
        Assertions.assertEquals("https://worldoftanks.ru/ru/clanwars/?link_place=wotp_link_main-menu", driver.getCurrentUrl());
        Assertions.assertEquals("КЛАНЫ", clanPage.getTitle());
        clanPage.clickLogo();
        mainPage.clickTournament();
        Assertions.assertEquals("https://worldoftanks.ru/ru/tournaments/", driver.getCurrentUrl());
        Assertions.assertEquals("ТУРНИРЫ", tournamentPage.getTitle());
        tournamentPage.clickLogo();
        mainPage.clickMedia();
        Assertions.assertEquals("https://worldoftanks.ru/ru/media/", driver.getCurrentUrl());
        Assertions.assertEquals("Видео", mediaPage.getTitle());
        mediaPage.clickLogo();
        mainPage.clickCommunity();
        Assertions.assertEquals("https://worldoftanks.ru/ru/community/", driver.getCurrentUrl());
        communityPage.clickLogo();
    }


    @AfterAll
    public static void quit(){
        driver.quit();
    }

}
