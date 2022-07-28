import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC003_get_request {
	
	
	@Test
	public void headersvalidating() {
		//Specifying base
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Rsponse object
		Response response = httprequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		String responsebody = response.getBody().asString();
		System.out.println("response body ="+responsebody);
		
		int code = response.getStatusCode();
		System.out.println("response code "+code);
		Assert.assertEquals(code, 200);
		
		String contenttype = response.header("Content-Type");
		System.out.println("response content- type= "+contenttype);
		Assert.assertEquals(contenttype, "application/xml; charset=UTF-8");
		
		
		
		
	}

}
