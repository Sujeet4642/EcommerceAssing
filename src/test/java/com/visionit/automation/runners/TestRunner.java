package com.visionit.automation.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="classpath:features",
		glue="com.visionit.automation.stepdefs",
		tags="@journey",
		plugin = {"pretty",
				"html:target/html/htmlreport.html",
				"json:target/json/file.json",		
		},
		publish=true,
		dryRun=false
		)

public class TestRunner {

}
