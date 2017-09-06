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
//Нажатие на кнопку "Страхование путешественников"
        driver.findElement(By.cssSelector("li.active > a > span")).click();
        driver.findElement(By.cssSelector("p > a > img")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
        //driver.switchTo().window("Сбербанк страхование");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

//driver.switchTo().window(windowHandler);
//минимальная
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='views']/form/section/section/section[2]/div[1]/div[1]/div/div[2]"))));
        driver.findElement(By.xpath(".//*[@id='views']/form/section/section/section[2]/div[1]/div[1]/div/div[2]")).click();
        Thread.sleep(5000);
//оформить
        driver.findElement(By.xpath(".//*[@id='views']/form/section/section/section[6]/span/span")).click();

        driver.findElement(By.name("insured0_surname")).clear();
        driver.findElement(By.name("insured0_surname")).sendKeys("IVANOV");
        driver.findElement(By.name("insured0_name")).clear();
        driver.findElement(By.name("insured0_name")).sendKeys("IVAN");


        driver.findElement(By.xpath("/html/body/div[1]/div/section/form/section/section[1]/div/insured-input/div/fieldset[4]/div/img")).click();
        driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[5]/a")).click();

        driver.findElement(By.name("surname")).clear();
        driver.findElement(By.name("surname")).sendKeys("Петров");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("Петр");
        driver.findElement(By.name("middlename")).clear();
        driver.findElement(By.name("middlename")).sendKeys("Петрович");

        driver.findElement(By.xpath("/html/body/div[1]/div/section/form/section/section[2]/div/fieldset[7]/div/img")).click();
        driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[1]/td[5]/a")).click();
        driver.findElement(By.name("passport_series")).clear();
        driver.findElement(By.name("passport_series")).sendKeys("1111");
        driver.findElement(By.name("passport_number")).clear();
        driver.findElement(By.name("passport_number")).sendKeys("123456");
        driver.findElement(By.xpath("/html/body/div[1]/div/section/form/section/section[3]/div/fieldset[2]/div/img")).click();
        driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[2]/a")).click();
        driver.findElement(By.name("issuePlace")).clear();
        driver.findElement(By.name("issuePlace")).sendKeys("Москва, ОВД 13");
        driver.findElement(By.cssSelector("span.b-continue-btn")).click();


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
