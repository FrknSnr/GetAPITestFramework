package SecondAPIExercise.cucumber.options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\HP\\Desktop\\workspace\\APIDeneme2\\src\\test\\java\\SecondAPIExercise\\features\\",
        glue = {"SecondAPIExercise\\stepDefinitions"})
public class Runner {

}
