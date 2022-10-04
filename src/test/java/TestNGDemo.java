import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo {

    @BeforeMethod
    public void authenticate(){
        System.out.println("Authenticated successfully");
    }

    @Test(priority = 1,groups = {"payment"})
    public void a(){
        System.out.println("Amazon API 1");
    }

    @Test(priority = 2,groups = {"payment"})
    public void c(){
        System.out.println("Amazon API 2");
    }

    @Test(priority = 3,groups = {"cart"})
    public void b(){
        System.out.println("Amazon API 3");
    }

    @AfterMethod
    public void logout(){
        System.out.println("logout successfully");
    }
}
