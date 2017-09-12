import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TravelDeliveryManProblem{
	
	private static List<String> locationList = new ArrayList<String>();
	
	public static void main( String[] args )
	{
		System.out.println("Hello World");
		
		// get input : location file
		List<String> locationList = readLocFile();
		getDistance();
	}
	
	private void getDistance()
	{
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet('http://router.project-osrm.org/route/v1/');
		HttpResponse response = client.execute(request);
		
		  BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
		
		  String line = '';
		
		  while ((line = rd.readLine()) != null) {
		
		    System.out.println(line);
		
		  }
		
		 }
	
	}
	
	private static List<String> readLocFile()
	{
		List<String> locationList = new ArrayList<String>();
		try {
			
			File inputFile = new File("./data/locations.csv");

			BufferedReader inputBR = new BufferedReader(new FileReader(inputFile));

			String readLine = "";

			System.out.println("Reading file using Buffered Reader");

			while ((readLine = inputBR.readLine()) != null) {
				locationList.add(readLine);
			}
			inputBR.close();
				
			System.out.println("Done Reading location file (size="+ locationList.size()+")");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return locationList;
	}
}