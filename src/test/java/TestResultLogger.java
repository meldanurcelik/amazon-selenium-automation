import com.google.common.io.Files;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class TestResultLogger implements TestWatcher, DriverInterface {

    Log log = new Log();

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        //TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        //TestWatcher.super.testSuccessful(context);
        String testName = context.getDisplayName();
        log.info(testName + " PASSED");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        //TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        //TestWatcher.super.testFailed(context, cause);
        String testName = context.getDisplayName();
        String testFailCause = cause.getMessage();
        log.error(testName + " FAILED with cause: " + testFailCause);
        String fileName = context.getDisplayName();
        takeScreenShot(fileName);
    }

    private void takeScreenShot(String fileName){
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File image = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(image , new File("screenshots/".concat(fileName).concat(".png")));
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
}
