import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;


public class HTMLReportDemo {

    @Test
    public void HtmlDemo(){
        ExtentReports extent = new ExtentReports("apidemo.html");
        ExtentTest test=extent.startTest("Test 1 started");

        test.log(LogStatus.PASS,"API 1 passed");
        test.log(LogStatus.FAIL,"API 1 Failed");
        test.log(LogStatus.INFO,"API 1 Info");
        test.log(LogStatus.WARNING,"API 1 Warning");
        test.log(LogStatus.ERROR,"API 1 Error");

        extent.endTest(test);
        extent.flush();
    }

}
