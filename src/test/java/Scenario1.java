import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario1 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testScenario1() throws Exception {
//Переход на сайт
        driver.get(baseUrl);
//Разворачивание окна на весь экран
        driver.manage().window().maximize();
//Поиск и нажание на кнопку выбора региона
        driver.findElement(By.cssSelector("span.region-list__arrow")).click();
//Поиск поля для ввода, ввод области и нажатие на нужный элемент
        WebElement search = driver.findElement(By.xpath("(//input[@value=''])[3]"));
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 6000);
        wait.until(ExpectedConditions.visibilityOf(search));
        search.click();
        search.sendKeys("Нижегородская область");
        driver.findElement(By.xpath("/html/body/div[6]")).click();
//Проверка, что выбрался нужный регион
        assertTrue(isElementPresent(By.linkText("Нижегородская область")));
//Ожидание загрузки footer.
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//*[@class='sbrf-div-list-inner --area bp-area footer-container']"))));
//Скролинг до footer'a
        WebElement footer = driver.findElement(By.xpath("//*[@class='sbrf-div-list-inner --area bp-area footer-container']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", footer);
//Просто таймаут для просмотра выполнения скроллинга
//        Thread.sleep(5000);
//Проверка наличия иконок соц сетей
        assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_fb']")));
        assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_tw']")));
        assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_yt']")));
        assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_ins']")));
        assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_vk']")));
        assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_ok']")));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
