package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class TaskTrackerApiTest {
    @BeforeTest
    public static void setup() {
        RestAssured.baseURI = "http://localhost:9090";
        RestAssured.basePath = "/task";
    }

    @Test
    public void createTask() {
        TaskTrackerPojo inputTask = new TaskTrackerPojo();
        inputTask.setTask("dev");

        TaskTrackerPojo saveTasks = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(inputTask)
                .when() // <--- MISSING ACTION
                .post("/addTask")
                .then() // <--- VALIDATION
                .log().all()
                .statusCode(201)
                .body("task", equalTo("dev")) // Match your input "dev"
                .extract()
                .as(TaskTrackerPojo.class); // Deserializes the JSON response

        System.out.println("Generated ID: " + saveTasks.getId());
    }

    @Test
    public void deleteTask() {
        given().log()
                .all()
                .queryParam("id", 2)
                .when()
                .delete("/deleteTaskById")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testGetAllTasks() {
        given()
                .log().all()
                .when()
                .get("/task/getAllTasks")
                .then()
                .log().all() // This will show you if you are getting a 500 or 403 error
                .extract().response();
    }
}
