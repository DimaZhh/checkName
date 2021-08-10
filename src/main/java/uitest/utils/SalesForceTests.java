package uitest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SalesForceTests {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");


//        Map<String, Object> prefs = new HashMap<String, Object>();
//        prefs.put("profile.default_content_setting_values.notifications", 2);
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", prefs);

        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://redtag-c4-dev-ed.lightning.force.com/lightning/page/home");
//        Thread.sleep(1000); //for waiting

        //Login to the SF sandbox
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("marialv911@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Maria123456789");
        driver.findElement(By.xpath("//input[@id='Login']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement element= driver.findElement(By.xpath("//*[@title='Contacts']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath("//*[@title='New']//div")).click();
        //driver.findElement(By.xpath("//span[contains(text(),'Client')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
        driver.findElement(By.xpath("//*[@class='firstName compoundBorderBottom form-element__row input']")).sendKeys("Test");
        driver.findElement(By.xpath("//*[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys("test");
        driver.findElement(By.xpath("//*[@title='Save']/span")).click();



        driver.quit();

    }
}
