package com.salesforce.runnerfile;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		//features = {"src/test/resources/features/login1.feature"}, 
        features = {"src/test/resources/features/leads.feature"},    
glue = {"com.salesforce.stepdef"},
       dryRun =false,
       monochrome =true,
     //  tags = "@smoke or @regression",
       plugin= {"pretty", "html:target/cucumber-reports.html"}
)
public class LoginRunner extends AbstractTestNGCucumberTests {
	
	

}
