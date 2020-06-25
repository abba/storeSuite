package support;



import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.concurrent.TimeUnit;

/**
 * Created by zsuleiman on 22/06/2020.
 */
public class BrowserCore {

    public static WebDriver aDriver;
    private static String currentDir;

    public BrowserCore(WebDriver aDriver) {

        this.aDriver = aDriver;

    }


    public static void setSystemsProperties() {


        currentDir = System.getProperty("user.dir");

        if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", currentDir
                    + "/drivers/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", currentDir
                    + "/drivers/chromedriver");
        }


    }

    public static WebDriver initialiseDriver() {

        setSystemsProperties();
        aDriver = new ChromeDriver();
        aDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);


        return aDriver;
    }

    public static void quiteDriver() {

        try {

            aDriver.close();
            if (aDriver != null) {

                aDriver.quit();
                aDriver = null;
            }

        } catch (UnreachableBrowserException e) {

            System.out.println("Browser has already Shutdown");

        }


    }


    public static void screenShotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) try {

            scenario.write(scenario.getName() + " ---- " + scenario.getId()
                    + " ------- " + scenario.getStatus() + "\n"
                    + aDriver.getCurrentUrl());

            byte[] screenshot = ((TakesScreenshot) aDriver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

        } catch (WebDriverException screenShotException) {
            System.err.println(screenShotException.getMessage());
        }
    }
}