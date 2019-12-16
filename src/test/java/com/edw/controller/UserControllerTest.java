package com.edw.controller;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

/**
 * <pre>
 *     com.edw.controller.UserControllerTest
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 16 Des 2019 15:08
 */
@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class UserControllerTest {

    @Test
    public void testIndex() {
        given()
                .when().get("/")
                .then()
                .statusCode(200)
                .body(is("hello world"));
    }

    @Test
    public void test404() {
        given()
                .when().get("/404/not-found")
                .then()
                .statusCode(404);
    }

    @Test
    public void testInsert() {
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"username\":\"888999\",\n" +
                        "\t\"passwd\":\"999\"\n" +
                "}")
                .when()
                    .post("/")
                .then()
                    .statusCode(200)
                    .body(containsString("\"id\""));

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"username\":\"123\",\n" +
                        "\t\"passwd\":\"999\"\n" +
                "}")
                .when()
                    .post("/")
                .then()
                    .statusCode(200)
                    .body(containsString("\"id\""));
    }

}
