import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    // LOCATORS
    private By userName = By.name("username");
    private By password = By.name("password");
    private By logInButton = By.cssSelector("input[type='submit'][value='Log In']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        driver.findElement(userName).sendKeys(USERNAME);
        driver.findElement(password).sendKeys(PASSWORD);
        driver.findElement(logInButton).click();
    }

    public boolean isLoginVisible() {
        return driver.findElement(userName).isDisplayed() && driver.findElement(password).isDisplayed();
    }
}
