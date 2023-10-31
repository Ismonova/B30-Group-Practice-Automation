package B30.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver(){
    }
    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
                /*
                we will read our browserType from Configuration.properties file.
                This was, we can control which browser is opened from outside our code
                 */
            String browserType = ConfigurationReader.getProperty("browser");



            switch (browserType) {
                case "chrome":

                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    break;
                case "firefox":

                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    break;


            }
        }
        return driver;
    }


    public static void closeDriver() {
        if (driver != null) {

            driver.quit();

/*
We assign the value back to "null" so that my "singleton" can creat a newer one if passed
 */
            driver = null;
        }
    }
}
