package logic.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Subject {

	private List<Observer> observers = new ArrayList<>();
	
	public void attach(Observer o) {
		observers.add(o);
	}
	public void detach(Observer o) {
		Iterator<Observer> itr = observers.iterator();
		while(itr.hasNext()) {
			if(itr.next().equals(o)) itr.remove();
		}
	}

	public void notifyObservers() {
		observers.forEach(Observer::update);
	}
}
