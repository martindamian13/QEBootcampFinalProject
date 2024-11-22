import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerNewUser();

        driver.quit();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
