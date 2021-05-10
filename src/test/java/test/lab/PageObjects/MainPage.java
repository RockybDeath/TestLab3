package test.lab.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {


    private WebDriver driver;

    private WebDriverWait wait;

    @FindBy(xpath = "//a[@class=\"Button Button_color_gray Button_size_l Button_type_link Button_width_default Button_radius_r8 HeaderUserMenu__loginButton\"]")
    private WebElement login;

    @FindBy(xpath = "//a[contains(text(), \"Рейтинги\")]")
    private WebElement sectionRating;

    @FindBy(xpath = "//a[contains(text(), \"ИГРА\")]")
    private WebElement sectionGame;

    @FindBy(xpath = "//a[contains(text(), \"Кланы\")]")
    private WebElement sectionClan;

    @FindBy(xpath = "//a[contains(text(), \"\n" +
            "                            \n" +
            "                                Турниры\n" +
            "                            \n" +
            "                        \")]")
    private WebElement sectionTournament;

    @FindBy(xpath = "//a[contains(text(), \"Медиа\")]")
    private WebElement sectionMedia;

    @FindBy(xpath = "//a[contains(text(), \"СООБЩЕСТВО\")]")
    private WebElement sectionCommunity;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void clickRating(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), \"Рейтинги\")]")));
        sectionRating.click();
    }

    public void clickGame(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), \"ИГРА\")]")));
        sectionGame.click();
    }

    public void clickClan(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), \"Кланы\")]")));
        sectionClan.click();
    }

    public void clickTournament() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), \"\n" +
                "                            \n" +
                "                                Турниры\n" +
                "                            \n" +
                "                        \")]")));
        sectionTournament.click();
    }

    public void clickMedia() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), \"Медиа\")]")));
        sectionMedia.click();
    }

    public void clickCommunity() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), \"СООБЩЕСТВО\")]")));
        sectionCommunity.click();
    }

    public void clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"Button Button_color_gray Button_size_l Button_type_link Button_width_default Button_radius_r8 HeaderUserMenu__loginButton\"]")));
        login.click();
    }

}
