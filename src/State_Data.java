import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class State_Data {
	int[] stateData;
	String[] stateNames;
	
	public State_Data(String filename) {
		int[] stateData = new int[50];
		String[] stateNames = new String[50];
		int count = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
	        String line = br.readLine();
	        line = br.readLine(); // Skip table headers in first line
	        while (line != null) {
	        	String[] data = line.split(",");
	        	int pop = Integer.parseInt(data[3]);
	        	String name = data[2];
	        	
	        	stateData[count] = pop;
	        	stateNames[count] = name;
	        	count++;
	        	line = br.readLine();
	        }
	        br.close();
	        
	        this.stateData = stateData;
	        this.stateNames = stateNames;
		} catch (IOException e) {
			System.out.println("Error in State_Codes constructor");
		}

	}
	
	public String getName(int index) {
		return stateNames[index];
	}
	
	public int getPop(int index) {
		return stateData[index];
	}
}
