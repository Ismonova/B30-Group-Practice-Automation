package B30.step_definitions;

import B30.pages.LoginPage;
import B30.utilities.BrowserUtils;
import B30.utilities.ConfigurationReader;
import B30.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {
LoginPage loginPage = new LoginPage();
    @Before(order = 1)

    public void setupMethod(){

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Driver.getDriver().get(ConfigurationReader.getProperty("meetSkyUrl"));
        loginPage.login(ConfigurationReader.getProperty("login"), ConfigurationReader.getProperty("password"));
    }

    @After
    public void teardownMethod(Scenario scenario){

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }



        BrowserUtils.sleep(2);
        Driver.closeDriver();

    }

}
