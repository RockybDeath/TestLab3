package test.lab;

import org.junit.jupiter.api.BeforeAll;

public class AuthorizationConfig extends BrowserConfigTest {

    @BeforeAll
    public static void authorization() {
        mainPage.clickLogin();
        BrowserConfigTest.loginPage.inputLogin("lexa200004@mail.ru");
        BrowserConfigTest.loginPage.inputPassword("AVU0707ovu");
        BrowserConfigTest.loginPage.clickSubmit();
    }
}
