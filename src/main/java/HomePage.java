import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {
    // LOCATORS
    private By requestLoanButton = By.linkText("Request Loan");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRequestLoanButton() {
        driver.findElement(requestLoanButton).click();
    }

    public boolean isDashboardVisible() {
        return driver.findElement(By.id("leftPanel")).isDisplayed();
    }
}
