package org.testcases;

import DriverFactory.DriverManager;
import File_Reader_Utilities.ExcelReader;
import File_Reader_Utilities.PropertyFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.Methods;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;
import java.util.Properties;

public class BaseTest  {

    WebDriver driver;
    private DriverManager manager = new DriverManager();
    protected PropertyFileReader p_reader = new PropertyFileReader();
    Properties prop;
    ExcelReader e_reader = new ExcelReader();
    static final Logger logger = LogManager.getLogger("BaseTest");
    String logfilePath = "./LoggerDirectory/log_config.xml";




    @BeforeTest
    public void setting_up_instances()
    {

        prop = p_reader.init_prop();
        System.out.println(prop);
        DOMConfigurator.configure(logfilePath);
        logger.info("Setting up the instances for properties file");
        logger.info("Setting up the path for log file");

    }

    @BeforeMethod
    public void start_webdriver()
    {
        prop.getProperty("browser");
        driver = manager.init_driver("chrome");
    }

    @AfterMethod
    public void shutting_down_webdriver()
    {
        logger.info("Closing the browser");
        driver.close();
        logger.info("Browser is closed successfully");
    }




    }

