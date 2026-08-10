package api.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setUp()
	{
		
		faker = new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		//logs
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("*****Creating User*******");
		Response response=UserEndpoints.createUsers(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********User is Created**********");
	}
	
	@Test(priority=2)
	public void testUserByName()
	{
		logger.info("**********Reading User info**********");
		Response response=UserEndpoints.readUsers(this.userPayload.getUsername());
		response.then().log().all();
		response.statusCode();
		Assert.assertEquals(response.statusCode(),200);
		logger.info("**********User info is displayed**********");
	
	}
	
	
	@Test(priority=3)
	public void testUpdateUserByName() 
	{
		logger.info("**********Updating User**********");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		
		
		Response response=UserEndpoints.updateUsers(this.userPayload.getUsername(),userPayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********User is updated**********");
		
		//checking data after update
		
		Response responseAfterupdate=UserEndpoints.readUsers(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterupdate.statusCode(),200);
		
	}
	@Test(priority=4)
	public void testDeleteUserByName()
	{	
		logger.info("**********Deleting User**********");
		Response response=UserEndpoints.deleteUsers(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("**********User is Deleted**********");
	
	}
	
}
