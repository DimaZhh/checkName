package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.io.IOException;

public class LinkedInLoginPage extends BasePage {

    @FindBy(id = "session_key")
    private WebElement userEmailField;

    @FindBy(id = "session_password")
    private WebElement userPasswordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement enterButton;

    public LinkedInLoginPage(WebDriver driver, WebDriverWait waiter) {
        this.driverPage = driver;
        this.waiter = waiter;
        PageFactory.initElements(driverPage, this);
    }

    public <T> T login(String email, String password) {
        userEmailField.sendKeys(email);
        userPasswordField.sendKeys(password);
        enterButton.click();

        if (isUrlContains("/feed")) {
            return (T) new LinkedInHomePage(driverPage, waiter);
        }
        if (isUrlContains("/login-submit")) {
            return (T) new LinkedInLoginSubmitPage(driverPage, waiter);
        } else {
            return (T) this;
        }
    }

    public boolean isLinkedInLoginPageLoaded() throws IOException {
        return getCurrentUrl().equals(PropertyReader.getProperty("url")) &&
                getCurrentTitle().equals("LinkedIn: Log In or Sign Up");
    }

}
