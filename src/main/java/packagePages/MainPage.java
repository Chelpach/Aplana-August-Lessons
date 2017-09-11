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

    @FindBy(xpath = "//span[contains(@class,'multiline')]/*[contains(text(),'Застраховать себя')]")
    public WebElement insureYourselfButton;

    @FindBy(xpath ="//a[@href='/portalserver/sb-portal-ru/ru/person/bank_inshure/insuranceprogram/life/travel']")
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
