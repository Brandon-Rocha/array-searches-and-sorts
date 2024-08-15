
/** 
 * The class Country creates and object with seven fields: Name, Capitol, Pop, Gdp, Cases, Deaths, and Area.
 * Name and Capitol are the name of a country and its capitol. Pop is the population of the country and Gdp is the GDP of the country.
 * Cases and Deaths refer to COVID cases and deaths that happened within that country. And Area is the square kilometers of the country.
 * <p>
 * Name and Capitol are of type String while all other fields are of type double. 
* 
 * @author Brandon Rocha 
 * @version September 15, 2022
 */ 


public class Country extends Object {
	private String Name;
	private String Capitol;
	private double Pop;
	private double Gdp;
	private double Cases;
	private double Deaths;
	private double Area;
	
	/**
	 * Class constructor without specifiers creates a Country object that sets all strings to empty strings and all doubles initialized to 0.
	 * 
	 */
	Country () {
		this.Name = "";
		this.Capitol = "";
		this.Pop = 0;
		this.Gdp = 0;
		this.Cases = 0;
		this.Deaths = 0;
		this.Area = 0;
		}
	/**
	 * Constructor that specifies a String for Name and Capitol. Also specifies a double value for Pop, Gdp, Cases, Deaths, and Area.
	 * @param name sets Name
	 * @param cap sets Capitol
	 * @param pop sets Pop
	 * @param gdp sets Gdp
	 * @param cases sets Cases
	 * @param deaths sets Deaths
	 * @param area sets Area
	 */
	Country (String name, String cap, double pop, double gdp, double cases, double deaths, double area){
		this.Name = name;
		this.Capitol = cap;
		this.Pop = pop;
		this.Gdp = gdp;
		this.Cases = cases;
		this.Deaths = deaths;
		this.Area = area;
		
	}
	/**
	 * Method that allows Name to be specified 
	 * 
	 * @param namechange of type String sets Name of a Country object
	 */
	public void setName (String namechange) {
		this.Name = namechange;
		
	}
	/**
	 * Method that gets the Name of a Country object
	 * 
	 * @return  Name of a Country object of type String
	 */
	public String getName () {
		
		return this.Name;
		
	}
	
	/**
	 * Method that allows Capitol to be specified
	 * 
	 * @param capchange of type String sets Capitol of a Country object
	 */
	public void setCapitol (String capchange) {
		this.Capitol = capchange;
		
	}
	
	/**
	 * Method that gets the Capitol of a Country object
	 * 
	 * @return Capitol of Country object of type String
	 */
	public String getCapitol( ) {
		return this.Capitol;
	}
	
	/**
	 * Method that allows Pop to be specified
	 * 
	 * @param popchange of type double sets Pop of a Country object
	 */
	public void setPop (double popchange) {
		this.Pop = popchange;
	}
	
	/**
	 * Method that gets the Pop of a Country object
	 * 
	 * @return Pop of Country object of type double
	 */
	public double getPop () {
		return this.Pop;
		
	}
	
	/**
	 * Method that allows Gdp to be specified
	 * 
	 * @param gdpchange of type double sets Gdp of a Country object
	 */
	public void setGdp (double gdpchange) {
		this.Gdp = gdpchange;
	
	}
	
	/**
	 * Method that gets the Gdp of a Country object
	 * 
	 * @return Gdp of Country object of type double
	 */
	public double getGdp () {
		return this.Gdp;
		
	}
	
	/**
	 * Method that allows Cases to be specified
	 * 
	 * @param casechange of type double sets Cases of a Country object
	 */
	public void setCases (double casechange) {
		this.Cases = casechange;
	}
	
	/**
	 * Method that gets the Cases of a Country object
	 * 
	 * @return Cases of Country object of type double
	 */
	public double getCases () {
		return this.Cases;
		
	}
	
	/**
	 * Method that allows Deaths to be specified
	 * 
	 * @param deathchange of type double sets Deaths of a Country object
	 */
	public void setDeaths (double deathchange) {
		this.Deaths = deathchange;
		
	}
	
	/**
	 * Method that gets the Deaths of a Country object
	 * 
	 * @return Deaths of Country object of type double
	 */
	public double getDeaths () {
		return this.Deaths;
	}
	
	/**
	 * Method that allows Area to be specified
	 * 
	 * @param areachnage of type double sets Area of a Country object
	 */
	public void setArea (double areachange) {
		this.Area = areachange;
		
	}
	
	/**
	 * Method that gets the Area of a Country object
	 * 
	 * @return Area of Country object of type double
	 */
	public double getArea() {
		return this.Area;
		
	}
	/**
	 * Method that gets the fatality rate of COVID of a Country object, defined as fatal.
	 * Calculated by Deaths divided by Cases
	 * 
	 * @return fatal of Country object of type double
	 */
	public double getFatal() {
		double fatal = (getDeaths()/getCases());
		return fatal;
	}
	
	/**
	 * Method that gets the GDP per capita of a Country object, defined as gCap.
	 * Calculated by GDP divided by Pop
	 * 
	 * @return gCap of Country object of type double
	 */
	public double getGcapita() {
		double gCap = getGdp() / getPop();
		return gCap;
	}
	
	/**
	 * Method that gets the case rate of COVID of a Country object, defined as caseRate.
	 * Calculated by Cases divided by Pop then multiplied by 100,000
	 * 
	 * @return caseRate of Country object of type double
	 */
	public double getCaseRate() {
		double caseRate = (getCases()/getPop()) * 100000;
		return caseRate;
	}
	
	/**
	 * Method that gets the death rate of COVID of a Country object, defined as deathRate.
	 * Calculated by Deaths divided by Pop then multiplied by 100,000
	 * 
	 * @return deathRate of Country object of type double
	 */
	public double getDeathRate() {
		double deathRate = (getDeaths()/getPop()) * 100000;
		return deathRate;
	}
	
	/**
	 * Method that gets the population density of a Country object, defined as popDensity.
	 * Calculated by Pop divided by Area
	 * 
	 * @return popDensity of Country object of type double
	 */
	public double getPopDens() {
		double popDensity = getPop()/getArea();
		return popDensity;
	}
}
