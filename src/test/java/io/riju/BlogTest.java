package io.riju;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class BlogTest {

    @Test
    public void testGetPosts() {
        given()
          .when().get("/posts")
          .then()
             .statusCode(200);
    }

    @Test
    public void testGetPost() {
        given()
          .pathParam("id", "2682")
          .when()
          .get("/posts/{id}")
          .then()
             .statusCode(200)
             .extract()
             .as(BlogPost.class);
    }
}