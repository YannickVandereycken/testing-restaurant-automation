package ui;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        tags = ("@UI"),
        glue = {"ui/steps"},
        plugin = {"json:target/ui-test.json"}
)
public class CucumberTests {
}