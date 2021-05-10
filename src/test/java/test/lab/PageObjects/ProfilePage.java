package test.lab.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private WebDriver driver;

    @FindBy(xpath = "//span[@class=\"cm-user-menu-link_cutted-text\"]")
    private WebElement usernameField;

    @FindBy(xpath = "//h2[@class=\"b-heading2 b-heading2__noindent\"]")
    private WebElement nicknameField;

    @FindBy(xpath = "//a[@class=\"cm-user-menu-link js-cm-dropdown-link js-cm-event js-cm-user-menu-link\"]")
    private WebElement linkToCabinet;

    @FindBy(xpath = "//a[@class=\"cm-singletons\"]")
    private WebElement linkToPersonalArea;

    @FindBy(xpath = "//a[@class=\"cm-footer-logout_link js-cm-event js-cm-link-ignore-target\"]")
    private WebElement logout;

    @FindBy(xpath = "//p[@class=\"personal-info-list_value\"]")
    private WebElement mail;

    @FindBy(xpath = "//a[@class=\"b-personal-block_external-applications-link\"]")
    private WebElement manageAccess;

    @FindBy(xpath = "//div[@class=\"l-personal-button\"]/a")
    private WebElement subscribeLink;

    @FindBy(xpath = "//input[@value=\"wg_account\"]")
    private WebElement checkboxAccount;

    @FindBy(xpath = "//input[@value=\"online_events\"]")
    private WebElement checkboxEvents;

    @FindBy(xpath = "//a[@class=\"b-link\" and @data-at-role=\"manage\"]")
    private WebElement securityData;

    @FindBy(xpath = "//a[@data-at-role=\"mycards\"]")
    private WebElement myCards;

    @FindBy(xpath = "//span[contains(text(), \"Активировать код Wargaming\")]")
    private WebElement linkToBonusCode;

    @FindBy(xpath = "//a[@class=\"personal-info-list_ico personal-info-list_ico__edit\"]")
    private WebElement passwordEditorButton;

    @FindBy(xpath = "//input[@data-at-role=\"input-password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@data-at-role=\"input-password-repeat\"]")
    private WebElement passwordRepeatInput;

    @FindBy(xpath = "//button[contains(text(), \"Изменить\")]")
    private WebElement passwordSubmit;

    @FindBy(xpath = "//button[contains(text(), \"Закрыть\")]")
    private WebElement finishChanges;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getUsername(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"common_menu\"]/div/div[1]/div[1]/a[2]/span[3]")));
        return usernameField.getText();
    }

    public String getNickname() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class=\"b-heading2 b-heading2__noindent\"]")));
        return nicknameField.getText();
    }

    public void entryMenu(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"cm-user-menu-link js-cm-dropdown-link js-cm-event js-cm-user-menu-link\"]")));
        driver.findElement(By.xpath("//a[@class=\"cm-user-menu-link js-cm-dropdown-link js-cm-event js-cm-user-menu-link\"]")).click();
    }

    public void goToPersonalArea() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"cm-singletons\"]")));
        linkToPersonalArea.click();
    }

    public String getMail() {
        return mail.getText();
    }

    public void clickLogout(){
        logout.click();
    }

    public void clickManageAccess(){
        manageAccess.click();
    }

    public void clickSubscribe(){
        subscribeLink.click();
    }
    
    public void setCheckboxAccount(){
        checkboxAccount.click();
    }
    
    public void setCheckboxEvents(){
        checkboxEvents.click();
    }

    public boolean getStatusCheckboxAccount(){
        return checkboxAccount.isSelected();
    }

    public boolean getStatusCheckboxEvents(){
        return checkboxEvents.isSelected();
    }

    public void clickSecurityData() {
        securityData.click();
    }

    public void clickMyCards() {
        myCards.click();
    }

    public void clickBonusCode() {
        linkToBonusCode.click();
    }

    public void clickPasswordEditorButton(){
        passwordEditorButton.click();
    }

    public void changePassword(String password) {
        passwordInput.sendKeys(password);
        passwordRepeatInput.sendKeys(password);
    }

    public void submitPassword() {
        passwordSubmit.click();
    }

    public void clickFinishChange(){
        finishChanges.click();
    }

}
