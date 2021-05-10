package test.lab;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.lab.PageObjects.*;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BrowserConfigTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static MainPage mainPage;
    public static RatingPage ratingPage;
    public static GamePage gamePage;
    public static ClanPage clanPage;
    public static MediaPage mediaPage;
    public static TournamentPage tournamentPage;
    public static CommunityPage communityPage;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        System.setProperty("webdriver.chrome.driver", "$WORKING_DIRECTORY/chromedriver.exe");
        mainPage = new MainPage(driver);
        ratingPage = new RatingPage(driver);
        gamePage = new GamePage(driver);
        clanPage = new ClanPage(driver);
        tournamentPage = new TournamentPage(driver);
        mediaPage = new MediaPage(driver);
        communityPage = new CommunityPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://auto.ru");
    }

}
