package api.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData()
	{
		Faker faker=new Faker();
		
		//pass & setup the data to payload pojo class
		
		 userPayload = new User();
		 userPayload.setId(faker.idNumber().hashCode());
		 userPayload.setUsername(faker.name().username());
		 userPayload.setFirstname(faker.name().firstName());
		 userPayload.setLastname(faker.name().lastName());
		 userPayload.setEmail(faker.internet().safeEmailAddress());
		 userPayload.setPassword(faker.internet().password(5, 10));
		 userPayload.setPhoneno(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		Response response=UserEndPoints.CreateUser(userPayload); //createUser() will give  some response so we store response  in variable
		response.then().log().all(); // print all the response
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		Response response=UserEndPoints.ReadUser(this.userPayload.getUsername());
		response.then().log().all(); // print all the response
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		Faker faker=new Faker();
		
		//Update Data Using Payload
		//re-generating values
		
		
		 userPayload.setFirstname(faker.name().firstName());
		 userPayload.setLastname(faker.name().lastName());
		 userPayload.setEmail(faker.internet().safeEmailAddress());
		 
		 Response response=UserEndPoints.UpdateUser(this.userPayload.getUsername(),userPayload); //here userpayload is updated payload
			response.then().log().body(); // print all the response
			Assert.assertEquals(response.getStatusCode(),200);
			
			//Checking Data After Update
			
			Response response1=UserEndPoints.ReadUser(this.userPayload.getUsername());
			response1.then().log().all(); // print all the response
			Assert.assertEquals(response1.getStatusCode(),200);
	}
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		Response response=UserEndPoints.DeleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
}
