package by.training.shape.comparator;

import by.training.shape.entity.Pyramid;

import java.util.Comparator;

public class PyramidIDComparator implements Comparator<Pyramid> {

    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        int compare = Long.compare(o1.getId(), o2.getId());
        return compare;
    }
}
