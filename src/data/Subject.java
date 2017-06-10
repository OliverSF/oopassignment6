package data;

//Subject interface
public interface Subject {
	//methods to interact with Observers
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}

