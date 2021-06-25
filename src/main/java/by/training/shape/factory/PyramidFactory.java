package by.training.shape.factory;

import by.training.shape.entity.Point;
import by.training.shape.entity.Pyramid;

import java.util.ArrayList;
import java.util.List;

public class PyramidFactory extends ShapeFactory{


    @Override
    public Pyramid create(double[] params) {
        int i, j;
        Point[] points = new Point[5];
        for (i = 0, j = 0; i <= params.length - 3; i += 3, j++){
            points[j] = new Point(params[i], params[i + 1], params[i + 2]);
        }
        return new Pyramid(points);
    }

    public List<Pyramid> create(List<double[]> params) {
        List<Pyramid> pyramids = new ArrayList<>();

        for (double[] pyramid: params){
            pyramids.add(create(pyramid));
        }

        return pyramids;
    }



}
