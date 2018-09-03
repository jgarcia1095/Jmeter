import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/feature/Rest.feature"
        ,glue={"com/sofka/automatizacion/steps/"}
        //,tags = {"@outline"}
        ,format = {"pretty", "html:target/Destination"}
)

public class TestRunnerRestService {
}
