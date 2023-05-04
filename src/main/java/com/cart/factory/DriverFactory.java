package com.cart.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    //Making public so that all classes can use WebDriver
    public WebDriver driver;
    public Properties properties;

    /**
     *  This method is used to initialize the webDriver on the basis of given browser name
     *  and will take care of local and remote execution
     * @param browserName : ex : chrome , firefox
     * @return : WebDriver
     * @author : Mohammed Hasee
     */
    public WebDriver init_driver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else {
            System.out.println("Please pass the right browser name " + browserName);
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().fullscreen();
        driver.get("https://www.saucedemo.com/");

        return driver;

    }

    /**
     * This method is used to initialize the properties file based on the environment QA/DEV/STAGE
     * @return  : Properties
     * @author : Mohammed Haseeb
     */
    public Properties init_prop()  {
        properties = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            properties.load(ip);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
