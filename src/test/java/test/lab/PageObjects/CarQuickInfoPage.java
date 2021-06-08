package test.lab.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarQuickInfoPage {
    public WebDriver driver;

    private WebDriverWait wait;

    @FindBy(xpath = "//h1")
    private WebElement nameInfo;

    public CarQuickInfoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public String getNameCar(){
        return nameInfo.getText();
    }

}
