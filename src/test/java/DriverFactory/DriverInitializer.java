package DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverInitializer {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
    static final Logger logger = LogManager.getLogger("DriverFactory");
    public static DriverInitializer d = new DriverInitializer();


    public  WebDriver init_driver(String browser) {
        DOMConfigurator.configure("./LoggerDirectory/log_config.xml");
        try {
            logger.info("Setting browser value" + " " + browser);
            if (browser.equals("chrome")) {
                System.out.println("in start driver chrome");
                logger.info("in chrome driver section...");
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

        }
        catch (Exception e) {
            logger.info("An exception occurred while initializing the browser");
            logger.error(e);
            assert false;
        }
        return getDriver();

    }
    public static synchronized WebDriver getDriver() {
        System.out.println("getttt"+tlDriver.get());
        return tlDriver.get();
    }
}
