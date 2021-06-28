package by.training.shape.entity;

import by.training.shape.exception.ShapeException;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class PyramidWarehouse {

    private static Logger logger = LogManager.getLogger();
    private static PyramidWarehouse instance;
    private Map<Integer, ParametersOfPyramid> pyramidParametersMap;

    private PyramidWarehouse(){
        this.pyramidParametersMap = new HashMap<>();
    }

    public static PyramidWarehouse getInstance(){
        if(instance == null){
            instance = new PyramidWarehouse();
        }
        return instance;
    }

    public void putParameters(Integer id, ParametersOfPyramid parameters){
        pyramidParametersMap.put(id, parameters);
    }

    public ParametersOfPyramid remove(Integer id) {
        return pyramidParametersMap.remove(id);
    }

    public ParametersOfPyramid getParametersByID(Integer id) throws ShapeException {
        ParametersOfPyramid parameters = pyramidParametersMap.get(id);
        if (parameters == null){
            logger.log(Level.ERROR, "No value by id: " + id);
            throw new ShapeException("No value by id: " + id);
        }
        return pyramidParametersMap.get(id);
    }

    public Map<Integer, ParametersOfPyramid> getPyramidMap(){
        return Map.copyOf(pyramidParametersMap);
    }


}
