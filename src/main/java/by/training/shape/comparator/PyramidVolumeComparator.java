package by.training.shape.comparator;

import by.training.shape.entity.Pyramid;
import by.training.shape.service.PyramidService;
import by.training.shape.service.impl.RightPyramidServiceImpl;

import java.util.Comparator;

public class PyramidVolumeComparator implements Comparator<Pyramid> {

    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        PyramidService service = new RightPyramidServiceImpl();
        int compare = Double.compare(service.volume(o1), service.volume(o2));
        return compare;
    }

}
