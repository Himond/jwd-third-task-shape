package by.training.shape.observer.impl;

import by.training.shape.entity.Pyramid;
import by.training.shape.entity.ParametersOfPyramid;
import by.training.shape.entity.PyramidWarehouse;
import by.training.shape.observer.Observer;
import by.training.shape.observer.PyramidEvent;
import by.training.shape.service.impl.RightPyramidServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PyramidObserver implements Observer {
    private static Logger logger = LogManager.getLogger();


    @Override
    public void changeParameters(PyramidEvent event) {
        PyramidWarehouse warehouse = PyramidWarehouse.getInstance();
        RightPyramidServiceImpl service = new RightPyramidServiceImpl();
        Pyramid pyramid = event.getSource();

        double area = service.area(pyramid);
        double volume = service.volume(pyramid);
        ParametersOfPyramid parameter = new ParametersOfPyramid(area, volume);

        warehouse.putParameters(pyramid.getId(), parameter);

        logger.log(Level.INFO, "Parameters for pyramid id " + pyramid.getId() + " updated");

    }


}
