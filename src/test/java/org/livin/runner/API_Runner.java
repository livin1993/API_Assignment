package org.livin.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "",
        features = "src/test/java/org/livin/features",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"})
public class API_Runner {

}
