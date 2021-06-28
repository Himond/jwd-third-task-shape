package by.training.shape.observer;

public interface PyramidObservable {

    void attach(Observer observer);

    void detach();

    void notifyObservers();

}
