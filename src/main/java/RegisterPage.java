import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    // LOCATORS
    private By firstNameLocator = By.id("customer.firstName");
    private By lastNameLocator = By.id("customer.lastName");
    private By addressLocator = By.id("customer.address.street");
    private By cityLocator = By.id("customer.address.city");
    private By stateLocator = By.id("customer.address.state");
    private By zipCodeLocator = By.id("customer.address.zipCode");
    private By phoneNumberLocator = By.id("customer.phoneNumber");
    private By ssnLocator = By.id("customer.ssn");
    private By usernameLocator = By.id("customer.username");
    private By passwordLocator = By.id("customer.password");
    private By confirmPasswordLocator = By.id("repeatedPassword");
    private By registerButtonLocator = By.cssSelector("input[type='submit'][value='Register']");



    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerNewUser() {
        driver.findElement(firstNameLocator).sendKeys(FIRST_NAME);
        driver.findElement(lastNameLocator).sendKeys(LAST_NAME);
        driver.findElement(addressLocator).sendKeys(ADDRESS);
        driver.findElement(cityLocator).sendKeys(CITY);
        driver.findElement(stateLocator).sendKeys(STATE);
        driver.findElement(zipCodeLocator).sendKeys(ZIP_CODE);
        driver.findElement(phoneNumberLocator).sendKeys(PHONE_NUMBER);
        driver.findElement(ssnLocator).sendKeys(SSN);
        driver.findElement(usernameLocator).sendKeys(USERNAME);
        driver.findElement(passwordLocator).sendKeys(PASSWORD);
        driver.findElement(confirmPasswordLocator).sendKeys(PASSWORD);
        driver.findElement(registerButtonLocator).click();
    }
}
