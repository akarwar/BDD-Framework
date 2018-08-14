package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\ahsan\\eclipse-workspace\\FreeCrmBDDFramework\\src\\main\\java\\Features\\contacts.feature",glue= {"step_def"},
		plugin= {"pretty,html:test-output"},// to generate different reports
		dryRun=false,//to check the mapping is proper between feature file and step def file
		strict=true,// will fail the execution if any step is undefined in step def file
		monochrome=true// console output will be in readable format
		)

public class TestRunner {

}
