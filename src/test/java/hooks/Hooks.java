package hooks;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;
import core.utils.ExtentReportManager;
import core.DriverManager;
import core.constants.Common;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;
    static ExtentReports extent = ExtentReportManager.getReportInstance();
    static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public static ExtentTest getTest() {
        return test.get();
    }
    @Before
    public void setup(Scenario scenario) {
        ExtentTest extentTest = extent.createTest(scenario.getName());
        test.set(extentTest);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
//        options.addArguments("--window-size=1920,1080");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--no-sandbox");
//
//        driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver= new ChromeDriver();
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Common.URL);
    }
    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            test.get().fail("Step failed: " + scenario.getName());
        } else {
            test.get().log(Status.PASS, "Step passed");
        }
    }


    @After
    public void cleanUp() {
        extent.flush();
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
            DriverManager.removeDriver();
        }
    }
}
