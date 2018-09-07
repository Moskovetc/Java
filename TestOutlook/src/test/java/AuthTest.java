import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AuthTest {
    private static WebDriver webDriver;

    @org.testng.annotations.BeforeClass
    public static void init(){
        System.setProperty("webdriver.gecko.driver", "C:\\workspace\\java\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        webDriver.navigate().to("https://outlook.live.com/");
    }

    private static void tryPullInField(String expression, String s){
        while (true) {
            try {
                WebElement webElement = webDriver.findElement(By.xpath(expression));
                webElement.clear();
                webElement.sendKeys(s);
                break;
            } catch (StaleElementReferenceException e) {}
        }
    }


    private static void tryClickButton(String expression){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
            while (true) {
                try {
                    WebElement webElement = webDriver.findElement(By.xpath(expression));
                    wait.until(ExpectedConditions.elementToBeClickable(webElement));
                    webElement.click();
                    break;
                } catch (StaleElementReferenceException e) {
                }
            }
    }

    private void loginUser(String email, String password){
        String xPathSignIn = "//*/a[@class=\"linkButtonSigninHeader\"]";
        String xPathEmailField = "//*[@id=\"i0116\"]";
        String xPathNextButton = "//*[@id=\"idSIButton9\"]";
        String xPathPasswdField = "//*[@id=\"i0118\"]";

        tryClickButton(xPathSignIn);

        tryPullInField(xPathEmailField, email);

        tryClickButton(xPathNextButton);

        tryPullInField(xPathPasswdField, password);

        tryClickButton(xPathNextButton);
    }

    private void createNewMessage(String to, String subject){
        String xPathNewMessage = "//*/button[@class=\"ms-Button ms-Button--action ms-Button--command _2sLGgsXQzNsTmOBmKdefiY root-50\"]";
        String xpathFieldToOfNewMessage = "//*/input[@class=\"vA7jkZHmqacvRUMCWPiB4\"]";
        String xPathFieldAddSubjectOfNewMessage = "//*[@id=\"subjectLine0\"]";

        tryClickButton(xPathNewMessage);

        tryPullInField(xpathFieldToOfNewMessage, to);

        tryPullInField(xPathFieldAddSubjectOfNewMessage, subject);

    }

    private void saveNewMessageToDrafts(){
        String xPathDotDotDotOfNewMessage = "//*/button[@class=\"ms-Button ms-Button--commandBar ms-CommandBar-overflowButton root-99\"]";
        String xPathSaveDraft = "//*/button[@name=\"Save draft\"]";
        tryClickButton(xPathDotDotDotOfNewMessage);

        tryClickButton(xPathSaveDraft);

    }

    private void draftMessages(){
        String xPathDraftMessages = "//*/div[@class=\"_1429Ddb-M-DRKHKbjzLCpJ W0uGMfBeBKdVW2bSmkfbw\"][@title=\"Drafts\"]";
        tryClickButton(xPathDraftMessages);
    }

    private void assertDraftmessage(){
        String xPathDraftMessage = "//*/div[@class=\"_2oS4t0YANyzQh_CKsUMMbR\"]/span[contains(text(), \"Test Message\")]";
        WebElement draftMessage = webDriver.findElement(By.xpath(xPathDraftMessage));
        String subject = draftMessage.getText();
        Assert.assertEquals("Test Message", subject);
    }

    private void signOut(){
        String xPathMyAccount = "//*/div[@class=\"ms-Persona-initials initials-96\"]/span[contains(text(), \"TT\")]";
        String xPathSignOutButton = "//*/div[@id=\"id__276\"]";
        tryClickButton(xPathMyAccount);
        tryClickButton(xPathSignOutButton);
    }

    @org.testng.annotations.Test
    public void testPostService(){
        String email = "test.for.dexsys@outlook.com";
        String password = "Gentoo32";

        loginUser(email, password);

        createNewMessage("test.for.dexsys@outlook.com", "Test Message");

//        saveNewMessageToDrafts();

        draftMessages();

        assertDraftmessage();

        signOut();

    }

    @AfterClass
    public static void quit(){
        webDriver.quit();
    }


}
