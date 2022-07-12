package com.qa.utility;

import com.qa.testscripts.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends TestBase implements ITestListener {
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
        ITestListener.super.onTestSuccess(result);
        System.out.println("Testcase '" + result.getMethod().getMethodName() + "' passed");
        if(result.getMethod().getMethodName().contains("properties")){
            System.out.println(data.getTittle());
            System.out.println(result.getInstanceName());
            System.out.println();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
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
