package com.edw.controller;

import com.edw.entity.User;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    public void testBean() {
        User user = new User("01", "username", "password");
        Assertions.assertNotNull(user);
        Assertions.assertNotEquals(user, new User());
    }

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
    public void testNoObjectWhenUsingRandomUid() {
        given()
                .when().get("/"+ UUID.randomUUID().toString())
                .then()
                .statusCode(204);
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

    @Test
    public void testFindById() {
        Map map = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"username\":\"666\",\n" +
                        "\t\"passwd\":\"999\"\n" +
                        "}")
                .when()
                    .post("/")
                .then()
                    .statusCode(200)
                    .body(containsString("\"id\""))
                .extract()
                .as(HashMap.class);

        String id = (String) map.get("id");

        given()
                .accept(ContentType.JSON)
                .when()
                    .get("/"+id)
                .then()
                    .statusCode(200)
                    .body(containsString(id));

        given()
                .accept(ContentType.JSON)
                .when()
                    .get("/exist/"+id)
                .then()
                    .statusCode(200)
                    .body(containsString("true"));
    }

    @Test
    public void testGetAll() {
        given()
                .when()
                    .get("/all")
                .then()
                    .statusCode(200);
    }

    @Test
    public void testDeleteById() {
        Map map = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"username\":\"55433\",\n" +
                        "\t\"passwd\":\"999\"\n" +
                        "}")
                .when()
                .post("/")
                .then()
                .statusCode(200)
                .body(containsString("\"id\""))
                .extract()
                .as(HashMap.class);

        String id = (String) map.get("id");

        given()
                .accept(ContentType.JSON)
                .when()
                .delete("/"+id)
                .then()
                .statusCode(200);
    }
}
