package by.training.shape.main;


import by.training.shape.entity.Pyramid;
import by.training.shape.exception.ShapeException;
import by.training.shape.factory.PyramidFactory;
import by.training.shape.parser.PyramidParser;
import by.training.shape.reader.impl.ReaderServiceImpl;
import by.training.shape.service.impl.RightPyramidServiceImpl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ShapeException {

        ReaderServiceImpl reader = new ReaderServiceImpl();
        List<String> stringArrayList = reader.read("src\\main\\resources\\pyramids.txt");
        System.out.println(stringArrayList);
        List<double[]> parser = PyramidParser.parsePyramid(stringArrayList);
        parser.stream().forEach(pyramid -> System.out.println(Arrays.toString(pyramid)));


        PyramidFactory factory = new PyramidFactory();
        List<Pyramid> pyramids = factory.create(parser);
        Pyramid one = pyramids.get(0);
        System.out.println(pyramids);


        RightPyramidServiceImpl service = new RightPyramidServiceImpl();
        service.cutPyramid(one, 2.5);
        System.out.println(one);


    }
}
