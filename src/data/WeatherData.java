package data;

//interface for the WeatherData methods
public interface WeatherData {
	
	//method to accept data
	public void dataIn(float temperature,float humidity, float pressure);
	
	//getter for Temperature
	public float getTemperature();
	
	//getter for humidity//getter for Pressure
	public float getHumidity();
	
	//getter for Pressure
	public float getPressure();
	
}
