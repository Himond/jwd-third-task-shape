package by.training.shape.repository.impl;

import by.training.shape.entity.Pyramid;
import by.training.shape.repository.PyramidSpecification;

public class IDPyramidSpecification implements PyramidSpecification {
    private int fromID;
    private int toID;


    public IDPyramidSpecification(int fromID, int toID) {
        this.fromID = fromID;
        this.toID = toID;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        boolean result;
        result = pyramid.getId() >= fromID && pyramid.getId() <= toID;
        return result;
    }
}
