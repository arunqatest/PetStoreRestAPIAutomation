package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

//create userendpoints.java --> contains CRUD (create retrieve update delete) method implementation

public class UserEndPoints {

	public static Response createUser(User payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)

				.when()
				.post(routes.post_url);

		return response;

	}
	
	public static Response getUser(String userName) {

		Response response = given()
				.pathParam("username", userName)

				.when()
				.get(routes.get_url);

		return response;

	}
	
	
	public static Response updateUser(String userName, User payload  ) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)

				.when()
				.put(routes.update_url);

		return response;

	}
	
	
	public static Response deleteUser(String userName) {

		Response response = given()
				.pathParam("username", userName)

				.when()
				.delete(routes.delete_url);

		return response;

	}
	

}
