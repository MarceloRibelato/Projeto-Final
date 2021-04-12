package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import utils.ReportUtils;

import java.io.IOException;

/**
 * @author Marcelo
 */

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/report/cucumber.html",
        "json:target/report/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"steps"},
        tags = "@regressivo")


public class RunTest {
    @AfterClass
    public static void report() throws IOException {
        ReportUtils.gerar();
        Runtime.getRuntime().exec("cmd.exe /c mvn cluecumber-report:reporting");
    }
}


