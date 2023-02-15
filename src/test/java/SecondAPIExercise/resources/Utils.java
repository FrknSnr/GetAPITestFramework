package SecondAPIExercise.resources;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {

    RequestSpecification req ;

    public RequestSpecification getBaseReq(String categoryName,String results) throws IOException {
        int result = Integer.parseInt(results);
        req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI"))
                .addQueryParam("category", categoryName)
                .addQueryParam("results", result)
                .setContentType(ContentType.JSON).build();

        return req ;
    }

    public String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\HP\\Desktop\\workspace\\APIDeneme2\\src\\test\\java\\SecondAPIExercise\\resources\\global.properties");
        prop.load(fileInputStream);
        return prop.getProperty(key);
    }

    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        return objectMapper;
    }
    /*
    package cucumberAPIFramework.resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    public static RequestSpecification req;

    public RequestSpecification requestSpecification() throws IOException {

        if (req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
                    .addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }

    public String getGlobalValue(String key) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\workspace\\APITest\\src\\test\\java\\CucumberAPIFramework\\resources\\global.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key);
    }
}

     */


}
