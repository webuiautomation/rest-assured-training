import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Date;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasLength;

public class TC01_GetDemo {

    @Test
    public void getDemo(Method method){

        String date= String.valueOf(new Date().getTime());
        ExtentReports extent = new ExtentReports(date+"_apidemo.html");
        extent.loadConfig(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\config.xml"));
        ExtentTest test=extent.startTest(method.getName());

        when().
                get("https://reqres.in/api/users?page=2").
        then().
                statusCode(200)
                .body("data.email[0]",hasLength(24));


        Response response=get("https://reqres.in/api/users?page=2");
        test.log(LogStatus.PASS,"Response code is "+response.getStatusCode());
        extent.endTest(test);

        //test 2
        test=extent.startTest("PostDemo");
        test.log(LogStatus.FAIL,"This is post demo");
        extent.endTest(test);

        extent.flush();
        //this is test
    }

}
