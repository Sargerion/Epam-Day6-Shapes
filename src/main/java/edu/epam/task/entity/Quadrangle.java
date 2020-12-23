package edu.epam.task.entity;

import edu.epam.task.exception.CreateShapeException;
import edu.epam.task.observer.Observable;
import edu.epam.task.observer.Observer;
import edu.epam.task.observer.impl.QuadrangleObserver;
import edu.epam.task.util.IdGenerator;
import edu.epam.task.validator.QuadrangleValidator;

import java.util.ArrayList;
import java.util.List;

public class Quadrangle extends AbstractShape implements Observable<Observer<Quadrangle>> {

    private String quadrangleId;
    private List<Point2D> pointsToCreate;
    private Observer<Quadrangle> observer;

    public Quadrangle(List<Point2D> pointsToCreate) {
        quadrangleId = IdGenerator.generateId();
        this.pointsToCreate = pointsToCreate;
        observer = new QuadrangleObserver();
    }

    public String getQuadrangleId() {
        return quadrangleId;
    }

    public void setQuadrangleId(String quadrangleId) {
        this.quadrangleId = quadrangleId;
    }

    public List<Point2D> getPoints() {
        return new ArrayList<>(pointsToCreate);
    }

    public void setPointsToCreate(List<Point2D> pointsToCreate) throws CreateShapeException {
        QuadrangleValidator validator = new QuadrangleValidator();
        if (!validator.isQuadrangle(pointsToCreate)) {
            throw new CreateShapeException("This points -> {} are not consist a quadrangle" + pointsToCreate);
        }
        this.pointsToCreate = pointsToCreate;
        notifyObserver();
    }

    @Override
    public void attachObserver(Observer<Quadrangle> observer) {
        if(observer != null) {
            this.observer = observer;
        }
    }

    @Override
    public void detachObserver(Observer<Quadrangle> observer) {
        observer = null;
    }

    @Override
    public void notifyObserver() {
        if(observer != null) {
            observer.recalculateArea(this);
            observer.recalculatePerimeter(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quadrangle quadrangle = (Quadrangle) o;
        return pointsToCreate.equals(quadrangle.pointsToCreate);
    }

    @Override
    public int hashCode() {
        int result = pointsToCreate.hashCode();
        result *= 31;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Quadrangle {\n");
        sb.append("\tquadrangleId = ").append(quadrangleId);
        sb.append(",\tpoints = ").append(pointsToCreate);
        sb.append("\n}");
        return sb.toString();
    }
}