
/*The hash table will be created 
 * from Countries5.csv.  Use the following class
 *  definition for a node in the table 
*@author<Cristian Cedeno>
*@version<12/6/2019>
*/
public class HashTable {
	
	/*This Node clas will create the Nodes objects with the a reference to the nextNode if it's not 
	 * emppty. Also, it will display the node with the node's name and 
	 * Gdp per capital. 
	*@author<Cristian Cedeno>
	*@version<12/6/2019>
	*/
	private class Node{
		String name;
		double gdpPerCapita;
		Node nextNode;
		
		public Node(String name, double gdpPerCapita) {
			this.name = name;
			this.gdpPerCapita = gdpPerCapita;
		}
		
		public void printNode() {
			System.out.printf("\t%-25s%,-20.2f\n", name, gdpPerCapita);
		}
	}
	
	int freeSpace;
	int numCollision;
	
	private SortedList[] hashArray;
	private int arraySize;
	
	
	public HashTable(int size) {
		arraySize = size;
		hashArray = new SortedList[arraySize];
		
		for(int j = 0; j< arraySize; j++) {
			hashArray[j] = new SortedList();
		}
	}
	
	
	/*this method prints to the monitor the current linked list of Stack. it does not have any parameteres, 
	 * and it does not have any return value 
	 */
	public void displayTable() {
		for(int i = 0; i<arraySize; i++) {
			
			
			System.out.print(i + ". ");
			hashArray[i].displayList();
			
		}
	}
	
	public int hashFunc(String name) {
		int theSum = 0;
		int index = 0;
		
		char[] arrayChar = name.toCharArray();
		
		for(int j = 0; j< name.length(); j++) {
			
			int theChar = arrayChar[j];
			
			theSum = theSum + theChar;
		}
		
		index = theSum % 311;
		return index;
	}
	

	/*this method inserts an object of Country type to the single linket stack  
	  *@param name a reference to an object of Country type
	  *@param gdpPerCapital reference to the gdp per capital value
	  */
	public void insert(String name, double gdpPerCapital) {
		Node newNode = new Node(name, gdpPerCapital);
		int hashVal = hashFunc(name);
		hashArray[hashVal].insertLast(newNode);
	}
	
	/*this delete mehtod deletes a node on the tree according to the 
	 * giving name and it will rearange the tree's nodes if necessary.
	 * @param name has the string value of the node's name
	 **/
	public void delete(String name){
		int hashVal = hashFunc(name);
		hashArray[hashVal].delete(name);
		System.out.println(name + " has been deleted from the hash table!");
		
	}
	
	
	/*this find method searches in the tree for a country according to 
	 * the giving name value, and when it's found ,it returns the GDP 
	 * per capital, and when it's not it returns a negative one 
	 *@param name the string value of name 
	 **/
	public double find(String name) {
		int hashVal = hashFunc(name);
		Node wasFound = hashArray[hashVal].find(name);
		
		if(wasFound == null) {
			System.out.println(name + " is not found");
			return -1;
		}else {
			System.out.println(wasFound.name + " is found with a GDP per capital of: " + wasFound.gdpPerCapita);
			return wasFound.gdpPerCapita;
		}
	}
	
	 public void printFreeAndCollisions() {
		 for(int i = 0; i < 311; i++) {
			 if(hashArray[i].isEmpty() == true) {
				 freeSpace++;
			 }
			 
			 
			 if(hashArray[i].isEmpty() != true){
				 Node temp = hashArray[i].first;
				 while(temp.nextNode != null) {
					 numCollision++;
					 temp=temp.nextNode;
				 }
			 }
		 }
		 
		 System.out.println("Hash table has " + freeSpace + " empty spaces and " + numCollision + " collisions");
		 
		
	 }
	
	
	 
	 /*this class creates the links for the single linked . it checks if the array 
	  * is empty with the , and isters country objects to the stack.
 * also, this class contains the method for deleting the objects and 
 * displetying the link.
	 *@author<Cristian Cedeno>
	 *@version<12/6/2019>
	 */
	class SortedList{
		private Node first;
		private Node last;
		
		/*this method creates an LinList object that will be used to set first = null
		 * , and it has no parameters
		  */
		public void SortedList() {
			first = null;
			last = null;
		}
		
		
		/*this method checkes if the link of the Stack is empty than 
		 * it returns true or false if its not and true if it is 
		  *@return a boolean value according to if its empty or not 
		  */
		public boolean isEmpty() {
			return first == null;
		}
		
		/*this method prints to the monitor the current linked list of Stack. it does not have any parameteres, 
		 * and it does not have any return value 
		 */
		public void displayList() {
			Node now = first;
			
			if(now == null) {
				System.out.println("\tEmpty");
			}
			
			while(now != null) {
				now.printNode();
				now = now.nextNode;
			}
			
			
			System.out.println("");
		}
		
		/*this method inserts an object of Country type to the single linket stack  
		  *@param cObject a reference to an object of Country type
		  */
		public void insertFirst(Node newNode) {
			//Node newLink = new Node(newNode);
			
			if(isEmpty() ) {
				last = newNode;
			}else {
			
			
			newNode.nextNode = first;
			first = newNode;
			}
			
		}
		
		public void insertLast(Node node) {
			//Node newLink = new Node(node);
			
			if(isEmpty()) {
				first = node;
			}else {
				last.nextNode = node;
				
			}
			
			last = node;
		}
		
		/*this find method searches in the tree for a country according to 
		 * the giving name value, and when it's found ,it returns the GDP 
		 * per capital, and when it's not it returns a negative one 
		 *@param name the string value of name 
		 **/
		public Node find(String name) {
			Node now = first;
			
			while(now != null) {
				if(now.name.compareTo(name)==0) {
					return now;
				}
				
				now = now.nextNode;
			
			}
			
			return null;
		}
		
		/*this delete mehtod deletes a node on the tree according to the 
		 * giving name and it will rearange the tree's nodes if necessary.
		 * @param name has the string value of the node's name
		 **/
		public void delete(String name) {
			Node before = null;
			Node now = first;
			
			while(now != null && name.compareTo(now.name) != 0) {
				before = now;
				now = now.nextNode;
			}
			
			if(before == null) {
				first = first.nextNode;
			}else {
				before.nextNode = now.nextNode;
			}
		}
	
		
	}
}
