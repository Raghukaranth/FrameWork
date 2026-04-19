package tests;

import interactions.ApiClient;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class TaskTrackerApiTest {
    private ApiClient apiClient;
    private long createdTaskId;

    @BeforeTest
    public void setup() {
        baseURI = "https://fakestoreapi.com";
    }

//    @Test
//    public void createTask() {
//        TaskTrackerPojo inputTask = new TaskTrackerPojo();
//        inputTask.setTask("dev");
//
//        TaskTrackerPojo saveTasks = given()
//                .log().all()
//                .contentType(ContentType.JSON)
//                .body(inputTask)
//                .when() // <--- MISSING ACTION
//                .post("/addTask")
//                .then() // <--- VALIDATION
//                .log().all()
//                .statusCode(201)
//                .body("task", equalTo("dev")) // Match your input "dev"
//                .extract()
//                .as(TaskTrackerPojo.class); // Deserializes the JSON response
//
//        System.out.println("Generated ID: " + saveTasks.getId());
//    }

    @Test
    public void addProducts() {
        FakeStoreapi fakeStoreapi = new FakeStoreapi();
        fakeStoreapi.setUsername("");
        fakeStoreapi.setPassword("");

        FakeStoreapi apiForFakeStore = given()
                .when()
                .body(fakeStoreapi)
                .post("/auth/login")
                .then()
                .statusCode(200).log().all().extract().as(FakeStoreapi.class);
    }

//    @Test
//    public void deleteTask() {
//        given().log()
//                .all()
//                .queryParam("id", 2)
//                .when()
//                .delete("/deleteTaskById")
//                .then()
//                .log().all()
//                .statusCode(200);
//    }
//
//    @Test
//    public void testGetAllTasks() {
//        given()
//                .log().all()
//                .when()
//                .get("/task/getAllTasks")
//                .then()
//                .log().all() // This will show you if you are getting a 500 or 403 error
//                .extract().response();
//    }
//
//    @Test(priority = 1)
//    public void createTaskWithChange() {
//        // ✅ Uses Lombok constructor
//        TaskTrackerPojo inputTask = new TaskTrackerPojo("dev");
//
//        // ✅ ApiClient + Lombok POJO deserialization
//        TaskTrackerPojo response = apiClient.request("POST", "/addTask",
//                null, null, inputTask, TaskTrackerPojo.class, 201);
//
//        createdTaskId = response.getId();  // ✅ Now works with Lombok getter
//        Assert.assertEquals(response.getTask(), "dev");
//        Assert.assertTrue(createdTaskId > 0, "ID should be generated");
//        System.out.println("✅ Created Task ID: " + createdTaskId);
//    }
//
//
//    @Test
//    public void addProduct() {
//        FakeStoreapi fakeStoreapi = new FakeStoreapi();
//        fakeStoreapi =
//                (FakeStoreapi) given()
//                        .when()
//                        .body(fakeStoreapi)
//                        .post("/products").then().statusCode(201)
//                        .log().all();
//
//    }
}
