package DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class DriverManager {

    WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
    static final Logger logger = LogManager.getLogger("DriverFactory");


    public  WebDriver init_driver(String browser) {
        DOMConfigurator.configure("./LoggerDirectory/log_config.xml");
        try {
            logger.info("Setting browser value" + " " + browser);
            if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                tlDriver.set(new ChromeDriver());
                logger.info("Setting browser value");
            }
            else if (browser.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver());
                logger.info("Setting browser value");

            }
            else if (browser.equals("safari")) {
                tlDriver.set(new SafariDriver());
                logger.info("Setting browser value");
            }
            else {
                logger.info("Failed setting browser value" + " " + browser);
            }
            driver = tlDriver.get();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();

        }
        catch (Exception e) {
            logger.info("An exception occurred while initializing the browser");
            logger.error(e);
            assert false;
        }
        return driver;

    }

}
