package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginLiveCom extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"i0116\"]")
    private WebElement emailField;
    @FindBy(xpath = "//*[@id=\"idSIButton9\"]")
    private WebElement nextButton;
    @FindBy(xpath = "//*[@id=\"i0118\"]")
    private WebElement passwdField;

    public LoginLiveCom(WebDriver driver) {
        super(driver);
    }

    public void clickNextButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    public void pullEmailField(String email){
        emailField.sendKeys(email);
    }

    public void pullPasswdField(String password){
        passwdField.sendKeys(password);
    }

}
