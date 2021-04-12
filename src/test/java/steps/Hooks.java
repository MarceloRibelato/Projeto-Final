package steps;

import api.ApiUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import utils.ScenarioUtils;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Hooks extends ApiUtils {

    @Before
    public void Before(Scenario scenario) {
        ScenarioUtils.add(scenario);
        headers = new HashMap<>();
        params = new HashMap<>();
        Awaitility.setDefaultTimeout(10, TimeUnit.MILLISECONDS);
        Awaitility.setDefaultPollInterval(10, TimeUnit.MILLISECONDS);
        Awaitility.setDefaultPollDelay(10, TimeUnit.MILLISECONDS);
    }

    @After
    public void AfterTest() {
        ScenarioUtils.remove();
    }

    @AfterAll
    public void DepoisDeTudo(){
        System.out.println("Fim");
    }
}
