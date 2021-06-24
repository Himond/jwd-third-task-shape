package by.training.shape.validator;

import by.training.shape.entity.Point;
import by.training.shape.entity.RightPyramid;

public class RightPyramidValidator {


    public static boolean isRightPyramid(RightPyramid pyramid){
        double a, b, c, d;
        boolean valid = true;
        boolean square;
        a = lengthSide(pyramid.getA(), pyramid.getB());
        b = lengthSide(pyramid.getC(), pyramid.getB());
        c = lengthSide(pyramid.getC(), pyramid.getD());
        d = lengthSide(pyramid.getD(), pyramid.getA());

        square = Double.compare(a, b) == 0 && Double.compare(b, c) == 0 && Double.compare(c, d) == 0 && Double.compare(d, a) == 0;

        if(square){
            double diagonal = Math.sqrt(2) * a;
            Point o = new Point(pyramid.getHeight().getX(), pyramid.getHeight().getY(), 0);
            System.out.println(Math.abs(lengthSide(pyramid.getA(), o) - diagonal / 2) < 0.001);
            if (Math.abs(lengthSide(pyramid.getA(), o) - diagonal / 2) > 0.001){
                valid = false;
            }
        }else {
            valid = false;
        }
        return valid;
    }


    private static double lengthSide(Point a, Point b){
        double result;
        result = Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2)
                + Math.pow(b.getZ() - a.getZ(), 2));
        return result;
    }


    private RightPyramidValidator() {
    }
}
