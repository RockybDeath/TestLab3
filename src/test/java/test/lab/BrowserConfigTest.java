package test.lab;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.lab.PageObjects.*;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserConfigTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static MainPage mainPage;
    public static HistoryPage historyPage;
    public static CarInfoPage carInfoPage;
    public static BuyCarPage buyCarPage;
    public static ReviewCarPage reviewCarPage;
    public static CarQuickInfoPage carQuickInfoPage;
    public static DetailsOfCar detailsOfCar;

    @BeforeAll
    public static void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 30);
        System.setProperty("webdriver.chrome.driver", "$WORKING_DIRECTORY/chromedriver.exe");
        mainPage = new MainPage(driver);
        historyPage = new HistoryPage(driver);
        carInfoPage = new CarInfoPage(driver);
        buyCarPage = new BuyCarPage(driver);
        detailsOfCar = new DetailsOfCar(driver);
        reviewCarPage = new ReviewCarPage(driver);
        carQuickInfoPage = new CarQuickInfoPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://auto.ru");
    }

}
