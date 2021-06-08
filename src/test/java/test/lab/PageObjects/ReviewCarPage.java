package test.lab.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class ReviewCarPage {

    public  WebDriver driver;

    private WebDriverWait wait;

    @FindBy(xpath="//div/button/span")
    private WebElement markOfCar;

    @FindBy(xpath="//div[2]/div[4]")
    private WebElement bmwMark;

    @FindBy(xpath = "//div[@class=\"ReviewSnippetDesktop__techParams\"]")
    private WebElement infoTech;

    @FindBy(xpath = "//a[@href=\"https://auto.ru/video/cars/bmw/\"]")
    private WebElement videoLink;

    @FindBy(xpath = "//div[@class=\"VideoThumb__title\"]")
    private WebElement nameOfVideo;

    public ReviewCarPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 6);
    }

    public void dropBoxMarksAndClickBMW(){
        markOfCar.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[4]")));
        bmwMark.click();
    }

    public String getInfo(){
        return infoTech.getText();
    }
    public void clickVideo(){
        videoLink.click();
    }

    public String getNameOfVideo(){
        return nameOfVideo.getText();
    }
}

