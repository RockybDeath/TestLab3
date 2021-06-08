package test.lab.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.lab.BrowserConfigTest;

import java.util.List;

public class DetailsOfCar extends BrowserConfigTest {

    public  WebDriver driver;

    private WebDriverWait wait;

    @FindBy(xpath = "//h1")
    private WebElement infoPage;

    @FindBy(xpath="//a/span")
    private WebElement audiDetails;

    @FindBy(xpath="//div[4]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div/a")
    private WebElement randomDetail;

    public DetailsOfCar(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }
    public String getTextInfoPage(){
        return infoPage.getText();
    }
    public void clickAudiDetails(){
        audiDetails.click();
    }
    public void clickRandomDetail(){
        randomDetail.click();
    }
    public boolean checkDetailForAudi(){
        List<WebElement> list = driver.findElements(By.xpath("//a[@class=\"PartsLink PartsLink_color_black\"]"));
        for(WebElement element : list){
            System.out.println(element.getText());
            if(element.getText().contains("Audi")) return true;
        }
        return false;
    }

}

