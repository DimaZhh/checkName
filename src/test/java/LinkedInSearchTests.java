import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LinkedInHomePage;
import pages.LinkedInSearchPage;

import java.io.IOException;

public class LinkedInSearchTests extends BaseTest {

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][] {
                {"clarizenapi@gmail.com", "MadjikMadjik123"}
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void checkSearchFunctionality(String userName, String userPassword) throws IOException {

        logger.info("=======> Start 'checkSearchFunctionality' test");

        String searchText = "Selenium";

        Assert.assertTrue(linkedInLoginPage.isLinkedInLoginPageLoaded());

        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(userName, userPassword);

        Assert.assertTrue(linkedInHomePage.isLinkedInHomePageLoaded());

        LinkedInSearchPage linkedInSearchPage = linkedInHomePage.search(searchText);

        Assert.assertTrue(linkedInSearchPage.isLinkedInSearchPageLoaded(searchText));

        Assert.assertEquals(linkedInSearchPage.checkSearchTitles(searchText).size(), 3, "Wrong element count");

        logger.info("=======> End 'checkSearchFunctionality' test");
    }

}
