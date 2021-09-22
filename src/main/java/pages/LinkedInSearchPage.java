package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class LinkedInSearchPage extends BasePage{

    @FindBy(className = "search-results-container")
    private WebElement searchResultList;

    @FindBy(xpath = "//*[@class='t-roman t-sans']")
    private List<WebElement> searchTitlesWebElement;

    private String linkedInSearchPageUrl = "https://www.linkedin.com/search/results/all/?keywords=";

    public LinkedInSearchPage(WebDriver driver, WebDriverWait waiter) {
        this.driverPage = driver;
        this.waiter = waiter;
        PageFactory.initElements(driverPage, this);
    }

    public List<WebElement> checkSearchTitles(String founds) {
        return searchTitlesWebElement
                .stream()
                .filter(e -> e.getText().contains(founds))
                .collect(Collectors.toList());
    }

    public boolean isLinkedInSearchPageLoaded(String searchCriteria) {
        final char dm = (char) 34;
        assertElementIsVisible(searchResultList, "'searchResultList' was not found");
        return getCurrentUrl().contains(linkedInSearchPageUrl) &&
                getCurrentTitle().contains(" "+dm+""+searchCriteria+""+dm+" | Поиск | LinkedIn");
    }
}
