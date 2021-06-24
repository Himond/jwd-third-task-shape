package by.training.shape.main;


import by.training.shape.entity.RightPyramid;
import by.training.shape.exception.ShapeException;
import by.training.shape.factory.PyramidFactory;
import by.training.shape.parser.PyramidParser;
import by.training.shape.reader.impl.ReaderServiceImpl;

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
        List<RightPyramid> pyramids = factory.create(parser);
        System.out.println(pyramids);



    }
}
