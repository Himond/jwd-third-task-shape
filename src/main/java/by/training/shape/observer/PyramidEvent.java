package by.training.shape.observer;

import by.training.shape.entity.Pyramid;

import java.util.EventObject;

public class PyramidEvent extends EventObject {

    public PyramidEvent(Pyramid source) {
        super(source);
    }

    @Override
    public Pyramid getSource(){
        return (Pyramid) super.getSource();
    }

}
