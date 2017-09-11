import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import packagePages.FormPage;
import packagePages.MainPage;
import packagePages.PolicyChoicePage;
import packagePages.TravelerEnsurancePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RefactoredTest extends BaseTest {
    @Test
    public void testScenario1() throws Exception {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        mainPage.selectRegionButton();
        mainPage.fillSearchForm("Нижегородская область");
        mainPage.searcheableElement.click();
        checkFillFieldByText("Нижегородская область", mainPage.regionButton);
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(mainPage.footer));
        scrollToElement(mainPage.footer);
        Thread.sleep(2000);
        checkElementDisplayed(mainPage.facebook);
        checkElementDisplayed(mainPage.twitter);
        checkElementDisplayed(mainPage.youTube);
        checkElementDisplayed(mainPage.instagram);
        checkElementDisplayed(mainPage.vk);
        checkElementDisplayed(mainPage.ok);
    }

    @Test
    public void testScenario2() throws Exception {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        driver.get(baseUrl);
        driver.manage().window().maximize();
//Нажатие на кнопку "Застраховать себя и имущество"
        MainPage mainPage = new MainPage(driver);
        scrollToElement(mainPage.insureYourselfButton);
        Thread.sleep(1000);
        mainPage.insureYourselfButton.click();
//Нажатие на кнопку "Страхование путешественников"
        wait.until(ExpectedConditions.visibilityOf(mainPage.travelersInsuranceButton));
        mainPage.travelersInsuranceButton.click();
//Проверка наличия на странице заголовка

        TravelerEnsurancePage travelerEnsurancePage = new TravelerEnsurancePage(driver);
        checkFillFieldByText("Страхование путешественников", travelerEnsurancePage.title);
//Нажать оформить онлайн
        travelerEnsurancePage.banner.click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
//Выбор суммы страховой защиты-минимальная
        PolicyChoicePage policyChoicePage = new PolicyChoicePage(driver);
        policyChoicePage.minimalPolicy.click();
        policyChoicePage.SubmitButton.click();

//Заполнение полей застрахованных
        FormPage formPage = new FormPage(driver);
        formPage.fillFormField(formPage.insured0_surname, "IVANOV");
        formPage.fillFormField(formPage.insured0_name, "IVAN");
        formPage.fillFormField(formPage.insured0_birthDate, "15.02.1989");
        formPage.fillFormField(formPage.surname, "Петров");
        formPage.fillFormField(formPage.name, "Петр");
        formPage.fillFormField(formPage.middlename, "Петрович");
        formPage.fillFormField(formPage.birthDate, "11.09.1999");
        formPage.fillFormField(formPage.passport_series, "1111");
        formPage.fillFormField(formPage.passport_number, "123456");
        formPage.fillFormField(formPage.issueDate, "11.09.2017");
        formPage.fillFormField(formPage.issuePlace, "Москва, ОВД 13");


        checkFillField("IVANOV", formPage.insured0_surname);
        checkFillField("IVAN", formPage.insured0_name);
        checkFillField("15.02.1989", formPage.insured0_birthDate);
        checkFillField("Петров", formPage.surname);
        checkFillField("Петр", formPage.name);
        checkFillField("Петрович", formPage.middlename);
        checkFillField("11.09.1999", formPage.birthDate);
        checkFillField("1111", formPage.passport_series);
        checkFillField("123456", formPage.passport_number);
        checkFillField("11.09.2017", formPage.issueDate);
        checkFillField("Москва, ОВД 13", formPage.issuePlace);

        formPage.continueButton.click();
//Проверка появления сообщения "Заполнены не все обязательные поля"
        checkElementDisplayed(formPage.errorText);
    }
}
