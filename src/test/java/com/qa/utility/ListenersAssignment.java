package com.qa.utility;

import com.qa.testscripts.TestBaseAssigment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ListenersAssignment extends TestBaseAssigment implements ITestListener {
    encapsulation data = new encapsulation();

    /*@Override
    public void getUrl(WebDriver driver){
        ITestResult result = Reporter.getCurrentTestResult();
        result.setAttribute();
    }*/
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = ((TestBaseAssigment) currentClass).getDriver();
        if (driver != null) {
            try {
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(file, new File(System.getProperty("user.dir" + "\\image") + File.separator +
                        result.getName() + "_" + result.getEndMillis() + ".png"));
                System.out.println("*******Screenshot captured********");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = ((TestBaseAssigment) currentClass).getDriver();
        if (driver != null) {
            try {
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(file, new File(System.getProperty("user.dir" + "\\image") + File.separator +
                        result.getName() + "_" + result.getEndMillis() + ".png"));
                System.out.println("*******Screenshot captured********");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        System.out.println(context);
    }
}
