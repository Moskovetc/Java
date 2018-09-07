import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginLiveCom;
import pages.OutlookLiveCom;
import pages.OutlookLiveComMail;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\workspace\\java\\geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        webDriver.navigate().to("https://outlook.live.com/");
        OutlookLiveCom outlookLiveCom = new OutlookLiveCom(webDriver);
        outlookLiveCom.clickSignInButton();
        LoginLiveCom loginLiveCom = new LoginLiveCom(webDriver);
        loginLiveCom.pullEmailField("test.for.dexsys@outlook.com");
        loginLiveCom.clickNextButton();
        loginLiveCom.pullPasswdField("Gentoo32");
        loginLiveCom.clickNextButton();
        OutlookLiveComMail outlookLiveComMail = new OutlookLiveComMail(webDriver);
        outlookLiveComMail.clickNewMessageButton();
        outlookLiveComMail.pullFieldToOfNewMessage("test.for.dexsys@outlook.com");
        outlookLiveComMail.pullFieldAddSubjectOfNewMessage("Test Message");
//        outlookLiveComMail.clickDotDotDotOfNewMessageButton();
//        outlookLiveComMail.clickSaveDraftButton();
        outlookLiveComMail.clickDraftMessagesButton();
        outlookLiveComMail.clickMyAccountButton();
        outlookLiveComMail.clickSignoutButton();
        webDriver.close();
    }
}
