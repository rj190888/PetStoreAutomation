package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.utilities.DataProviders;
import io.restassured.response.Response;
import api.endpoints.UserEndPoints;
import api.payload.User;

public class DataDrivenTest {
@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	
public void testPostUser(String UserId,String userName,String fname,String lname,String useremail,String pwd,String ph)
	{
	User userPayload=new User();
	userPayload.setId(Integer.parseInt(UserId));
	 userPayload.setUsername(userName);
	 userPayload.setFirstname(fname);
	 userPayload.setLastname(lname);
	 userPayload.setEmail(useremail);
	 userPayload.setPassword(pwd);
	 userPayload.setPhoneno(ph);
	 
	 Response response=UserEndPoints.CreateUser(userPayload); //createUser() will give  some response so we store response  in variable
		
		Assert.assertEquals(response.getStatusCode(),200);
	
	}
@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
public void testDeleteUserByName(String userName)
{
	 Response response=UserEndPoints.DeleteUser(userName);
		
		Assert.assertEquals(response.getStatusCode(),200);
}
}
