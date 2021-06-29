package by.training.shape.creator;

import by.training.shape.entity.Point;
import by.training.shape.entity.Pyramid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PyramidCreator extends ShapeCreator {

    private static Logger logger = LogManager.getLogger();

    @Override
    public Pyramid create(double[] params) {
        final int numberOfPyramidPoints = 5;
        int i, j;

        Point[] points = new Point[numberOfPyramidPoints];
        for (i = 0, j = 0; i <= params.length - 3; i += 3, j++){
            points[j] = new Point(params[i], params[i + 1], params[i + 2]);
        }

        Pyramid.Builder builder = Pyramid.newBuilder();
        builder.setPointA(points[0])
                .setPointB(points[1])
                .setPointC(points[2])
                .setPointD(points[3])
                .setPointH(points[4]);

        Pyramid pyramid = builder.build();
        logger.log(Level.INFO, "Pyramid is created successfully: " + pyramid);

        return pyramid;
    }

    public List<Pyramid> create(List<double[]> params) {
        List<Pyramid> pyramids = new ArrayList<>();

        for (double[] pyramid: params){
            pyramids.add(create(pyramid));
        }

        return pyramids;
    }



}
