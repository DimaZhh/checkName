import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.LinkedInLoginPage;
import utils.PropertyReader;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

public class BaseTest {

    private static final int secondsToWait = 10;
    private WebDriver driver;
    protected LinkedInLoginPage linkedInLoginPage;
    protected static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    @Parameters("browserName")
    @BeforeMethod(alwaysRun = true)
    public void initBrowser(@Optional("Chrome") String browserName) throws IOException {

        logger.info("Start init browser");

        switch (browserName) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                break;
            case "FireFox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                break;
        }

        logger.info("Finish init browser");

        driver.get(PropertyReader.getProperty("url"));
        linkedInLoginPage = new LinkedInLoginPage(driver, new WebDriverWait(driver, secondsToWait));
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(ITestResult result) throws IOException {

        if (!result.isSuccess()) {
            Date date = new Date(result.getStartMillis());
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("./screenshots/"+result.getName() + date +".png"));
        }

        driver.quit();
    }

    public String generateRandomString(int length, boolean useLetters, boolean useNumbers) {
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
