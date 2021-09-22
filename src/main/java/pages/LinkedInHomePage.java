package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedInHomePage extends BasePage{

    private String linkedInHomePageUrl = "https://www.linkedin.com/feed/?trk=homepage-basic_signin-form_submit";

    @FindBy(xpath = "//div[@id='global-nav-typeahead']//input")
    private WebElement searchField;

    public LinkedInHomePage(WebDriver driver, WebDriverWait waiter) {
        this.driverPage = driver;
        this.waiter = waiter;
        PageFactory.initElements(driverPage, this);
    }

    public LinkedInSearchPage search(String textToBeSearched) {
        searchField.click();
        searchField.sendKeys(textToBeSearched);
        searchField.sendKeys(Keys.ENTER);
        return new LinkedInSearchPage(driverPage, waiter);
    }

    public boolean isLinkedInHomePageLoaded() {
        return getCurrentUrl().equals(linkedInHomePageUrl) &&
                getCurrentTitle().contains("Лента | LinkedIn");
    }
}
