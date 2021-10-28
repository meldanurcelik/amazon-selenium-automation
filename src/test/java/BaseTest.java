import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestResultLogger.class)
public class BaseTest implements DriverInterface{

    @BeforeAll
    public void setup(){
        driver.get("https://www.amazon.com.tr/");
    }

    @AfterAll
    public void tearDown(){
        driver.close();
    }
}
