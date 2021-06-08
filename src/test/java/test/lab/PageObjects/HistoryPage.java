package test.lab.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HistoryPage {

    private WebDriver driver;

    private WebDriverWait wait;

    @FindBy(xpath = "//span/label/div/span/input")
    private WebElement vin;

    @FindBy(xpath = "//div[@class = \"VinCheckSnippetDesktop__error\"]")
    private WebElement vin_error;

    @FindBy(xpath = "//button[@class = \"Button Button_color_blue Button_size_promo Button_type_button Button_width_default Button_radius_r4 VinCheckInput__button_size-h64\"]")
    private WebElement vin_check;

    public HistoryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void inputVIN(String text){
        vin.sendKeys(text);
    }

    public void checkVin(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = \"Button Button_color_blue Button_size_promo Button_type_button Button_width_default Button_radius_r4 VinCheckInput__button_size-h64\"]")));
        vin_check.click();
//        wait.until(ExpectedConditions.urlContains("https://auto.ru/history/Z0NZWE00054341234/"));
    }

    public boolean visibleError(){
        return vin_error.isDisplayed();
    }
}
