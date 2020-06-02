package com.ruchi.studentRestApi;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features/",
        glue = "classpath:com.ruchi.stepdefinitions",
        strict = true
)
public class runnerClass{

}
