package org.livin.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.livin.helper.Constants.VENUE_END_POINT;
import static org.livin.helper.RequestResponseManager.request;
import static org.livin.helper.RequestResponseManager.response;

public class Steps {
    JsonPath jPath;

    @Given("^I make a Get call to venues endpoint$")
    public void makeGetCall() {
        response = request.get(VENUE_END_POINT).then().extract().response();
    }

    @Then("^I validate response code is (\\d+)$")
    public void validateresponseCode(int code) {
        response.then().statusCode(code);
    }

    @Then("^I get the count of each categories in the response$")
    public void getCountForAllCategories() {
        jPath = new JsonPath(response.asString());
        List<String> categories = jPath.get("venues.category");
        Map<String, Long> categoryMap1 = categories.stream().collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        System.out.println("------- Category counts (Case Sensitive) --------");
        System.out.println(categoryMap1);
        Map<String, Long> categoryMap2 = categories.stream().collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        System.out.println("------- Category counts (Ignoring Case)--------");
        System.out.println(categoryMap2);
    }

    @Then("^I get all the Names of Food Category$")
    public void getNamesForAllFoodCategories() {
        List<Map<Object, Object>> categories = jPath.get("venues");
        List<Object> names = categories.stream().filter(i -> i.get("category").equals("food")).map(i -> i.get("name")).collect(Collectors.toList());
        System.out.println("------- Names of Food Category--------");
        System.out.println(names);
    }

    @Then("^I get all the GeoLocations of Food Category$")
    public void getGeoLocForAllFoodCategories() {
        List<Map<Object, Object>> categories = jPath.get("venues");
        List<Object> GeoDegree = categories.stream().filter(i -> i.get("category").equals("food")).map(i -> i.get("geolocation_degrees")).collect(Collectors.toList());
        System.out.println("------- geolocation_degrees of Food Category--------");
        System.out.println(GeoDegree);
    }

}
