package edu.epam.task.observer;

public interface Observable<T> {

    void attachObserver(T observer);

    void detachObserver(T observer);

    void notifyObserver();

}