package com.automation.framework.apiutils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * Utility class for handling REST API requests
 */
public class APIUtils {
    private static final Logger logger = LogManager.getLogger(APIUtils.class);
    
    private APIUtils() {} // Prevent instantiation

    public static Response get(String baseUri, String endpoint, Map<String, String> headers) {
        logger.info("Sending GET request to: {}{}", baseUri, endpoint);
        RequestSpecification request = RestAssured.given()
                .baseUri(baseUri)
                .headers(headers);
        
        Response response = request.get(endpoint);
        logResponseDetails(response);
        return response;
    }

    public static Response post(String baseUri, String endpoint, Object body, Map<String, String> headers) {
        logger.info("Sending POST request to: {}{}", baseUri, endpoint);
        RequestSpecification request = RestAssured.given()
                .baseUri(baseUri)
                .headers(headers)
                .body(body);
        
        Response response = request.post(endpoint);
        logResponseDetails(response);
        return response;
    }

    private static void logResponseDetails(Response response) {
        logger.info("Response status: {}", response.getStatusCode());
        logger.debug("Response body: {}", response.getBody().asPrettyString());
    }
}
