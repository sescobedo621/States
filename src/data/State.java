package data;

public class State {
	private int stateNum;
	private String abbrev;
	private String name;
	private String capital;
	private String latitude;
	private String longitude;
	private String population;
	private String bird;
	private String flag;

	public State() {
	}
	
	public State(int num, String abbreviation, String name, String capital, String latitude, String longitude, String population, String bird, String flag) {
		this.abbrev = abbreviation;
		this.name = name;
		this.capital = capital;
		this.latitude = latitude;
		this.longitude = longitude;
		this.population = population;
		this.bird = bird;
		this.flag = flag;
		stateNum = num;
	}
	public int getStateNum()
	{
		return stateNum;
	}

	public void setStateNum(int stateNum)
	{
		this.stateNum = stateNum;
	}

	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String flag)
	{
		this.flag = flag;
	}

	public String getBird()
	{
		return bird;
	}

	public void setBird(String bird)
	{
		this.bird = bird;
	}

	public String getAbbrev()
	{
		return abbrev;
	}

	public void setAbbrev(String abbrev)
	{
		this.abbrev = abbrev;
	}

	public String getPopulation()
	{
		return population;
	}

	public void setPopulation(String population)
	{
		this.population = population;
	}

	public String getAbbreviation() {
		return abbrev;
	}
	public String getName() {
		return name;
	}
	public String getCapital() {
		return capital;
	}
	public String getLatitude() {
		return latitude;
	}
	public String getLongitude() {
		return longitude;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbrev = abbreviation;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "State [abbreviation=" + abbrev + ", name=" + name + ", capital=" + capital + "]";
	}

}
