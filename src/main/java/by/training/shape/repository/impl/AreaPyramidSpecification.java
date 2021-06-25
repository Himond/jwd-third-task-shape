package by.training.shape.repository.impl;

import by.training.shape.entity.Pyramid;
import by.training.shape.repository.PyramidSpecification;
import by.training.shape.service.impl.RightPyramidServiceImpl;

public class AreaPyramidSpecification implements PyramidSpecification {

    private double fromArea;
    private double toArea;

    public AreaPyramidSpecification(double fromArea, double toArea) {
        this.fromArea = fromArea;
        this.toArea = toArea;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        RightPyramidServiceImpl service = new RightPyramidServiceImpl();
        boolean result;
        result = Double.compare(service.area(pyramid), fromArea) >= 0 && Double.compare(service.area(pyramid), toArea) <= 0;
        return result;
    }
}
