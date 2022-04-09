package org.testcases;

import org.Methods;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class MavenTestNGExample extends BaseTest {

    Methods m = null;



        @Test
        public void myTest() throws InterruptedException {
            m = new Methods(driver);
            System.out.println("I am in my Test method");
            driver.get("https://www.google.com/");
            String t = m.getTitle();
            logger.info("Title is"+" "+t);
            Thread.sleep(10000);

        }
        @Test
        public void myTest1() {
            System.out.println("I am in my Test method 2");
            driver.get("https://www.gmail.com/");

        }


    }


