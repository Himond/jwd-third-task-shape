package by.training.shape.repository.impl;

import by.training.shape.entity.Pyramid;
import by.training.shape.repository.PyramidSpecification;

public class FirstQuadrantPyramidSpecification implements PyramidSpecification {
    @Override
    public boolean specify(Pyramid pyramid) {
        boolean pointA = pyramid.getA().getX() >= 0 && pyramid.getA().getY() >= 0 && pyramid.getA().getZ() >= 0;
        boolean pointB = pyramid.getB().getX() >= 0 && pyramid.getB().getY() >= 0 && pyramid.getB().getZ() >= 0;
        boolean pointC = pyramid.getC().getX() >= 0 && pyramid.getC().getY() >= 0 && pyramid.getC().getZ() >= 0;
        boolean pointD = pyramid.getD().getX() >= 0 && pyramid.getD().getY() >= 0 && pyramid.getD().getZ() >= 0;
        boolean pointH = pyramid.getH().getX() >= 0 && pyramid.getH().getY() >= 0 && pyramid.getH().getZ() >= 0;


        return pointA && pointB && pointC && pointD && pointH;
    }
}
