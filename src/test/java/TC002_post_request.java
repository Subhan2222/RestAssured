
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_post_request {

	@Test
	void postrequest() {
		// Specifying base URI
		RestAssured.baseURI = "https://reqres.in/api";

		// Request Object
		RequestSpecification hhtprequest = RestAssured.given();

		// request payload sending alon with the post request
		JSONObject requestpara = new JSONObject();
		requestpara.put("name", "morpheus");
		requestpara.put("job", "leader");

		hhtprequest.header("Content-Type", "application/json");
		hhtprequest.body(requestpara.toJSONString());

		// response object
		Response response = hhtprequest.request(Method.POST, "/users");

		// print body in consoul woindow
		String body = response.getBody().asString();
		System.out.println("response body= " + body);

		// check the status code
		int code = response.getStatusCode();
		System.out.println("Status code is=" + code);
		Assert.assertEquals(code, 201);

	}
}
