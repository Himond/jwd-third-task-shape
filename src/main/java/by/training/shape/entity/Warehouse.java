package by.training.shape.entity;

import by.training.shape.exception.ShapeException;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Warehouse {

    private static Logger logger = LogManager.getLogger();
    private static Warehouse instance;
    private Map<Integer, PyramidParameter> pyramidParameterMap;

    private Warehouse(){
        this.pyramidParameterMap = new HashMap<>();
    }

    public static Warehouse getInstance(){
        if(instance == null){
            instance = new Warehouse();
        }
        return instance;
    }

    public void put(Integer id, PyramidParameter parameters){
        pyramidParameterMap.put(id, parameters);
    }

    public PyramidParameter remove(Integer id) {
        PyramidParameter parameters = pyramidParameterMap.remove(id);
        return parameters;
    }


    public PyramidParameter get(Integer id) throws ShapeException {
        PyramidParameter parameters = pyramidParameterMap.get(id);
        if (parameters == null){
            logger.log(Level.ERROR, "No value by id :" + id);
            throw new ShapeException("No value by id :" + id);
        }
        return pyramidParameterMap.get(id);
    }


}
