import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/feature/Calculadora.feature"
        ,glue={"com/sofka/automatizacion/steps/"}
        ,tags = {"@outline"}
        ,format = {"pretty", "html:target/Destination"}
)


public class TestRunnerOperaciones {
}
