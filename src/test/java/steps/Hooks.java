package steps;

import api.ApiUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import utils.ScenarioUtils;

import java.util.HashMap;

public class Hooks extends ApiUtils {

    @Before
    public void Before(Scenario scenario) {
        ScenarioUtils.add(scenario);
        headers = new HashMap<>();
        params = new HashMap<>();
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
