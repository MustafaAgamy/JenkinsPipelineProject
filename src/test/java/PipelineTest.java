import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PipelineTest {

    private WebDriver driver;

    @BeforeMethod
    private void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
    }

    @Test
    public void testMethod(){

    }

    @AfterMethod
    private void tearDown(){
        if(driver != null) {
            driver.quit();
        }
    }
}
