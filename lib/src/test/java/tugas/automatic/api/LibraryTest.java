package tugas.automatic.api;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;


import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class LibraryTest {

    //positive test
    @Test
    public void createNewUserPos(){
        RestAssured.baseURI="https://reqres.in/";
        String name = "jayjay";
        String job = "Student";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("job", job);
        given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(jsonObject.toString())
                .post("api/users")
                .then()
                .assertThat().statusCode(201)
                .assertThat().body("name", Matchers.equalTo(name))
                .assertThat().body("job", Matchers.equalTo(job))
                .assertThat().body("$", Matchers.hasKey("id"))
                .assertThat().body("$", Matchers.hasKey("createdAt"));
    }

    //negative test
    @Test
    public void createNewUserneg(){
        RestAssured.baseURI="https://reqres.in/";
        String name = "jayjay";
        String job = "Student";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("job", job);
        given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(jsonObject.toString())
                .post("api/users")
                .then()
                .assertThat().statusCode(201)
                .assertThat().body("name", Matchers.equalTo("nama"))
                .assertThat().body("job", Matchers.equalTo(job))
                .assertThat().body("$", Matchers.hasKey("id"))
                .assertThat().body("$", Matchers.hasKey("createdAt"));
    }

    // Positive test
    @Test
    public void updateUserPosTest(){
        RestAssured.baseURI="https://reqres.in/";
        int userId = 2;
        String newName = "updatedUser";
        String fname = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.first_name");
        String lname = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.last_name");
        String avatar = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.avatar");
        String email = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.email");
        System.out.println("name before = "+fname);

        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id", userId);
        bodyMap.put("email", email);
        bodyMap.put("first_name", newName);
        bodyMap.put("last_name", lname);
        bodyMap.put("avatar", avatar);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("Content-Type", "application/json")
                .body(jsonObject.toString()) //convert json to string format
                .put("api/users/"+userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName));
    }

    //Negative test
    @Test
    public void updateUserNegTest(){
        RestAssured.baseURI="https://reqres.in/";
        int userId = 2;
        String newName = "updatedUser";
        String fname = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.first_name");
        String lname = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.last_name");
        String avatar = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.avatar");
        String email = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.email");
        System.out.println("name before = "+fname);

        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id", userId);
        bodyMap.put("email", email);
        bodyMap.put("first_name", newName);
        bodyMap.put("last_name", lname);
        bodyMap.put("avatar", avatar);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("Content-Type", "application/json")
                .body(jsonObject.toString()) //convert json to string format
                .put("api/users/"+userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(fname));
    }

    //positive test
    @Test
    public void testDeleteUserPos(){
        RestAssured.baseURI="https://reqres.in/";
        //Data to delete
        int userToDelete = 4;
        given().log().all()
                .when().delete("api/users/" +userToDelete)
                .then()
                .log().all()
                .assertThat().statusCode(204);
    }

    //positive test
    @Test
    public void testPatchUserpos(){
        RestAssured.baseURI="https://reqres.in/";
        int userId = 3;
        String newName = "updatedUser";
        String fname = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.first_name");
        System.out.println("name before = "+fname);

        HashMap<String, String> bodyMap = new HashMap<>();
        bodyMap.put("first_name", newName);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("Content-Type", "application/json")
                .body(jsonObject.toString()) //convert json to string format
                .put("api/users/"+userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName));
    }

    //Negative test
    @Test
    public void testPatchUserNeg(){
        RestAssured.baseURI="https://reqres.in/";
        int userId = 3;
        String newName = "updatedUser";
        String fname = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.first_name");
        System.out.println("name before = "+fname);

        HashMap<String, String> bodyMap = new HashMap<>();
        bodyMap.put("first_name", newName);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("Content-Type", "application/json")
                .body(jsonObject.toString()) //convert json to string format
                .put("api/users/"+userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(fname));
    }
}
