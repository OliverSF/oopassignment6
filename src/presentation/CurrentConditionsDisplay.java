package presentation;

import data.InitProperties;
import data.Observer;
import data.Subject;

//Concrete observer CurrentCondidtionsDisplay implements interfaces
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private Subject subject;
	
	//constructor
	public CurrentConditionsDisplay(Subject data) {
		//instatiating subject
		this.subject = data;
		//registering Observer with Subject
		data.registerObserver(this);
	}
	
	//method to update weather variables
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}
	
	//method to print out relevant information
	public void display() {
		System.out.println("Current conditions: " + getTemp()
			+ "F degrees and " + getHumidity() + "% humidity");
	}
	
	//method to change the data source (and removes the old one)
	@Override
	public void setSubject(Subject data) {
		this.subject.removeObserver(this);
		data.registerObserver(this);
		this.subject = data;
		this.reset();
	}
	
	//removes the observer from the Subjects arrayList
	@Override
	public void close() {
		this.subject.removeObserver(this);
	}
	
	//getter for temperature
	public float getTemp(){
		return this.temperature;
		
	}
	
	//getter for humidity
	public float getHumidity(){
		return this.humidity;
		
	}
	
	//reset values to default
	@Override
	public void reset(){
		this.temperature = InitProperties.INIT_MAX_TEMP;
		this.humidity = InitProperties.INIT_HUMIDITY;
	}
}


