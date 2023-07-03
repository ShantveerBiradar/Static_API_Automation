package Test_Classes;
import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;

import Common_API_Methods.API_Methods_Post;
import Common_API_Methods.Common_Utility_Method;
import RequestRepository.Post_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Post_TC1 {
	  
	public static void extractor () throws IOException {
		for(int i=0; i<=5; i++) {
		int statusCode = 
	API_Methods_Post.ResponsestatusCode(Post_Req_Repository.BaseURI(), Post_Req_Repository.Post_Resource(), Post_Req_Repository.Post_Req_TC1());
	System.out.println(statusCode);
	if(statusCode==201) {
	String ResponseBody =
	API_Methods_Post.ResponseBody(Post_Req_Repository.BaseURI(), Post_Req_Repository.Post_Resource(), Post_Req_Repository.Post_Req_TC1());
	System.out.println(ResponseBody);
	String RequestBody = Post_Req_Repository.Post_Req_TC1();
	Common_Utility_Method.EvidenceCreater("Post_TC1", RequestBody, ResponseBody, statusCode);
	Validator(RequestBody, ResponseBody);  
	break;
	}
	else{       
		System.out.println("Statuscode is failed : " + statusCode);
	}}}
	public static void Validator(String RequestBody,String ResponseBody)
	{
		JsonPath JspRequest = new JsonPath(RequestBody);
		String Req_name = JspRequest.getString("name");
		String Req_job = JspRequest.getString("job");
		LocalDateTime currentdate = LocalDateTime.now();
		String expecteddate=currentdate.toString().substring(0, 11);
		//System.out.println(ResponseBody);
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		String Res_createdAt = JspResponse.getString("createdAt");
		Res_createdAt = Res_createdAt.substring(0,11);	
		Assert.assertEquals(Res_name, Req_name);
		Assert.assertEquals(Res_job, Req_job);
		Assert.assertEquals(Res_createdAt, expecteddate);
	}}
    