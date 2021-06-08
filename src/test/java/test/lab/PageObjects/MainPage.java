package test.lab.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    public  WebDriver driver;

    private WebDriverWait wait;

    @FindBy(xpath ="//a[@href = \"https://auto.ru/reviews/\"]")
    private WebElement reviews;

    @FindBy(xpath ="//a[@href = \"https://parts.auto.ru/sankt-peterburg/\"]")
    private WebElement details;

    @FindBy(xpath = "//div[@class = \"Dropdown HeaderBurger\"]")
    private WebElement burger;

    @FindBy(xpath = "//a[@href = \"https://auto.ru/history/\"]")
    private WebElement history;

    @FindBy(xpath = "//div[3]/div[3]")
    private WebElement slider;

    @FindBy(xpath = "//div[2]/button/span/span")
    private WebElement showCarsByCost;

    @FindBy(xpath = "//div[4]/div[4]")
    private WebElement triggerMessage;

    @FindBy(xpath = "//div/span/div[2]/div/div[2]")
    private WebElement randomCar;

    @FindBy(xpath = "//div[2]/a")
    private WebElement mainLink;

    @FindBy(xpath = "//div[2]/div/div[3]")
    private WebElement lastAlreadySawCar;

    @FindBy(xpath = "//span/span")
    private WebElement loginButton;

    @FindBy(xpath = "//span[5]/a/span")
    private WebElement loginGoogle;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void hoverClickInfo(){
        burger.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href = \"https://auto.ru/history/\"]")));
        history.click();
        wait.until(ExpectedConditions.urlContains("https://auto.ru/history/"));
    }

    public void slideCost(){
        Actions action = new Actions(driver);
        action.dragAndDropBy(slider, -200, 0).build().perform();
    }

    public void showCars(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/button/span/span")));
        showCarsByCost.click();
    }

    public void clickRandomCar(){
        randomCar.click();
        wait.until(ExpectedConditions.urlContains("new/group"));
    }

    public void clickReviews(){
        burger.click();
        reviews.click();
    }

    public void goToMainPage(){
        mainLink.click();
        wait.until(ExpectedConditions.urlToBe("https://auto.ru/sankt-peterburg/"));
    }

    public void clickLastSawCar(){
        lastAlreadySawCar.click();
        wait.until(ExpectedConditions.urlContains("new/group"));
    }

    public void triggerSite(){
        triggerMessage.click();
    }
    public void clickLogin(){
        loginButton.click();
        loginGoogle.click();
    }
    public void clickDetails(){
        burger.click();
        details.click();
    }
}
