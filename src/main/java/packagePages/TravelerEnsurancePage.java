package packagePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 10.09.2017.
 */
public class TravelerEnsurancePage extends BasePage{

    @FindBy(css = ".sbrf-rich-outer>h1")
    public WebElement title;

    @FindBy(css = ".sbrf-rich-outer>p>a>img")
    public WebElement banner;

    public TravelerEnsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
