package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driverPage;
    protected WebDriverWait waiter;

    protected String getCurrentUrl() {
        return driverPage.getCurrentUrl();
    }

    protected String getCurrentTitle() {
        return driverPage.getTitle();
    }

    public void assertElementIsVisible(WebElement element, String message) {
        try {
            waitUntilElementIsVisible(element);
        }catch (TimeoutException exception) {
            throw new AssertionError(message);
        }
    }

    public void assertElementIsClickable(WebElement element, String message) {
        try {
            waitUntilElementIsClickable(element);
        }catch (TimeoutException exception) {
            throw new AssertionError(message);
        }
    }

    public boolean isUrlContains(String urlPath) {
        try {
            return waiter.until(ExpectedConditions.urlContains(urlPath));
        }catch (TimeoutException exception) {
            System.out.println("Url doesn't contain required path");
            return false;
        }
    }

    private WebElement waitUntilElementIsVisible(WebElement element) {
        return waiter.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitUntilElementIsClickable(WebElement element) {
        return waiter.until(ExpectedConditions.elementToBeClickable(element));
    }

}
