package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

    private static Response response;

    public static Response getResponse() {
        return response;
    }

    public static void setBaseURI(String uri){
        RestAssured.baseURI = uri;
    }

    public static String getBaseURI(){
        return RestAssured.baseURI;
    }

    public static Response post(Object Json, ContentType contentType, String endpoint) {
        return response = RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .log()
                .all()
                .body(Json)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response post(Map<String, String> header, Object Json, ContentType contentType, String endpoint) {
        return response = RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .log()
                .all()
                .headers(header)
                .body(Json)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();
    }


    public static Response get (Map<String, String> header, String endpoint) {
        return response = RestAssured.given()
                .relaxedHTTPSValidation()
                .headers(header)
                .log().all()
                .when()
                .get(endpoint)
                .thenReturn();
    }
    public static Response get (Map<String, String> header,Map<String, String> param,String endpoint){
        return response = RestAssured.given()
                .relaxedHTTPSValidation()
                .headers(header)
                .params(param)
                .log().all()
                .when()
                .get(endpoint)
                .thenReturn();
}
    public static Response put(Map<String, String> header, Object Json, ContentType contentType, String endpoint) {
        return response = RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .headers(header)
                .body(Json)
                .log().all()
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response delete (Map<String, String> header, String endpoint) {
        return response = RestAssured.given()
                .relaxedHTTPSValidation()
                .headers(header)
                .log().all()
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

}
