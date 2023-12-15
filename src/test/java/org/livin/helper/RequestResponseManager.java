package org.livin.helper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.livin.helper.Constants.BASE_URI;

public class RequestResponseManager {

    public static RequestSpecification request = given().baseUri(BASE_URI).log().all();

    public static Response response;
}
