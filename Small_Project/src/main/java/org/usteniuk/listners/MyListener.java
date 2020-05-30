package org.usteniuk.listners;


import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.usteniuk.TestProjectFileUtils;
import org.usteniuk.driver.DriverHolder;



import java.nio.file.Files;
import java.io.File;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MyListener extends TestListenerAdapter {
    private static final  Logger logger = Logger.getLogger(MyListener.class.getName());

    static {
        try{
            LogManager.getLogManager().readConfiguration(MyListener.class.getClassLoader().getResourceAsStream("logger.properties"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult){
        logger.info("-----------------Test " + iTestResult.getMethod().getMethodName() + " starts!-----------------");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult){
        logger.info("-----------------Test " + iTestResult.getMethod().getMethodName() + " finish!-----------------");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult){
        File screenshotFile = ((TakesScreenshot) DriverHolder.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        getAttachment(screenshotFile);
        try {
            FileUtils.copyFile(screenshotFile, new File(TestProjectFileUtils.getScreensFolder(), iTestResult.getName() + ".jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] getAttachment(File screenShot){
        try {
            return Files.readAllBytes(screenShot.toPath());
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult){
        logger.info("-----------------Test " + iTestResult.getMethod().getMethodName() + " skipped!-----------------");
    }



}
