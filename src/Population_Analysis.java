import java.util.Map;
import java.util.Scanner;

public class Population_Analysis {
	int[] cityPop;
	int[] percentUrban;

	public static void main(String[] args) {
		int[] cityPop = new int[50];
		double[] percentUrban = new double[50];
		int count = 0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("A city is defined as having a population of at least: ");
		int cutoff = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		City_Data cityList = new City_Data("UScities.txt");		
		State_Data statePop = new State_Data("USstates.txt");
		State_Codes codes = new State_Codes("USstates.txt");
		
		while (cityList.getPop(count) >= cutoff) {
			int code = (codes.stateCodes.get(cityList.getState(count))-1);
			cityPop[code] += cityList.getPop(count);
			
			count++;
		}
		
		System.out.print("\n\n");
		for (int i = 0; i < 50; i++) {
			System.out.println(statePop.getName(i)+":");
			System.out.printf("     City population: %,d\n", cityPop[i]);
			System.out.printf("     Total population: %,d\n", statePop.getPop(i));
			percentUrban[i] = ((((double)cityPop[i]) / ((double)statePop.getPop(i)))*100);
		}
		
		System.out.print("\n\nPercentage of Population in Cities\n");
		for (int j = 0; j < 50; j++) {
			System.out.printf("   %s: %.2f%%\n", statePop.getName(j), percentUrban[j]);
		}
		
		System.out.print("\n\nRanked List:\n");
		for (int k = 0; k < 50; k++) {
			double maxVal = percentUrban[0];
			int maxIndex = 0;
			for (int l = 1; l < 50; l++) {
				if (percentUrban[l] > maxVal) {
					maxVal = percentUrban[l];
					maxIndex = l;
				}
			}
			
			if (maxVal > 0) {
				System.out.printf("   %s: %.2f%%\n", statePop.getName(maxIndex), percentUrban[maxIndex]);
			}
			percentUrban[maxIndex] = (-1.0);
		}
		
		
	}
}
