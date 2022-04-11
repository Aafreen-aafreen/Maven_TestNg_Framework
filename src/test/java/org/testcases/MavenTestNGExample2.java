package org.testcases;

import Listener_Screenshot.TestAllureListener;
import org.Methods;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({TestAllureListener.class})
public class MavenTestNGExample2 extends BaseTest {

    Methods m = null;



        @Test
        public void myTest_fb() throws InterruptedException {
            m = new Methods(driver);
            System.out.println("I am in my Test method fb"+driver);
            driver.get("https://www.facebook.com/");
            String t = m.getTitle();
            //assert t.equalsIgnoreCase("ggg");
            logger.info("Title is"+" "+t);
            Thread.sleep(10000);

        }
    @Test
    public void myTest_gmail() throws InterruptedException {
        m = new Methods(driver);
        System.out.println("I am in my Test method gmail"+driver);
        driver.get("https://www.gmail.com/");
        String t = m.getTitle();
        //assert t.equalsIgnoreCase("ggg");
        logger.info("Title is"+" "+t);
        Thread.sleep(10000);

    }



    }


