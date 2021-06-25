package by.training.shape.service.impl;

import by.training.shape.entity.Point;
import by.training.shape.entity.Pyramid;
import by.training.shape.service.PyramidService;
import by.training.shape.validator.RightPyramidValidator;


public class RightPyramidServiceImpl implements PyramidService {

    @Override
    public double area(Pyramid pyramid) {
        double fullArea = 0;
        if (RightPyramidValidator.isRightPyramid(pyramid)){
            double a = baseSideLength(pyramid);
            double b = triangleSideLength(pyramid);
            fullArea = Math.pow(a, 2) + 2 * a * Math.sqrt(Math.pow(b, 2) - Math.pow(a, 2) / 4);
        }
        return fullArea;
    }

    @Override
    public double volume(Pyramid pyramid) {
        double volume = 0;
        if (RightPyramidValidator.isRightPyramid(pyramid)) {
            volume = heightPyramid(pyramid) * Math.pow(baseSideLength(pyramid), 2) / 3;
        }
        return volume;
    }

    public void cutPyramid(Pyramid pyramid, double heightCut) {
        if (RightPyramidValidator.isRightPyramid(pyramid)){
            double heightPyramid = heightPyramid(pyramid);
            if (Double.compare(heightCut, heightPyramid) < 0 && Double.compare(heightCut, 0.0) > 0){
                pyramid.setA(pointRecalculate(pyramid.getA(), pyramid.getH(), heightCut));
                pyramid.setB(pointRecalculate(pyramid.getB(), pyramid.getH(), heightCut));
                pyramid.setC(pointRecalculate(pyramid.getC(), pyramid.getH(), heightCut));
                pyramid.setD(pointRecalculate(pyramid.getD(), pyramid.getH(), heightCut));
            }
        }
    }

    private Point pointRecalculate(Point a, Point b, double z){
        double newZ = (z - a.getZ()) / (b.getZ() - a.getZ());
        double newX = newZ * (b.getX() - a.getX()) + a.getX();
        double newY = newZ * (b.getY() - a.getY()) + a.getY();
        return new Point(newX, newY, z);
    }

    public double baseSideLength(Pyramid pyramid){
        double result;
        result = Math.sqrt(Math.pow(pyramid.getB().getX() - pyramid.getA().getX(), 2) + Math.pow(pyramid.getB().getY() - pyramid.getA().getY(), 2)
                + Math.pow(pyramid.getB().getY() - pyramid.getA().getY(), 2));
        return result;
    }

    public double triangleSideLength(Pyramid pyramid){
        double result;
        result = Math.sqrt(Math.pow(pyramid.getH().getX() - pyramid.getA().getX(), 2) + Math.pow(pyramid.getH().getY() - pyramid.getA().getY(), 2)
                + Math.pow(pyramid.getH().getZ() - pyramid.getA().getZ(), 2));
        return result;
    }


    public double heightPyramid(Pyramid pyramid){
        double result;
        double halfDiag = Math.sqrt(2) * baseSideLength(pyramid) / 2;
        result = Math.sqrt(Math.pow(triangleSideLength(pyramid), 2) - Math.pow(halfDiag, 2));
        return result;
    }


}
