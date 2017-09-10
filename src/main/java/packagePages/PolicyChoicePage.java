package packagePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 10.09.2017.
 */
public class PolicyChoicePage extends BasePage {

    @FindBy(css = ".b-form-prog-box")
    public WebElement minimalPolicy;

    @FindBy(xpath = "//span[@ng-click='save()']")
    public WebElement SubmitButton;

    public PolicyChoicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
