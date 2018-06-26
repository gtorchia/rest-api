
package options;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


/**
 * cucumber runner with pretty report
 */
    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"pretty","html:target/cucumber", "json:target/cucumber.json"},
            features = {"src/test/java/features/"},
            glue = {"classpath:scr.test.java.stepdefinition"}
    )

    public class CucumberTests {}

