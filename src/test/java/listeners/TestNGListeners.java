package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNGListeners implements ITestListener {

    @Override
    public void onFinish(ITestContext result) {
        // TODO Auto-generated method stub
        System.out.println("*****Test onFinish:"+result.getName());
    }

    @Override
    public void onStart(ITestContext result) {
        // TODO Auto-generated method stub
        System.out.println("*****Test Started:"+result.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        /* TODO Auto-generated method stub */
        System.out.println("*****Test failed within success percentage:"+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("*****Test on Failure:"+result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("*****Test on skipped:"+result.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("*****Test on start:"+result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("*****Test on test success:"+result.getName());

    }
}
