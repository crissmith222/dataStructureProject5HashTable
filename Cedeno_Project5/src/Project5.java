import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
*the Projec5 reads from the Countries5.cvs file of countries and create a hash table
*it deletes Austrialia, Tunisia, Norway, and other countries. It searches for for some countries by name, and 
*then it displays the table again. At the end, it displays the number of free spaces and collisions 
*@author<Cristian Cedeno>
*@version<12/6/2019>
*/
public class Project5 {
	public static void main(String[] args){

		HashTable h = new HashTable(311);
		
	    double gdpPerCapital = 0;
	    String scannedName = "";
	    String scannedCode = "";
	    String scannedCapital = "";
	    double scannedPopulation = 0;
	    double scannedGDP = 0;
	    int scannedHappinessRank = 0;
	    int count = 0;
	    int line = 0;
	    

	    String[] fields = new String[6];


	    File file = new File("Countries5.csv");

	    

	    try{
	      Scanner input = new Scanner(file);
	      input.useDelimiter( ",|\n" );

	      for(int i=0; i<6; i++){
	        fields[i] = input.next();
	      }

	      
	      while(input.hasNext()){
	        
	        
	        scannedName = input.next();
	       
	        scannedCode = input.next();
	        
	        scannedCapital = input.next();
	        scannedPopulation = input.nextDouble();
	        scannedGDP = input.nextDouble();
	        scannedHappinessRank = Integer.parseInt(input.next().trim());
	        gdpPerCapital = scannedGDP / scannedPopulation;

	        
	        h.insert(scannedName, gdpPerCapital);
	        
	        count++;
	         
	      }


	    }catch(IOException exception){
	    	
	      System.out.printf("EXCEPTION");
	    }
	    
	    h.displayTable();
	    
	    h.delete("Australia");
	    h.delete("Tunisia");
	    h.delete("Norway");
	    
	    h.find("Sri Lanka");
	    h.find("North Cyprus");
	    h.find("Tunisia");
	    
	    h.delete("Malawi");
	    h.delete("Germany");
	    h.delete("Ireland");
	    h.delete("Greece");
	    h.delete("Bolivia");
	    
	    h.displayTable();
	    
	    h.printFreeAndCollisions();
	    
	    
	    
	}
}
