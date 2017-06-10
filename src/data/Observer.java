package data;

//Observer interface
public interface Observer {
	
	//method to update variables
	public void update(float temp, float humidity, float pressure);
	
	public void setSubject(Subject data);
}

