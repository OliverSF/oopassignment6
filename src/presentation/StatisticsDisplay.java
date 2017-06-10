package presentation;

import data.InitProperties;
import data.Observer;
import data.Subject;


//Concrete observer StatisticsDisplay implements interfaces
public class StatisticsDisplay implements Observer, DisplayElement {
	
	//creating variables
	private float maxTemp = InitProperties.INIT_MAX_TEMP;
	private float minTemp = InitProperties.INIT_MIN_TEMP;
	private float tempSum= InitProperties.INIT_TEMP_SUM;
	private int numReadings;
	private Subject subject;
	
	//constructor
	public StatisticsDisplay(Subject data) {
		//instatiating subject
		this.subject = data;
		//registering Observer with Subject
		data.registerObserver(this);
	}
	//method to update weather variables
	public void update(float temp, float humidity, float pressure) {
		this.tempSum += temp;
		this.numReadings++;

		if (temp > maxTemp) {
			this.maxTemp = temp;
		}
 
		if (temp < minTemp) {
			this.minTemp = temp;
		}

		display();
	}
	
	//method to print out relevant information
	public void display() {
		System.out.println("Avg/Max/Min temperature = " + getAveTemp()
			+ "/" + getMaxTemp() + "/" + getMinTemp());
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
	
	//getter for average temperature
	public float getAveTemp(){
		return this.tempSum/numReadings;
	}
	
	//getter for max temperature
	public float getMaxTemp(){
		return this.maxTemp;
	}
	
	//getter for min temperature
	public float getMinTemp(){
		return this.minTemp;
	}
	
	@Override
	public void reset(){
		this.maxTemp = InitProperties.INIT_MAX_TEMP;
		this.minTemp = InitProperties.INIT_MIN_TEMP;
		this.tempSum= InitProperties.INIT_TEMP_SUM;
		this.numReadings=0;
	}
}
