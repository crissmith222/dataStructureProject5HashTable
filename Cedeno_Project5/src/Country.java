
/*
*This class creates Country *objects with with
*the fields: name, code, capital, population, 
*GDP, GDPPerCapital.And, It has methods 
*for getting and setting all the fields
*@author<Cristian Cedeno>
*@version<09/27/2019>
*/
class Country{
  String name;
  String code;
  String capital;
  double population;
  double GDP;
  double GDPPerCapital;
  int happinessRank;
  
  public Country next;
  public Country previous;
  
  /*creates a County Object with 6 
  *arguments, the name is the name of the object's 
  *country. The Code is the abreviation for the 
  *country.The population and capital is used 
  *for finding the DGP per capital. And, The happinessRank 
  *is a int number used to rank the happiness in the country.
  *@param name the name of the object's counrty
  *@param code the second field scanned from the Countries2 file
  *@param capital the name of the capital relative to an object
  *@param population the amount of peopole in a specific country
  *@param GDP the value of economic activity relative to the *object's country
  *@param happinessRank an integer value used to rank happiness
  *@return an object for the Country class
  */
  public Country(String name, String code, String capital, double population, double GDP, int happinessRank){
    this.name = name;
    this.code = code;
    this.capital = capital;
    this.population = population;
    this.GDP = GDP;
    this.happinessRank = happinessRank;
  }


  /*this method sets the value of the of the field name to the value passed with the name parameter
  *@param name the name of the country *scanned in the Countries2 file
  */
  public void setName(String name){
    this.name = name;
  }

  /*this method sets the value of the field private field code to the value passed with the code parameter
  *@param code the 2nd value scanned in the Countries2 file
  */
  public void setCode(String code){
    this.code = code;
  }

  /*this method sets the value of the of the private field capital to the value paassed with the capital parameter
  *@param capital the name of the capital scnned in the Countries2 file
  */
  public void setCapital(String capital){
    this.capital = capital;
  }

  /*this method sets the value of the private field population to the value paassed with the population parameter
  *@param populaiton the name of the capital scnned in the Countries2 file
  */
  public void setPopulation(int population){
    this.population = population;
  }

  
  
  public void setGDP(int GDP){
    this.GDP = GDP;
  }

  /*this method sets the value of the private field HappinessRank to the value paassed with the HappinessRank parameter
  *@param HappinessRank the value of the country's  happiness rank scanned from the countries2 file
  */
  public void setHappinessRank(int happinessRank){
    this.happinessRank = happinessRank;
  }


  /*this method returns the value of the private field Name from a specific object
  @return the value of Name
  */
  public String getName(){
    return name;
  }

  /*this method returns the value of the private field code from a specific object
  @return the value of code
  */
  public String getCode(){
    return code;
  }

  /*this method returns the value of the private field capital from a specific object
  @return the value of capital
  */
  public String getCapital(){
    return capital;
  }

  /*this method returns the value of the private field population from a specific object
  @return the value of population
  */
  public double getPopulation(){
    return population;
  }

  /*this method returns the value of the private field GDP from a specific object
  @return the value of GDP
  */
  public double getGDP(){
    return GDP;
  }

  /*this method returns the value of the private field happiness from a specific object
  @return the value of happiness
  */
  public int getHappinessRank(){
    return happinessRank;
  }

  /*this method returns the the GDP per capital by dividing the GDP to population
  @return the value of GDP per capital
  */
  public double getGDPPerCapital(){
    GDPPerCapital = GDP / population;
    return GDPPerCapital;
  }

  /*This method prints al the fields of an specific object in an especified format
  */
  public void printObject(){
    System.out.printf("%-35s %-20s %-20s %-15.2f %-20.2f %d\n", name, code, capital, population, GDP, happinessRank);
  }
  

}
