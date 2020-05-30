package org.usteniuk.driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.usteniuk.TestProjectFileUtils;
import org.usteniuk.listners.MyListener;

import java.io.File;
import java.io.IOException;

@Listeners(MyListener.class)
public class BaseTestClass {

    public BaseTestClass(){
        PageFactory.initElements(DriverHolder.getInstance().getDriver(), this);
    }

    @BeforeSuite
    public void beforeSuite() throws IOException {
        DriverHolder.getInstance().initDriver(DriverType.CHROME);
        TestProjectFileUtils.createFolderForScreens();

    }

    protected void goToUrl(String url) {
        DriverHolder.getInstance().getDriver().get(url);
    }

    @AfterSuite
    public void afterSuite() throws NullPointerException {
        DriverHolder.getInstance().getDriver().quit();
    }
}
