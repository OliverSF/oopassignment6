package data;

import java.util.ArrayList;

//WeatherData_North implements both the Subject - methods to interact with Observers
//and WeatherData - data methods
public class WeatherData_North implements Subject, WeatherData {
	
	//arrayList to keep observers
	private ArrayList<Observer> observers;
	//creating variables
	private float temperature;
	private float humidity;
	private float pressure;
	
	//constructor
	public WeatherData_North() {
		this.observers = new ArrayList<Observer>();
	}
	
	//method to add observer to ArrayList/register them
	@Override
	public void registerObserver(Observer o) {

		observers.add(o);
		
	}
	
	//method to remove observer
	@Override
	public void removeObserver(Observer o) {

		int observerIndex = observers.indexOf(o);
		System.out.println("Observer " + (observerIndex+1) + " deleted");
		observers.remove(observerIndex);
	}
	
	//method to notify observers of changes - called from dataIn method
	@Override
	public void notifyObservers() {
		
		//enhanced for loop to 'notify' all registered observers
		for(Observer observer : observers)
			observer.update(temperature, humidity, pressure);	
	}
	
	//method to add new data
	@Override
	public void dataIn(float temperature, float humidity, float pressure) {

		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		//calling method to update observers as data changes
		this.notifyObservers();
		
	}
	
	//getter for Temperature
	@Override
	public float getTemperature() {
		return temperature;
	}
	
	//getter for Humidity
	@Override
	public float getHumidity() {
		return humidity;
	}
	
	//getter for Pressure
	@Override
	public float getPressure() {
		return pressure;
	}
}
