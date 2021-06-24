package by.training.shape.parser;

import by.training.shape.validator.PyramidParamsValidator;

import java.util.ArrayList;
import java.util.List;

public class PyramidParser {

    private static final String SPLIT_REGEX = "(\\,\\s)|(\\s)";

    public static List<double[]> parsePyramid(List<String> pyramids){

        List<double[]> arrayPyramid = new ArrayList<>();
        double[] paramsPyramid ;

        for (String pyramid : pyramids) {
            if(PyramidParamsValidator.correctValuePyramid(pyramid)){
                String[] line = pyramid.split(SPLIT_REGEX);
                paramsPyramid = new double[line.length];
                for (int j = 0; j < line.length; j++) {
                    paramsPyramid[j] = Double.parseDouble(line[j]);
                }
                arrayPyramid.add(paramsPyramid);
            }
        }

        return arrayPyramid;
    }

    private PyramidParser() {
    }

}
