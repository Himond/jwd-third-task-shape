package by.training.shape.parser;

import by.training.shape.validator.PyramidParamsValidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PyramidParser {

    private static final String SPLIT_REGEX = "(\\,\\s)|(\\s)";

    public static List<double[]> parsePyramid(List<String> pyramids){

        List<double[]> arrayPyramid;

        arrayPyramid = pyramids.stream()
                .filter(PyramidParamsValidator::correctValuePyramid)
                .map(line -> line.split(SPLIT_REGEX))
                .map(array -> Stream.of(array)
                        .mapToDouble(Double::parseDouble)
                        .toArray())
                .collect(Collectors.toList());


        return arrayPyramid;
    }

    private PyramidParser() {
    }

}
