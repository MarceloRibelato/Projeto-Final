package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author Marcelo
 */

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber.html"},
        features = {"src/test/resources/features"},
        glue = {"steps"},
        tags = "@regressivo")


public class RunTest {

}


