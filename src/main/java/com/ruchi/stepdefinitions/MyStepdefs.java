package com.ruchi.stepdefinitions;


import com.ruchi.studentRestApi.StudentControllerApiRestAssured;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class MyStepdefs {

    StudentControllerApiRestAssured resapi = new StudentControllerApiRestAssured();

    @Given("I create the following student using the rest API:")
    public void iCreateTheFollowingStudentUsingTheRestAPI(DataTable dataTable) throws Throwable {
        Map parameters = dataTable.asMap(String.class, String.class);
        String id = (String) parameters.get("id");
        String firstName = (String) parameters.get("firstName");
        String lastName = (String) parameters.get("lastName");
        String nationality = (String) parameters.get("nationality");
        String studentClass = (String) parameters.get("studentClass");
        JSONObject jo = new JSONObject();
        jo.put("id",id);
        jo.put("firstName",firstName);
        jo.put("lastName", lastName);
        jo.put("nationality", nationality);
        jo.put("studentClass", studentClass);
        String studentJson = jo.toString();
        System.out.println(jo.toString());
        Response response = resapi.postCall(studentJson);
        int code = response.getStatusCode();
        Assertions.assertEquals(200, code);

    }
}
