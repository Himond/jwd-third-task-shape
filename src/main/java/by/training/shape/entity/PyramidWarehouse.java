package by.training.shape.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    public Optional<ParametersOfPyramid> remove(Integer id) {
        ParametersOfPyramid parameters = pyramidParametersMap.remove(id);
        if (parameters != null){
            return Optional.of(parameters);
        }
        logger.log(Level.ERROR, "No value by id: " + id);
        return Optional.empty();
    }

    public Optional<ParametersOfPyramid> getParametersByID(Integer id){
        ParametersOfPyramid parameters = pyramidParametersMap.get(id);
        if (parameters != null){
            return Optional.of(parameters);
        }
        logger.log(Level.ERROR, "No value by id: " + id);
        return Optional.empty();
    }

    public Map<Integer, ParametersOfPyramid> getPyramidMap(){
        return Map.copyOf(pyramidParametersMap);
    }


}
