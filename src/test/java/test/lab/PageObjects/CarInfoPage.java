package test.lab.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CarInfoPage {

    public  WebDriver driver;

    private WebDriverWait wait;

    @FindBy(xpath = "//div[2]/div[2]/div[2]/div/div")
    private WebElement markaInfo;

    @FindBy(xpath = "//div[18]/div/div/div")
    private WebElement transportInfo;

    @FindBy(xpath = "//div[16]/div/div/div")
    private WebElement costInfo;

    public CarInfoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public String checkMarkText(){
        return markaInfo.getText();
    }

    public String checkTransportText(){
        return transportInfo.getText();
    }

    public String checkCostText(){
        return costInfo.getText();
    }
}
