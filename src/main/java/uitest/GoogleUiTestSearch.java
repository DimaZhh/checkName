package uitest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import uitest.utils.PropertyReader;

import java.io.IOException;

public class GoogleUiTestSearch {



    public static void main(String[] args) throws IOException {

        System.out.println("hell-ooo");

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(PropertyReader.getProperty("url"));


        WebElement googleSearchField = driver.findElement(By.xpath("//input[@title='Search']"));
        clickAndWriteText(googleSearchField, "Selenium");
        googleSearchField.sendKeys(Keys.ENTER);

        WebElement[] foundSearchResults = driver.findElements(By.xpath("//div[@id='rso']//div[@class='g']")).toArray(new WebElement[0]);
        System.out.println("Found following web elements count: " + foundSearchResults.length);

        if (foundSearchResults.length == 13) {
            System.out.println(">>>>>>>>>>>>>>>TEST PASSED!!!");
        } else {
            System.out.println(">>>>>>>>>>>>>>>TEST FAILED!!!");
        }

        for (WebElement element : foundSearchResults) {
            String elementText = element.getText();
            System.out.println(elementText);

            if (elementText.toLowerCase().contains("selenium")) {
                System.out.println(">>>>>>>>>>>>>>>Search result is positive");
            } else {
                System.out.println(">>>>>>>>>>>>>>>Search result is negative");
            }
        }

        driver.quit();
    }

    // This method blabalbla
    private static void clickAndWriteText(WebElement webElement, String text) {
        webElement.click();
        webElement.clear();
        webElement.sendKeys(text);
    }
}
