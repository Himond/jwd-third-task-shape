package by.training.shape.comparator;

import by.training.shape.entity.Pyramid;
import by.training.shape.entity.Warehouse;
import by.training.shape.exception.ShapeException;

import java.util.Comparator;
import java.util.function.ToDoubleFunction;

public enum PyramidComparator {
    ID,
    POINT_A,
    POINT_B,
    POINT_C,
    POINT_D,
    POINT_H,
    AREA,
    VOLUME;

    public Comparator<Pyramid> getComparator() throws ShapeException {
        return switch(this){
            case ID -> Comparator.comparingInt(Pyramid::getId);

            case POINT_A -> Comparator.comparingDouble((ToDoubleFunction<Pyramid>) pyramid -> pyramid.getA().getX())
                    .thenComparing(pyramid -> pyramid.getA().getY())
                    .thenComparing(pyramid -> pyramid.getA().getZ());

            case POINT_B -> Comparator.comparingDouble((ToDoubleFunction<Pyramid>) pyramid -> pyramid.getB().getX())
                    .thenComparing(pyramid -> pyramid.getB().getY())
                    .thenComparing(pyramid -> pyramid.getB().getZ());

            case POINT_C -> Comparator.comparingDouble((ToDoubleFunction<Pyramid>) pyramid -> pyramid.getC().getX())
                    .thenComparing(pyramid -> pyramid.getC().getY())
                    .thenComparing(pyramid -> pyramid.getC().getZ());

            case POINT_D -> Comparator.comparingDouble((ToDoubleFunction<Pyramid>) pyramid -> pyramid.getD().getX())
                    .thenComparing(pyramid -> pyramid.getD().getY())
                    .thenComparing(pyramid -> pyramid.getD().getZ());

            case POINT_H -> Comparator.comparingDouble((ToDoubleFunction<Pyramid>) pyramid -> pyramid.getH().getX())
                    .thenComparing(pyramid -> pyramid.getH().getY())
                    .thenComparing(pyramid -> pyramid.getH().getZ());

            case AREA -> Comparator.comparingDouble((ToDoubleFunction<Pyramid>) pyramid -> {
                try {
                    return Warehouse.getInstance().get(pyramid.getId()).getSurfaceArea();
                } catch (ShapeException e) {
                    e.printStackTrace();
                }
                return 0;
            });

            case VOLUME ->
                    Comparator.comparingDouble((ToDoubleFunction<Pyramid>) pyramid -> {
                        try {
                            return Warehouse.getInstance().get(pyramid.getId()).getVolume();
                        } catch (ShapeException e) {
                            e.printStackTrace();
                        }
                        return 0;
                    });

            default -> Comparator.comparingInt(Pyramid::getId);
        };
    }

}