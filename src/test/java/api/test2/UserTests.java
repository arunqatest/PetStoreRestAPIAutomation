package api.test2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userpayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		faker = new Faker();
		userpayload = new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setUsername(faker.name().username());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setPassword(faker.internet().password(5, 10));
		
		
		//log:
		logger = LogManager.getLogger(this.getClass());
		
		logger.debug("debugging...");
	}
	
	@Test(priority =1)
	public void testPostUser() {
		
		logger.info("***Creating User****");
		Response response = UserEndPoints.createUser(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);	
		
		logger.info("***User is Created****");
		
	}
	
	@Test(priority =2)
	public void testGetUser() {
		Response response = UserEndPoints.getUser(this.userpayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=3)
	public void testUpdateUser() {
		
		//update the user details
		
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		
		Response response = UserEndPoints.updateUser(this.userpayload.getUsername(), userpayload);
		response.then().log().body();
		//response.then().log().body().statusCode(200);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//checking data after update
		
		Response responseAfterUpdate = UserEndPoints.getUser(this.userpayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}
	
	
	@Test(priority=4)
	public void testDeleteUser() {
		
		Response response = UserEndPoints.deleteUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}