package pet.store.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import pet.store.endpoints.UserEndpoints;
import pet.store.payload.User;
import pet.store.utilities.DataProviders;

public class DataDrivenTest {
	
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userId, String userName, String firstName, String lastName, String userEmail,
			String password, String phoneNUmber) {
		
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(userEmail);
		userPayload.setPassword(password);
		userPayload.setPhone(phoneNUmber);
		
		Response response=UserEndpoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	@Test(priority = 2, dataProvider = "DeleteUser", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String userName) {
		Response response=UserEndpoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
