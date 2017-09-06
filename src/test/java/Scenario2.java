import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

public class Scenario2 {
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
    public void testScenario2() throws Exception {
//Переход на сайт
        driver.get(baseUrl);
        driver.manage().window().maximize();
//Нажатие на кнопку "Застраховать себя и имущество"
        driver.findElement(By.xpath("//*/ul/li[5]/a/span/span[1]")).click();
//Нажатие на кнопку "Страхование путешественников"
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Страхование путешественников"))));
        driver.findElement(By.linkText("Страхование путешественников")).click();
//Проверка наличия на странице заголовка
        assertEquals("Страхование путешественников", driver.findElement(By.xpath("//*/div/div[3]/div/div/div/div/h1")).getText());
        assertEquals("«Сбербанк» - Страхование путешественников", driver.getTitle());
//Нажатие на кнопку "Страхование путешественников"
        driver.findElement(By.cssSelector("li.active > a > span")).click();
//Нажать оформить онлайн
        driver.findElement(By.cssSelector("p > a > img")).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
//Выбор суммы страховой защиты-минимальная
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='views']/form/section/section/section[2]/div[1]/div[1]/div/div[2]"))));
        driver.findElement(By.xpath(".//*[@id='views']/form/section/section/section[2]/div[1]/div[1]/div/div[2]")).click();
//Нажать оформить
        driver.findElement(By.xpath(".//*[@id='views']/form/section/section/section[6]/span/span")).click();
//Заполнение полей застрахованных
        driver.findElement(By.name("insured0_surname")).clear();
        driver.findElement(By.name("insured0_surname")).sendKeys("IVANOV");
        driver.findElement(By.name("insured0_name")).clear();
        driver.findElement(By.name("insured0_name")).sendKeys("IVAN");
        driver.findElement(By.xpath("//*/section/section[1]/div/insured-input/div/fieldset[4]/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[2]/a")).click();
//Заполнение полей страхователя
        driver.findElement(By.name("surname")).clear();
        driver.findElement(By.name("surname")).sendKeys("Петров");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("Петр");
        driver.findElement(By.name("middlename")).clear();
        driver.findElement(By.name("middlename")).sendKeys("Петрович");
        driver.findElement(By.xpath("//*/section/section[2]/div/fieldset[7]/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[1]/td[5]/a")).click();
//Данные паспорта РФ
        driver.findElement(By.name("passport_series")).clear();
        driver.findElement(By.name("passport_series")).sendKeys("1111");
        driver.findElement(By.name("passport_number")).clear();
        driver.findElement(By.name("passport_number")).sendKeys("123456");
        driver.findElement(By.xpath("//*/section/section[3]/div/fieldset[2]/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[2]/a")).click();
        driver.findElement(By.name("issuePlace")).clear();
        driver.findElement(By.name("issuePlace")).sendKeys("Москва, ОВД 13");
//Нажатие кнопки продолжить
        driver.findElement(By.cssSelector("span.b-continue-btn")).click();
//проверка данных
        assertEquals("IVANOV", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        assertEquals("IVAN", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        assertEquals("05.09.2017", driver.findElement(By.xpath("//*/section/section[1]/div/insured-input/div/fieldset[4]/div/input")).getAttribute("value"));
        assertEquals("Петров", driver.findElement(By.name("surname")).getAttribute("value"));
        assertEquals("Петр", driver.findElement(By.name("name")).getAttribute("value"));
        assertEquals("Петрович", driver.findElement(By.name("middlename")).getAttribute("value"));
        assertEquals("03.09.1999", driver.findElement(By.xpath("//*/section/section[2]/div/fieldset[7]/div/input")).getAttribute("value"));
        assertEquals("1111", driver.findElement(By.name("passport_series")).getAttribute("value"));
        assertEquals("123456", driver.findElement(By.name("passport_number")).getAttribute("value"));
        assertEquals("05.09.2017", driver.findElement(By.xpath("//*/section/section[3]/div/fieldset[2]/div/input")).getAttribute("value"));
        assertEquals("Москва, ОВД 13", driver.findElement(By.name("issuePlace")).getAttribute("value"));
//Проверка появления сообщения "Заполнены не все обязательные поля"
        assertTrue(isElementPresent(By.xpath("//*[text()='Заполнены не все обязательные поля']")));
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
