package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OutlookLiveCom extends AbstractPage {

    @FindBy(xpath = "//*/a[@class=\"linkButtonSigninHeader\"]")
    private WebElement signInButton;

    public OutlookLiveCom(WebDriver driver) {
        super(driver);
    }

    public void clickSignInButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

}
