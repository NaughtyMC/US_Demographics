import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class City_Data {
	String[][] cityData;
	
	public City_Data(String filename) {
		String[][] cityData = new String[(countLines(filename)-1)][3];
		int cityCount = 0;
	
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
	        String line = br.readLine();
	        line = br.readLine(); // Skip table headers in first line
	        while (line != null) {
	        	String[] data = line.split(",");
	        	String city = data[7];
	        	String state = data[8];
	        	String pop = data[9];
	        	cityData[cityCount][0] = city.substring(1, (city.length()-5));
	        	cityData[cityCount][1] = state.substring(1, (state.length()-1));
	        	cityData[cityCount][2] = pop;
	        	cityCount++;
	        	line = br.readLine();
	        }
	        
	        this.cityData = cityData;
	        br.close();
		} catch (IOException e) {
			System.out.println("Error in City_Data constructor");
		}
		
		/*for (int i = 0; i < cityCount; i++){
			System.out.println("cityData["+i+"][0]: "+cityData[i][0]+"     "
					+ "cityData["+i+"][1]: "+cityData[i][1]+"     "
					+ "cityData["+i+"][2]: "+cityData[i][2]);
		}*/
		
	}
	
	public String getCity(int index) {
		return cityData[index][0];
	}
	
	public String getState(int index) {
		return cityData[index][1];
	}
	
	public int getPop(int index) {
		return Integer.parseInt(cityData[index][2]);
	}

	int countLines(String file) {
		int numLines = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
	        String line = br.readLine();
	        while (line != null) {
	        	numLines++;
	        	line = br.readLine();
	        }
	        
	        br.close();
		} catch (IOException e) {
			System.out.println("Error in method Read_Data.countLines");
		}
		
		return numLines;
	}

}
