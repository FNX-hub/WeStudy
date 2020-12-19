package logic.model;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableObject {
	
    private List<Observer> observerList;

    public ObservableObject() {
		this.observerList = new ArrayList<>();
	}
	public void attach(Observer observer) {
        observerList.add(observer);
    }
    public void detach(Observer observer) {
        observerList.remove(observer);
    }
    public Boolean hasObserver(Observer observer) {
    	return observerList.contains(observer);
    }
    //notify() is already used by the Java Language
    protected void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}
