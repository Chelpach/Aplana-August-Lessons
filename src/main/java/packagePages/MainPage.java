package packagePages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

/**
 * Created by user on 10.09.2017.
 */
public class MainPage extends BasePage {

    @FindBy(css = "span.region-list__name")
    public WebElement regionButton;

    @FindBy(xpath = "(//input[@value=''])[3]")
    WebElement searchForm;

    @FindBy(css = "span.region-search-box__option")
    public WebElement searcheableElement;

    @FindBy(xpath = "//*[@class='sbrf-div-list-inner --area bp-area footer-container']")
    public WebElement footer;

    @FindBy(xpath = "//*[@class='social__icon social__icon_type_fb']")
    public WebElement facebook;

    @FindBy(xpath = "//*[@class='social__icon social__icon_type_tw']")
    public WebElement twitter;

    @FindBy(xpath = "//*[@class='social__icon social__icon_type_yt']")
    public WebElement youTube;

    @FindBy(xpath = "//*[@class='social__icon social__icon_type_ins']")
    public WebElement instagram;

    @FindBy(xpath = "//*[@class='social__icon social__icon_type_vk']")
    public WebElement vk;

    @FindBy(xpath = "//*[@class='social__icon social__icon_type_ok']")
    public WebElement ok;

    @FindBy(css = ".kit-link.kit-link_pseudo.kit-link_color_black.alt-menu-collapser__link")
    public WebElement insureYourselfButton;

    @FindBy(css = ".kit-link.kit-link_color_black.alt-menu-list__link.alt-menu-list__link_level_1")
    public WebElement travelersInsuranceButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectRegionButton() {
        regionButton.click();
    }

    public void fillSearchForm(String region) {
        fillFormField(searchForm, region);
    }


}
