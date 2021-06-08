package test.lab.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.lab.BrowserConfigTest;

public class BuyCarPage extends BrowserConfigTest {

    public  WebDriver driver;

    private WebDriverWait wait;

    @FindBy(xpath = "//h1/span")
    private WebElement listingTitle;

    public BuyCarPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public String checkListeningTitle(){
        return listingTitle.getText();
    }
}
