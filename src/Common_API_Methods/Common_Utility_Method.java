package Common_API_Methods;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Common_Utility_Method {

	public static void EvidenceCreater(String Filename,String RequestBody, String ResponseBody, int StatusCode) throws IOException {
		File TextFile = new File ("F:\\MS SQUARE\\ASSIGNMENT\\RestAssureed Assignment\\Evidence\\"+Filename+".txt");
		System.out.println("New blank text file of name : " + TextFile.getName());
		
		FileWriter dataWrite = new FileWriter(TextFile);
		
		dataWrite.write("Request Body is : " +RequestBody +"\n\n");
		dataWrite.write ("Status code is : "+ StatusCode + "\n\n");
		dataWrite.write ("Response Body is : " + ResponseBody);
		
		dataWrite.close();
		System.out.println("Request body and response body written in textfile : " + TextFile.getName());	
	}
}
