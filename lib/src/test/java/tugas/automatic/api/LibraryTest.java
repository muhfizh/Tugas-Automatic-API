package tugas.automatic.api;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;


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
}
