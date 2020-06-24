package org.usteniuk.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverHolder {
    private WebDriver driver;
    private static DriverHolder INSTANCE = null;
    private WebDriverWait webDriverWait;


    public static DriverHolder getInstance(){
        if (INSTANCE == null){
            INSTANCE = new DriverHolder();
        }
        return INSTANCE;
    }
    public void initDriver(DriverType driverType){
        driver = DriverFactory.initDriver(driverType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public WebDriver getDriver(){
        return driver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    private DriverHolder(){

    }
}
