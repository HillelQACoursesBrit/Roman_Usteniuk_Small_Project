package org.usteniuk.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {
    public static WebDriver initDriver(DriverType drivertype) {

        switch (drivertype) {
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            }
            case OPERA: {
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            }
            case CHROME:
            default: {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
        }
    }

    public static WebDriver initDriver() {

        DriverType drivertype = DriverType.valueOf(System.getProperty("driver.type").toUpperCase());
        return initDriver(drivertype);

    }
}
