import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_get_request {

	@Test
	void getweatherdetails() {
		// specifying base URI
		RestAssured.baseURI = "https://reqres.in/api/users";

		// request object
		RequestSpecification httprequest = RestAssured.given();

		// Response Object
		Response response = httprequest.request(Method.GET, "?page=1");

		// print response in consoule window
		String responseBody = response.getBody().asString();
		System.out.println("esponse body is= " + responseBody);

		// Status code validation
		int statuscode = response.getStatusCode();
		System.out.println("Status code is= " + statuscode);
		Assert.assertEquals(statuscode, 200);

	}
}
