package presentation;

import data.InitProperties;
import data.Observer;
import data.Subject;

//Concrete observer CurrentCondidtionsDisplay implements interfaces
public class ForecastDisplay implements Observer, DisplayElement {
	//creating neccessary variables
	//static variable to allow resetting to default etc
	public static String INIT_FORECAST = "no change";
	private float currentPressure = InitProperties.INIT_PRESSURE;  
	private float lastPressure;
	private Subject subject;
	private String forecast  = INIT_FORECAST;
	
	//constructor
	public ForecastDisplay(Subject data) {
		//instatiating subject
		this.subject = data;
		//registering Observer with Subject
		data.registerObserver(this);
	}
	
	//method to update weather variables
	public void update(float temp, float humidity, float pressure) {
        //setting to allow comparison in analyse method to therefore set forecast
		lastPressure = currentPressure;
		currentPressure = pressure;
		analyse();
		//calling diplay method
		display();
	}
	
	//method to analyse whether current pressure is greater than, equal to or less that
	//the last pressure and therefore set the forecast accordingly
	private void analyse() {
		
		if (currentPressure > lastPressure) {
			this.forecast = "sunshine";
			
		} else if (currentPressure == lastPressure) {
			this.forecast = "no change";
		} else if (currentPressure < lastPressure) {
			this.forecast = "rain"; 
		}
		
	}

	@Override
	//method to print out relevant information
	public void display() {
		System.out.println("Current Forecast: " + getForecast());
	}
	
	//method to change the data source (and removes the old one)
	@Override
	public void setSubject(Subject data) {
		this.subject.removeObserver(this);
		data.registerObserver(this);
		this.subject = data;
		this.reset();
	}

	@Override
	//deregister self from subject
	public void close() {
		this.subject.removeObserver(this);
	}
	
	public float getCurrentPressure(){
		return this.currentPressure;
	}
	@Override
	//reset to default values
	public void reset(){
		this.currentPressure = InitProperties.INIT_PRESSURE;  
		this.lastPressure = 0.0f;
		this.forecast = INIT_FORECAST;
	}
	
	//getter for forecast
	public String getForecast(){
		return this.forecast;
	}
}
