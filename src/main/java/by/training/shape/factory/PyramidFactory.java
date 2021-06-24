package by.training.shape.factory;

import by.training.shape.entity.Point;
import by.training.shape.entity.RightPyramid;


import java.util.ArrayList;
import java.util.List;

public class PyramidFactory extends ShapeFactory{

    private static int ID = 0;

    @Override
    public RightPyramid create(double[] params) {
        int i, j;
        Point[] points = new Point[5];
        for (i = 0, j = 0; i <= params.length - 3; i += 3, j++){
            points[j] = new Point(params[i], params[i + 1], params[i + 2]);
        }
        return new RightPyramid(getID(), points);
    }

    public List<RightPyramid> create(List<double[]> params) {
        List<RightPyramid> pyramids = new ArrayList<>();

        for (double[] pyramid: params){
            pyramids.add(create(pyramid));
        }

        return pyramids;
    }


    private static synchronized int getID(){
        int id = ID;
        ID++;
        return id;
    }

}
