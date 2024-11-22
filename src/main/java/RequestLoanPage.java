import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RequestLoanPage extends BasePage {
    // LOCATORS
    private By loanAmount = By.id("amount");
    private By downPayment = By.id("downPayment");
    private By account = By.id("fromAccountId");
    private By applyNowButton = By.cssSelector("input[type='button'][value='Apply Now']");
    private By resultMessage = By.id("loanStatus");
    private By requestErrorMessage = By.cssSelector("#requestLoanError > h1");
    private By loanForm = By.id("requestLoanForm");

    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loanAmount(String Amount) {
        driver.findElement(loanAmount).sendKeys(Amount);
    }

    public void downPayment(String DownPayment) {
        driver.findElement(downPayment).sendKeys(DownPayment);
    }

    public void selectAccount(Integer AccountIndex) {
        Select accountSelect = new Select(driver.findElement(account));
        accountSelect.selectByIndex(AccountIndex);
    }

    public void applyNowButton() {
        driver.findElement(applyNowButton).click();
    }

    public boolean isRequestLoanFormVisible() {
        return driver.findElement(loanForm).isDisplayed();
    }

    public boolean isErrorMessageVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(requestErrorMessage));
        return errorMessage.isDisplayed();
    }

    public boolean isLoanRequestApproved() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loanResult = wait.until(ExpectedConditions.visibilityOfElementLocated(resultMessage));
        return loanResult.getText().equals("Approved");

    }
    public boolean isLoanRequestDenied() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loanResult = wait.until(ExpectedConditions.visibilityOfElementLocated(resultMessage));
        return loanResult.getText().equals("Denied");

    }


}
