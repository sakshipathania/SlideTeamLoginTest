package Setupclass;



import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;



//@RunWith(Cucumber.class)
@RunWith(Cucumber.class)
@CucumberOptions(features = {"."}, glue = {"StepDefination"},//tags= {"@paid_user_sign_in_via_gmail"},
plugin= {"pretty", "html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json","usage:target/usage.jsonx","junit:target/cucumber.xml"})

public class TestRunner {

	@BeforeClass
	public static void beforeClass() throws Exception {
		BaseClass.before_Class();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		BaseClass.after_Class();
	}

}
