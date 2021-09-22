package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedInLoginSubmitPage extends BasePage {

    private String linkedInLoginSubmitPageUrl = "https://www.linkedin.com/uas/login-submit";

    @FindBy(id = "username")
    private WebElement userEmailField;

    @FindBy(id = "password")
    private WebElement userPasswordField;

    @FindBy(xpath = "//button[@data-litms-control-urn='login-submit']")
    private WebElement enterButton;

    @FindBy(id = "error-for-username")
    private WebElement errorForUserName;

    public LinkedInLoginSubmitPage(WebDriver driver, WebDriverWait waiter) {
        this.driverPage = driver;
        this.waiter = waiter;
        PageFactory.initElements(driverPage, this);
    }

    public String getErrorMessageForUserName() {
        return errorForUserName.getText();
    }

    public LinkedInHomePage login(String userEmail, String userPassword) {
        userEmailField.clear();
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        enterButton.click();
        return new LinkedInHomePage(driverPage, waiter);
    }

    public boolean isLinkedInLoginSubmitPageLoaded() {
        return getCurrentUrl().contains(linkedInLoginSubmitPageUrl) &&
                getCurrentTitle().equals("LinkedIn Login, Sign in | LinkedIn");
    }
}
