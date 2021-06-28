package by.training.shape.validator;

public class PyramidParamsValidator {

    private static final String CORRECT_PYRAMID_PARAMS = "^-?(\\d+.\\d+[\\ \\,]*){15}";

    public static boolean correctValuePyramid(String line){
        boolean valid = line.matches(CORRECT_PYRAMID_PARAMS);
        return valid;
    }

    private PyramidParamsValidator() {
    }
}
