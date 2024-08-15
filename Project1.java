import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;


/** 
 * COP 3530: Project 1 – Array Searches and Sorts  
 * <p> 
 * Project1 starts by asking for a file input, in this case it is Countries1.csv file. If given a file that does not exist it will terminate.
 * After the file is accepted it parses the information from the file using commas and \n as delimiters. 
 * Once it has parsed two strings and five doubles, it will create a Country object and add it to an array of Country objects(cArray[])
 * Once the array of Country objects is created, it will repeatedly print a menu correlating to integers.
 * Options 1-6 are actions to be performed while 7 allows the user to quit and will terminate the program. 
 * <p>
 * More details are given by the static methods documented later. It is important to note that menu option 1 calls method option1(), 
 * menu option 2 calls method option2(), etc. 
 * 
 * @author Brandon Rocha
 * @version September 15, 2022 
 */ 
public class Project1 {
	
	public static void main(String[] args) {
		Country example = new Country();
		final int cAsize = 145;
		Country cArray[] = new Country[cAsize]; //create array of country objects
		int i = 0;
		
		cArray[0] = example; //insert country into array index 0
		
		Scanner openFl = new Scanner(System.in);
		System.out.print("Enter filename: ");
		String filename = openFl.next();

		
		Scanner inFile = null;
		try {
			inFile = new Scanner(new File(filename));
		}
		catch(FileNotFoundException e ){
			System.out.println("Unable to open the file: "+filename);
			System.exit(1);
		}
		inFile.useDelimiter(",|\n");
		//get through the first line
		inFile.next();
		inFile.next();
		inFile.next();
		inFile.next();
		inFile.next();
		inFile.next();
		inFile.next();
		
		while(inFile.hasNext()) {
			example.setName(inFile.next());
			example.setCapitol(inFile.next());
			example.setPop(inFile.nextDouble());
			example.setGdp(inFile.nextDouble());
			example.setCases(inFile.nextLong());
			example.setDeaths(inFile.nextLong());
			example.setArea(inFile.nextLong());
			
			
			cArray[i] = new Country(example.getName(), example.getCapitol(), example.getPop(),example.getGdp(),example.getCases(), example.getDeaths(), example.getArea());
			++i;
		} //close while loop
		
		Scanner menuOption = new Scanner(System.in);
		String input = "0";
		boolean isNotABC = true ;
		
		while(!input.equals("7")) {
			Project1.printMenu();
			input = menuOption.next();
			System.out.println();
			if (input.equals("1")) {
				Project1.option1(cAsize, cArray);
			}
			else if (input.equals("2")) {
				Project1.option2(cAsize, cArray);
				isNotABC = false;
			}
			else if (input.equals("3")) {
				Project1.option3(cAsize, cArray);
				isNotABC = true;
			}
			else if (input.equals("4")) {
				Project1.option4(cAsize, cArray);
				isNotABC = true;
			}
			else if (input.equals("5")) {
				Project1.option5(cAsize, cArray, isNotABC);
			}
			else if(input.equals("6")) {
				Project1.option6(cAsize, cArray);
			}
			else if (input.equals("7")){
				break;
			}
			else {
				System.out.println("That is not a valid menu option, please enter number between 1 and 6 or 7 to quit.");
			}
			System.out.println();
		}//end of while loop
		System.out.println("Goodbye!");
		openFl.close();
		menuOption.close();
		inFile.close();
	}//end of main
	/**
	 * This method is called to print a menu, each option allowing the user to sort or search through the array of Country objects
	 * created in the Project1 class (cArray[]).
	 * 
	 */
	public static void printMenu () {
		System.out.print("1) Print report of all countries \r\n"
				+ "2) Sort countries alphabetically (alphabetically using Insertion sort) \r\n"
				+ "3) Sort by COVID case fatality rate (CFR) (ascendingly using Selection sort): \r\n"
				+ "4) Sort by GDP per capita (ascendingly using Bubble sort)  \r\n"
				+ "5) Find and print a country for a given name (using binary search if the data is \r\n"
				+ "sorted by name; sequential search, if not) \r\n"
				+ "6) Print Kendall’s t correlation matrix in the following format  \r\n"
				+ "7) Quit \r\n"
				+ "Enter a number to perform its corresponding action or 7 to quit: ");
	} //end of printMenu
	
	/**
	 * This method utilizes a for loop to print the array of Country objects in the order that they were inserted.
	 * 
	 * 
	 * 
	 * @param cAsize integer that describes the size of cArray[] (an array of Country objects)
	 * @param cArray array of Country objects created in Project1 class
	 */
	public static void option1 (int cAsize, Country cArray[]) { 
		int i = 0;
		System.out.printf("%-35s %-18s %9s %10s %16s %15s %12s\n", "Name", "Capitol", "GDPPC", "CFR", "CaseRate", "DeathRate", "PopDensity");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		for(i = 0; i < cAsize; ++i) {
			System.out.printf("%-35s %-18s %12.3f %12.6f %12.3f %12.3f %12.3f\n", cArray[i].getName(), 
					cArray[i].getCapitol(), 
					cArray[i].getGcapita(),
					cArray[i].getFatal(),
					cArray[i].getCaseRate(), 
					cArray[i].getDeathRate(),
					cArray[i].getPopDens());
		}
	}//end option1
	
	/**
	 * Method that uses insertion sorting to sort an array of Country objects alphabetically from A-Z.
	 * 
	 * 
	 * 
	 * @param cAsize integer that describes the size of cArray[] (an array of Country objects)
	 * @param cArray array of Country objects created in Project1 class
	 */
	public static void option2(int cAsize, Country cArray[]) { 
		int in, out;
		
		for(out = 1; out < cAsize; out++) {
			Country temp = cArray[out];
			in = out;
			
			while(in > 0 && cArray[in-1].getName().compareTo(temp.getName()) > 0 ) {
				cArray[in] = cArray[in-1];
				--in;
			}//end while loop
			cArray[in] = temp;
		}//end for loop
		System.out.println("Countries now sorted alphabetically from A-Z.");
	}//end of option2
	
	
	/**
	 * Method that uses selection sorting to sort an array of Country objects (cArray[]) by Covid fatality rate in ascending order.
	 * 
	 * 
	 *  @param cAsize integer that describes the size of cArray[] (an array of Country objects)
	 * @param cArray array of Country objects created in Project1 class
	 */
	public static void option3(int cAsize, Country cArray[]) { 
		int outer, inner, lowest;
		for(outer = 0 ; outer < cAsize-1 ; outer++) {
			lowest = outer;
			for(inner = outer+1; inner < cAsize; inner++) {
				if(cArray[inner].getFatal() < cArray[lowest].getFatal()) {
					lowest = inner;
				}
			}//end of inner loop
			if(lowest != outer) {
				Country temp = cArray[lowest];
				cArray[lowest] = cArray[outer];
				cArray[outer] = temp;
			}
		}//end of outer for loop
		System.out.println("Countries now sorted by Covid fatality rate in ascending order.");
	}//end of option 3
	
	/**
	 * Method that uses bubble sort to sort an array of Country objects(cArray[]) by GDP per capita in ascending order.
	 * 
	 * 
	 * @param cAsize integer that describes the size of cArray[] (an array of Country objects)
	 * @param cArray array of Country objects created in Project1 class
	 */
	public static void option4(int cAsize, Country cArray[]) {
		int inner, outer;
		for(outer = 0; outer < cAsize -1; outer++) {
			for(inner = cAsize -1; inner > outer; inner--) {
				if(cArray[inner].getGcapita() < cArray[inner-1].getGcapita()) {
					Country temp = cArray[inner];
					cArray[inner] = cArray[inner-1];
					cArray[inner-1] = temp;
				}//end if
			}//end inner loop
		}//end of outer loop
		System.out.println("Countries now sorted by GDP per capita in ascending order.");
	}//end of option4
	
	/**
	 * Method that uses a binary search (if sorted alphabetically from A-Z) to search through an array of Country objects (cArray[])
	 * for the user defined country name.
	 * If the array is not sorted alphabetically then it will search sequentially through the array of Country objects for the 
	 * user defined country name.
	 * It discerns whether the array is sorted alphabetically by setting the boolean parameter to true or false.
	 * The search is case sensitive and must be an exact match.
	 * if a match is found it will print the country's information.
	 * Otherwise it will simply state that the nothing was able to be found using the search given.
	 * 
	 * 
	 * @param cAsize integer that describes the size of cArray[] (an array of Country objects)
	 * @param cArray array of Country objects created in Project1 class
	 * @param isNotABC boolean that tells whether cArray is sorted alphabetically(A-Z) or not
	 */
	public static void option5(int cAsize, Country cArray[], boolean isNotABC) {
		String key;
		Scanner search= new Scanner(System.in);
		System.out.print("Enter the name of the country you would like to searach for: ");
		key = search.next();
		DecimalFormat ftsix = new DecimalFormat("#.######");
		DecimalFormat ftthree = new DecimalFormat("#.###");
		
		if(isNotABC) {
			boolean gotit = false;
			for(int i = 0; i < cAsize; ++i) {
				if(cArray[i].getName().contains(key)) {
					System.out.println("Here are your results for: " + key);
					System.out.print("Name:               " + cArray[i].getName() + "\r\n"
							+ "Capitol:            " + cArray[i].getCapitol() + "\r\n"
							+ "GDPPC:              " + ftthree.format(cArray[i].getGcapita()) + " \r\n" 
							+ "CFR:                " + ftsix.format(cArray[i].getFatal()) + "\r\n"
							+ "Case Rate:          " + ftthree.format(cArray[i].getCaseRate()) + "\r\n" 
							+ "Death Rate:         " + ftthree.format(cArray[i].getDeathRate()) + "\r\n"
							+ "Population Density: " + ftthree.format(cArray[i].getPopDens()) + "\r\n");
					gotit = true;
					break;
				}
			}
			if(!gotit) {
				System.out.println("There were no results matching: " + key);
			}
		}
		if(!isNotABC) {
			int lowerBound = 0;
			int upperBound = cAsize -1;
			int mid;
			boolean found = false;
			
			while(lowerBound <= upperBound) {
				mid = (lowerBound + upperBound) /2;
				if(cArray[mid].getName().contains(key)) {
					System.out.print("Name:               " + cArray[mid].getName() + "\r\n"
							+ "Capitol:            " + cArray[mid].getCapitol() + "\r\n"
							+ "GDPPC:              " + ftthree.format(cArray[mid].getGcapita()) + " \r\n" 
							+ "CFR:                " + ftsix.format(cArray[mid].getFatal()) + "\r\n"
							+ "Case Rate:          " + ftthree.format(cArray[mid].getCaseRate()) + "\r\n" 
							+ "Death Rate:         " + ftthree.format(cArray[mid].getDeathRate()) + "\r\n"
							+ "Population Density: " + ftthree.format(cArray[mid].getPopDens()) + "\r\n");
					found = true;
					break;
				}
				else if (cArray[mid].getName().compareTo(key) < 0) {
					lowerBound = mid +1;
				}
				else {
					upperBound = mid-1;
				}	
			}
			if(!found) {
				System.out.println("There were no results matching: " + key);
			}
		}
	}//end of option5
	
	/**
	 * This method will print a Kendall's correlation table using the information from the array of Country objects.
	 * 
	 * 
	 * @param cAsize integer that describes the size of cArray[] (an array of Country objects)
	 * @param cArray array of Country objects created in Project1 class
	 */
	public static void option6(int cAsize, Country cArray[]) {

	}//end of option6
		
} //close Project1
