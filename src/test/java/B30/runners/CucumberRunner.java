package B30.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features",
        glue= "B30/step_definitions",
        dryRun = false,
        tags = "@test",
        publish = true


)


public class CucumberRunner {
}
