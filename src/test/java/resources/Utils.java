package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    RequestSpecification req;
    String logFilePath;
    public RequestSpecification requestSpecification() throws IOException {
        FileOutputStream fos = new FileOutputStream(logFilePath);
        PrintStream log = new PrintStream(fos);

        RestAssured.baseURI = getGlobalPropValue("baseUrl");

        req =new RequestSpecBuilder()
                .setBaseUri(getGlobalPropValue("baseUrl"))
                //.addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).build();
        return req;
    }

    public String getGlobalPropValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key).toString();
    }

    public void createLogFile(String logFileName) throws IOException {
        logFilePath = getGlobalPropValue("callLogsPath") + "/" + logFileName + ".txt";
        FileWriter fw = new FileWriter(logFilePath);
        fw.close();
    }
}
