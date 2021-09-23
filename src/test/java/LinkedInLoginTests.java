import org.testng.Assert;
import org.testng.annotations.*;
import pages.LinkedInHomePage;
import pages.LinkedInLoginSubmitPage;
import pages.LinkedInSearchPage;

import java.io.IOException;
import java.util.Map;

public class LinkedInLoginTests extends BaseTest {

    /**
     *
     * Generate valid DataProvider with 'userName' and 'userPassword'
     * (required for positive scenarios)
     * @return an Object with 'userName' and 'userPassword'
     *
     * */
    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][] {
                {"clarizenapi@gmail.com", "MadjikMadjik123"}
        };
    }

    /**
     *
     * Generate not valid DataProvider with 'userName' and 'userPassword'
     * (required for negative scenarios)
     * @return an Object with 'userName' and 'userPassword'
     *
     * */
    @DataProvider
    public Object[][] notValidDataProvider() {
        String randomString = generateRandomString(7, true, false);
        String randomEmail = ""+randomString+"@gmail.com";
        return new Object[][] {
                {randomEmail, "MadjikMadjik123"}
        };
    }

    /**
     *
     * Generate valid and not valid DataProviders with 'userName' and 'userPassword'
     * (required for positive and negative scenarios scenarios)
     * @return an Object with 'userName' and 'userPassword'
     *
     * */
    @DataProvider
    public Object[][] notValidAndValidDataProvider() {
        String randomString = generateRandomString(7, true, false);
        String randomEmail = ""+randomString+"@gmail.com";
        return new Object[][] {
                {Map.of(randomEmail, "MadjikMadjik123"),
                        Map.of("clarizenapi@gmail.com", "MadjikMadjik123")}
        };
    }

    /**
     *
     * Check successful login to LinkedIn account
     *
     * Preconditions:
     * - Open new browser;
     * - Navigate to linkedin.com
     *
     * Scenario:
     * - Verify that login page is loaded
     * - Insert 'userName'
     * - Insert 'userPassword'
     * - Click om "SignIn" button
     * - Verify LonkedInHomePage is returned and opened
     *
     * @param userName
     * @param userPassword
     * @throws IOException
     *
     * */
    @Test(dataProvider = "validDataProvider")
    public void checkLoginFunctionalityPositive(String userName, String userPassword) throws IOException {

        logger.info("=======> Start 'checkLoginFunctionalityPositive' test");

        Assert.assertTrue(linkedInLoginPage.isLinkedInLoginPageLoaded());

        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(userName, userPassword);

        Assert.assertTrue(linkedInHomePage.isLinkedInHomePageLoaded());

        logger.info("=======> End 'checkLoginFunctionalityPositive' test");
    }

    @Test(dataProvider = "validDataProvider")
    public void checkSearchFunctionalityPositive(String userName, String userPassword) throws IOException {

        logger.info("=======> Start 'checkSearchFunctionalityPositive' test");

        String searchText = "Selenium";

        Assert.assertTrue(linkedInLoginPage.isLinkedInLoginPageLoaded());

        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(userName, userPassword);

        Assert.assertTrue(linkedInHomePage.isLinkedInHomePageLoaded());

        LinkedInSearchPage linkedInSearchPage = linkedInHomePage.search(searchText);

        Assert.assertTrue(linkedInSearchPage.isLinkedInSearchPageLoaded(searchText));

        logger.info("=======> End 'checkSearchFunctionalityPositive' test");
    }

    @Test(dataProvider = "notValidDataProvider")
    public void checkLoginFunctionalityNegative(String userName, String userPassword) throws IOException {

        logger.info("=======> Start 'checkLoginFunctionalityNegative' test");

        Assert.assertTrue(linkedInLoginPage.isLinkedInLoginPageLoaded());

        LinkedInLoginSubmitPage linkedInLoginSubmitPage = linkedInLoginPage.login(userName,
                userPassword);

        Assert.assertTrue(linkedInLoginSubmitPage.isLinkedInLoginSubmitPageLoaded());

        Assert.assertEquals("Couldn’t find a LinkedIn account associated with this email. Please try again.",
                linkedInLoginSubmitPage.getErrorMessageForUserName());

        logger.info("=======> End 'checkLoginFunctionalityNegative' test");
    }

    @Test(dataProvider = "notValidAndValidDataProvider")
    public void checkLoginFunctionalityNegativeWithSuccessfulLogin(Map<String, String> notValidCredentials,
                                                                   Map<String, String> validCredentials) throws IOException {

        logger.info("=======> Start 'checkLoginFunctionalityNegativeWithSuccessfulLogin' test");

        Assert.assertTrue(linkedInLoginPage.isLinkedInLoginPageLoaded());

        String notValidKey = null;
        String notValidValue = null;
        for (Map.Entry<String, String> pair : notValidCredentials.entrySet()) {
            notValidKey = pair.getKey();
            notValidValue = pair.getValue();
        }

        LinkedInLoginSubmitPage linkedInLoginSubmitPage = linkedInLoginPage.login(notValidKey,
                notValidValue);

        Assert.assertTrue(linkedInLoginSubmitPage.isLinkedInLoginSubmitPageLoaded());

        Assert.assertEquals("Couldn’t find a LinkedIn account associated with this email. Please try again.",
                linkedInLoginSubmitPage.getErrorMessageForUserName());

        String validKey = null;
        String validValue = null;
        for (Map.Entry<String, String> pair : validCredentials.entrySet()) {
            validKey = pair.getKey();
            validValue = pair.getValue();
        }

        LinkedInHomePage linkedInHomePage = linkedInLoginSubmitPage.login(validKey, validValue);

        Assert.assertTrue(linkedInHomePage.isLinkedInHomePageLoaded());

        logger.info("=======> End 'checkLoginFunctionalityNegativeWithSuccessfulLogin' test");
    }
}
