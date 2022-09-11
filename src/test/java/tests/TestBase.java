package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.BrowsersForDriver;
import utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected static String baseUrl = "https://qa-scooter.praktikum-services.ru/";
    protected WebDriver driver;

    @Before
    public void initDriver() {
        driver = WebDriverFactory.getDriverForBrowser(BrowsersForDriver.CHROME);

        driver.manage().timeouts().pageLoadTimeout(13,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
