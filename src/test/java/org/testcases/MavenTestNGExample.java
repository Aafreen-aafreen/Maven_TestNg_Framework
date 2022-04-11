package org.testcases;

import Listener_Screenshot.TestAllureListener;
import org.Methods;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Listeners({TestAllureListener.class})
public class MavenTestNGExample extends BaseTest {

    Methods m = null;



        @Test
        public void myTest_googl() throws InterruptedException {
            m = new Methods(driver);
            System.out.println("I am in my Test method");
            driver.get("https://www.google.com/");
            String t = m.getTitle();
            logger.info("Title is"+" "+t);
            Thread.sleep(10000);

        }



    }


