import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

public class Test_Screenhoot extends BaseTest {

    @Test
    public void sample_fail_test(){
        System.out.println("This test will fail");
        fail();
    }
}
