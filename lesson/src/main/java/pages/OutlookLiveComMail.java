package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OutlookLiveComMail extends AbstractPage {

    @FindBy(xpath = "//*/button[@class=\"ms-Button ms-Button--action ms-Button--command _2sLGgsXQzNsTmOBmKdefiY root-50\"]")
    private WebElement newMessageButton;
    @FindBy(xpath = "//*/input[@class=\"vA7jkZHmqacvRUMCWPiB4\"]")
    private WebElement fieldToOfNewMessage;
    @FindBy(xpath = "//*[@id=\"subjectLine0\"]")
    private WebElement fieldAddSubjectOfNewMessage;
    @FindBy(xpath = "//*/button[@class=\"ms-Button ms-Button--commandBar ms-CommandBar-overflowButton root-99\"]")
    private WebElement dotDotDotOfNewMessageButton;
    @FindBy(xpath = "//*/button[@name=\"Save draft\"]")
    private WebElement saveDraftButton;
    @FindBy(xpath = "//*/div[@class=\"_1429Ddb-M-DRKHKbjzLCpJ W0uGMfBeBKdVW2bSmkfbw\"][@title=\"Drafts\"]")
    private WebElement draftMessagesButton;
    @FindBy(xpath = "//*/div[@class=\"ms-Persona-initials initials-96\"]/span[contains(text(), \"TT\")]")
    private WebElement myAccountButton;
    @FindBy(xpath = "//*/div[@id=\"id__276\"]")
    private WebElement signOutButton;

    public OutlookLiveComMail(WebDriver driver) {
        super(driver);
    }

    public void clickNewMessageButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(newMessageButton));
        newMessageButton.click();
    }

    public void pullFieldToOfNewMessage(String toEmail){
        fieldToOfNewMessage.clear();
        fieldToOfNewMessage.sendKeys(toEmail);
    }

    public void pullFieldAddSubjectOfNewMessage(String subject){
        fieldAddSubjectOfNewMessage.clear();
        fieldAddSubjectOfNewMessage.sendKeys(subject);
    }

    public void clickDotDotDotOfNewMessageButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(dotDotDotOfNewMessageButton));
        dotDotDotOfNewMessageButton.click();
    }

    public void clickSaveDraftButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(saveDraftButton));
        wait.until(ExpectedConditions.elementToBeClickable(saveDraftButton));
        saveDraftButton.click();
    }

    public void clickMyAccountButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();
    }

    public void clickSignoutButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(signOutButton));
        signOutButton.click();
    }

    public void clickDraftMessagesButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(draftMessagesButton));
        draftMessagesButton.click();
    }
}
