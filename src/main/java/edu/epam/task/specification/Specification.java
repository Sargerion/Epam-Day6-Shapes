package edu.epam.task.specification;

@FunctionalInterface
public interface Specification<T> {

    boolean specify(T t);

}
