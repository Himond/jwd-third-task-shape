package by.training.shape.repository.impl;

import by.training.shape.entity.Pyramid;
import by.training.shape.repository.PyramidSpecification;
import by.training.shape.service.impl.RightPyramidServiceImpl;

public class VolumePyramidSpecification implements PyramidSpecification {

    private double fromVolume;
    private double toVolume;

    public VolumePyramidSpecification(double fromVolume, double toVolume) {
        this.fromVolume = fromVolume;
        this.toVolume = toVolume;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        RightPyramidServiceImpl service = new RightPyramidServiceImpl();
        boolean result;
        result = Double.compare(service.volume(pyramid), fromVolume)  >= 0 && Double.compare(service.volume(pyramid), toVolume)  <= 0;
        return result;
    }

}
