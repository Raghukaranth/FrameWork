package tests.myApp;

import base.BaseAPIDevTest;
import interactions.RestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.Task;

import java.util.Optional;

public class APITest extends BaseAPIDevTest {
    @Test
    public void signUpResponse() {
        String newUser = """
                {
                    "name": "Raghavendra"
                }
                """;
        Response response = RestUtils.postRequest("/loginUser/signup", newUser);
        response.then ().statusCode(201);
    }

    @Test
    public void testGetResponse() {
        Response respose = RestUtils.getRequest("/loginUser/login/" + 1);
        respose.then().statusCode(200);
    }

    @Test
    public void taskCreatorTest() {
        String[] arr = {"dev", "test", "deploy"};
        for (String taskName : arr) {
            Task task = new Task();    // Create new Task object inside loop
            task.setTask(taskName);
            Response response = RestUtils.postRequest("task/addTask", task);
            response.then().statusCode(201);
            System.out.println("Created task: " + taskName);
        }
    }

    @Test
    public void getAllTasks() {
        Task task = new Task();

        Response response = RestUtils.getRequest("/task/getAllTasks");
        response.then().statusCode(200);
        System.out.println(response.getBody().asString());

        JsonPath jsonPath = response.jsonPath();
        Object idValue = jsonPath.get("id");
        Object taskValue = jsonPath.get("task");
        System.out.println(idValue);
        System.out.println(taskValue);
    }

    @Test
    public void deleteATask() {
        Response response = RestUtils.deleteRequest("/task/deleteTaskById/{id}", 1);
        response.then().statusCode(200);
    }
}
