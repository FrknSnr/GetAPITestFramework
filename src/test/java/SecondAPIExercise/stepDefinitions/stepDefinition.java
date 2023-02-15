package SecondAPIExercise.stepDefinitions;

import SecondAPIExercise.pojoClasses.Products;
import SecondAPIExercise.resources.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.internal.org.objectweb.asm.TypeReference;

import javax.rmi.CORBA.Util;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class stepDefinition extends Utils {
    RequestSpecification baseReq;
    Response response;
    Products[] products;


    @Given(":Category {string} and results {string}")
    public void categoryAndResults(String categoryName, String results) throws IOException {
/*
        response = given().spec(requestSpecification())
                .body(testDataBuild.addPlacePayload(name,language,address));
 */
        baseReq = given().spec(getBaseReq(categoryName, results));
    }

    @When(":user calls GET API")
    public void user_calls_get_api() throws JsonProcessingException {
//        String req = given().spec(baseReq).when().get("/products").asString();
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        response = given().spec(baseReq).when()
                .get("/products")
                .then().extract().response();

        products = objectMapper().readValue(response.asString(), Products[].class);

//
//        products = response.as(Products[].class);
    }

    @Then(":check if the status code is {int}")
    public void check_if_the_status_code_is(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @And(":get the first product's id")
    public void getTheFirstProductSId() {
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].getId());
        }
    }
}
