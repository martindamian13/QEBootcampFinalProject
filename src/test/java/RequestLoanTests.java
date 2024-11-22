import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RequestLoanTests extends BaseTest {

    @Test
    public void validateFieldsInRequestLoanForm() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        LoginPage loginPage = new LoginPage(driver);
        // Check if Login is displayed successfully.
        Assertions.assertTrue(loginPage.isLoginVisible(), "Login page is not visible");
        loginPage.login();
        HomePage homePage = new HomePage(driver);
        // Check if Dashboard is displayed, indicating a successful login.
        Assertions.assertTrue(homePage.isDashboardVisible(), "Dashboard is not visible after login");
        homePage.clickRequestLoanButton();
        RequestLoanPage requestLoanPage = new RequestLoanPage(driver);
        // Check if the loan application form is displayed correctly.
        Assertions.assertTrue(requestLoanPage.isRequestLoanFormVisible(), "Request Loan Form is not visible");
        requestLoanPage.loanAmount("");
        requestLoanPage.downPayment("");
        requestLoanPage.selectAccount(0);
        requestLoanPage.applyNowButton();
        // Check if an error message is displayed.
        Assertions.assertTrue(requestLoanPage.isErrorMessageVisible(), "Error message is not displayed when form is submitted empty");
    }

    @Test
    public void validateSuccesfullLoanApplication() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        LoginPage loginPage = new LoginPage(driver);
        // Check if Login is displayed successfully.
        Assertions.assertTrue(loginPage.isLoginVisible(), "Login page is not visible");
        loginPage.login();
        HomePage homePage = new HomePage(driver);
        // Check if Dashboard is displayed, indicating a successful login.
        Assertions.assertTrue(homePage.isDashboardVisible(), "Dashboard is not visible after login");
        homePage.clickRequestLoanButton();
        RequestLoanPage requestLoanPage = new RequestLoanPage(driver);
        // Check if the loan application form is displayed correctly.
        Assertions.assertTrue(requestLoanPage.isRequestLoanFormVisible(), "Request Loan Form is not visible");
        requestLoanPage.loanAmount("1000");
        requestLoanPage.downPayment("200");
        requestLoanPage.selectAccount(0);
        requestLoanPage.applyNowButton();
        // Check if the Loan Request is Approved.
        Assertions.assertTrue(requestLoanPage.isLoanRequestApproved(), "Loan request was not approved");
    }

    @Test
    public void validateRejectionWhenExceedsAllowance() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        LoginPage loginPage = new LoginPage(driver);
        // Check if Login is displayed successfully.
        Assertions.assertTrue(loginPage.isLoginVisible(), "Login page is not visible");
        loginPage.login();
        HomePage homePage = new HomePage(driver);
        // Check if Dashboard is displayed, indicating a successful login.
        Assertions.assertTrue(homePage.isDashboardVisible(), "Dashboard is not visible after login");
        homePage.clickRequestLoanButton();
        RequestLoanPage requestLoanPage = new RequestLoanPage(driver);
        // Check if the loan application form is displayed correctly.
        Assertions.assertTrue(requestLoanPage.isRequestLoanFormVisible(), "Request Loan Form is not visible");
        requestLoanPage.loanAmount("100000");
        requestLoanPage.downPayment("20000");
        requestLoanPage.selectAccount(0);
        requestLoanPage.applyNowButton();
        // Check if the Loan Request is Approved.
        Assertions.assertTrue(requestLoanPage.isLoanRequestDenied(), "Loan request was not denied");
    }

}
