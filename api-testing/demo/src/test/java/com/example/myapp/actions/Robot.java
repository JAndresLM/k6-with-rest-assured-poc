package com.example.myapp.actions;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.*;

public class Robot{
    private String baseUrl;

    public Robot(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Sends a GET request to the specified endpoint and converts the response
     * to the specified class type.
     *
     * @param endpoint The endpoint to send the GET request to.
     * @param responseType The class type to convert the response to.
     * @param <T> The type parameter.
     * @return The deserialized response object.
     */
    public <T> T get(String endpoint, Class<T> responseType) {
        Response response = given()
            .baseUri(baseUrl) // Set the base URI
            .when()
            .get(endpoint)
            .then()
            .extract()
            .response();

        // Check for success status code (200 OK)
        if (response.getStatusCode() == 200) {
            return response.as(responseType); // Deserialize the response
        } else {
            throw new RuntimeException("Failed: HTTP error code: " + response.getStatusCode());
        }
    }

    /**
     * Sends a POST request to the specified endpoint with the given payload
     * and converts the response to the specified class type.
     *
     * @param endpoint The endpoint to send the POST request to.
     * @param payload The object to be serialized and sent as the request body.
     * @param responseType The class type to convert the response to.
     * @param <T> The type parameter.
     * @return The deserialized response object.
     */
    public <T> T post(String endpoint, Object payload, Class<T> responseType) {
        Response response = given()
            .baseUri(baseUrl) // Set the base URI
            .contentType("application/json") // Set content type to JSON
            .body(payload) // Set the request body
            .when()
            .post(endpoint)
            .then()
            .extract()
            .response();

        // Check for success status code (201 Created)
        if (response.getStatusCode() == 201) {
            return response.as(responseType); // Deserialize the response
        } else {
            throw new RuntimeException("Failed: HTTP error code: " + response.getStatusCode());
        }
    }

    // Add more methods for PUT, DELETE, etc. as needed

}