package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// created for perform Create, Read, Update and Delete requests to the User API

public class UserEndPoints2 {
	//method created for getting URL's from properties file
static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");//load the properties file
		return routes;
	}
	
	public static Response CreateUser(User payload)
		{
		String post_url=getURL().getString("post_url");
		
		Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(post_url);
		
		return res;
		
	}
	public static Response ReadUser(String userName)
	{
		
		String get_url=getURL().getString("get_url"); //store get_url from properties into the get_url variable 
		Response res=given()
				.pathParam("username", userName)
		
		.when()
		.get(get_url);
		
		return res;
		
	}
	public static Response UpdateUser(String userName, User payload)
	{
		String update_url=getURL().getString("update_url");
		Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		
		.when()
		.put(update_url);
		
		return res;
		
	}
	public static Response DeleteUser(String userName)
	{
		String delete_url=getURL().getString("delete_url");
		Response res=given()
				.pathParam("username", userName)
		
		.when()
		.delete(delete_url);
		
		return res;
		
	}
}
