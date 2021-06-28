package by.training.shape.repository;

import by.training.shape.entity.Pyramid;

@FunctionalInterface
public interface PyramidSpecification {

    boolean specify(Pyramid pyramid);

}
