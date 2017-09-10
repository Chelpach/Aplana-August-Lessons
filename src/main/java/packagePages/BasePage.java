package packagePages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by user on 10.09.2017.
 */
public class BasePage {
    WebDriver driver;

    public void fillFormField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }



}
