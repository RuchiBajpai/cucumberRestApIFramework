package com.ruchi.stepdefinitions;

import com.ruchi.studentRestApi.StudentControllerApiRestAssured;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class MyStepdefs {

    StudentControllerApiRestAssured resapi = new StudentControllerApiRestAssured();

    @Given("I create the following student using the rest API:")
    public void iCreateTheFollowingStudentUsingTheRestAPI(DataTable dataTable) {
        String studentJson = convertStudentDTToJson(dataTable);
        Response response = resapi.postCall(studentJson);
        int code = response.getStatusCode();
        Assertions.assertEquals(200, code);

    }

    @Then("^I should be able to fetch the student for a specific student id \"([^\"]*)\" using the rest API$")
    public void iShouldBeAbleToFetchTheStudentForASpecificStudentIdUsingTheRestAPI(String studentid)  {
        Integer id = Integer.valueOf(studentid);
        JSONObject jo = new JSONObject();
        jo.put("id",id);
        Response response = resapi.getCall(id);
        int code = response.getStatusCode();
        Assertions.assertEquals(200, code);
    }


    @Given("I update the following student using the rest API:")
    public void iUpdateTheFollowingStudentUsingTheRestAPI(DataTable dataTable) throws Throwable {
        Map<String, String> parameters = dataTable.asMap(String.class, String.class);
        Integer id = Integer.valueOf(parameters.get("id"));
        JSONObject jo = new JSONObject();
        jo.put("id",id);
        Response response = resapi.putCall(jo.toString(),id);
        int code = response.getStatusCode();
        Assertions.assertEquals(200, code);

    }


    @Given("^I delete the student with student id \"([^\"]*)\" using the rest API$")
    public void iDeleteTheStudentWithStudentIdUsingTheRestAPI(String studentid) {
        Integer id = Integer.valueOf(studentid);
        JSONObject jo = new JSONObject();
        jo.put("id",id);
        Response response = resapi.deleteCall(id);
        int code = response.getStatusCode();
        Assertions.assertEquals(200, code);
    }

    @Then("^I should not be able to fetch the deleted student for a specific student id \"([^\"]*)\" using the rest API$")
    public void iShouldNotAbleToFetchTheDeletedStudent(String studentid){
        Integer id = Integer.valueOf(studentid);
        JSONObject jo = new JSONObject();
        jo.put("id",id);
        Response response = resapi.getCall(id);
        int code = response.getStatusCode();
        Assertions.assertEquals(404, code);
    }


    private String convertStudentDTToJson(DataTable dataTable){
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
        System.out.println(jo.toString());
        return jo.toString();
    }


}
