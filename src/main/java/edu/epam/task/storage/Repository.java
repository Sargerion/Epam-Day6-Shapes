package edu.epam.task.storage;

import edu.epam.task.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {

    void add(T shape);

    void addAll(List<T> shapes);

    void remove(T shape);

    T get(int index);

    int getSize();

    List<T> sort(Comparator<? super T> comparator);

    List<T> query(Specification<T> specification);
}
