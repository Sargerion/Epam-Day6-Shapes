package edu.epam.task.storage.impl;

import edu.epam.task.entity.Quadrangle;
import edu.epam.task.specification.Specification;
import edu.epam.task.storage.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuadrangleRepository implements Repository<Quadrangle> {

    private static final Logger logger = LogManager.getLogger();

    private static QuadrangleRepository quadrangleRepository;
    private List<Quadrangle> quadrangles;

    private QuadrangleRepository() {
        quadrangles = new ArrayList<>();
    }

    public static QuadrangleRepository getInstance() {
        if (quadrangleRepository == null) {
            quadrangleRepository = new QuadrangleRepository();
        }
        return quadrangleRepository;
    }

    @Override
    public void add(Quadrangle quadrangle) {
        quadrangles.add(quadrangle);
        logger.info("Quadrangle added to repository {}", quadrangle);
    }

    @Override
    public void addAll(List<Quadrangle> shapes) {
        quadrangles.addAll(shapes);
        logger.info("Quadrangles added to repository {}", quadrangles);
    }

    @Override
    public void remove(Quadrangle quadrangle) {
        quadrangles.remove(quadrangle);
        logger.info("Quadrangle {} removed from repository", quadrangle);
    }

    @Override
    public Quadrangle get(int index) {
        logger.info("Quadrangle received {}", quadrangles.get(index));
        return quadrangles.get(index);
    }

    @Override
    public int getSize() {
        return quadrangles.size();
    }

    @Override
    public List<Quadrangle> sort(Comparator<? super Quadrangle> comparator) {
        List<Quadrangle> result = quadrangles.stream().sorted(comparator).collect(Collectors.toList());
        logger.info("Quadrangles sorted in accordance to the condition -> {}", result);
        return result;
    }

    public List<Quadrangle> query(Specification<Quadrangle> specification) {
        List<Quadrangle> result = quadrangles.stream().filter(specification::specify).collect(Collectors.toList());
        logger.info("Quadrangles filtered in accordance to the specification -> {}", result);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuadrangleRepositoryInfo{\n");
        sb.append("quadrangles=").append(quadrangles);
        sb.append("\n}");
        return sb.toString();
    }
}