import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class State_Codes {
	Map<String, Integer> stateCodes;
	
	public State_Codes(String filename) {
		Map<String, Integer> stateCodes = new HashMap<String, Integer>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
	        String line = br.readLine();
	        line = br.readLine(); // Skip table headers in first line
	        while (line != null) {
	        	String[] data = line.split(",");
	        	String state = data[2];
	        	int code = Integer.parseInt(data[1]);
	        	
	        	stateCodes.put(state, code);
	        	line = br.readLine();
	        }
	        br.close();
	        
	        this.stateCodes = stateCodes;
		} catch (IOException e) {
			System.out.println("Error in State_Codes constructor");
		}

	}

}
