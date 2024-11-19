package pet.store.endpoints;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
//Step:2
import pet.store.payload.User;




//Used to perform CRUD operations
//Implement the end points
public class UserEndpoints {

	public static Response createUser(User payload) {

		Response response = given().contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(payload)
				.when()
				.post(Routes.post_url);
		return response;
	}
	
	public static Response getUser(String userName) {
		
		Response response=given().pathParam("userName", userName)
		
		.when().get(Routes.get_url);
		
		return response;
	}
	
	public static Response updateUser(String userName,User payload) {
		
		Response response=given().pathParam("userName", userName).contentType(ContentType.JSON)
		.accept(ContentType.JSON).body(payload)
		.when().put(Routes.update_url);
		
		return response;
	}
	
	public static Response deleteUser(String userName) {
		
		Response response=given().pathParam("userName", userName)
		
		.when().delete(Routes.delete_url);
		
		return response;
	}

}
