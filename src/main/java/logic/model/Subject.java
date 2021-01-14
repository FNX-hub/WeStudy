package logic.model;

import java.util.List;

public abstract class Subject {

	private List<Observer> observers;
	
	public void attach(Observer o) {
		observers.add(o);
	}
	public void detach(Observer o) {
		observers.remove(o);
	}
	public void notifyObservers() {
		observers.forEach(Observer::update);
	}
}
