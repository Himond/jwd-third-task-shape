package by.training.shape.factory;

import by.training.shape.entity.Shape;

public abstract class ShapeFactory {

    public abstract Shape create(double ... params);

}
