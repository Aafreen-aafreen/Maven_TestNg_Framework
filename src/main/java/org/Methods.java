package org;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Methods {

        private WebDriver driver1;

        public  Methods(WebDriver driver)
        {

            this.driver1 = driver;

        }


        public void click_action(By locator)
        {

            driver1.findElement(locator).click();
        }
        public void sendKeys_action(By locator,String text)
        {
            driver1.findElement(locator).sendKeys(text);
        }

        public String getTitle()
        {
            System.out.println("in fun"+this.driver1);
            String s= driver1.getTitle();

            return s;
        }

        public boolean is_displayed(By locator)
        {

            return driver1.findElement(locator).isDisplayed();
        }

        public boolean is_enabled(By locator)
        {

            return driver1.findElement(locator).isEnabled();
        }
        public List<WebElement> get_list_webelements(By locator)
        {
            List<WebElement> web_ele = driver1.findElements(locator);
            return web_ele;
        }

        public void explicit_wait(By locator, Duration t)
        {
            WebDriverWait wait=  new WebDriverWait(driver1, t);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        }
        public void scroll_operation(String s )
        {
            JavascriptExecutor js = (JavascriptExecutor) driver1;
            js.executeScript("window.scrollBy(0,'"+ s +"')");
        }

        public String get_text(By locator)
        {
            return driver1.findElement(locator).getText();
        }

        public void assert_ignorecase(String s1,String s2)
        {

            assert s1.equalsIgnoreCase(s2);
        }
    }


