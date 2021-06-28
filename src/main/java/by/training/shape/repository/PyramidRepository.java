package by.training.shape.repository;

import by.training.shape.entity.Pyramid;

import java.util.*;
import java.util.stream.Collectors;

public class PyramidRepository {

    private List<Pyramid> pyramids = new ArrayList<>();

    public boolean add(Pyramid pyramid){
        return pyramids.add(pyramid);
    }

    public boolean addAll(List<Pyramid> pyramidList){
        return  pyramids.addAll(pyramidList);
    }

    public void clear(){
        pyramids.clear();
    }

    public int size() {
        return pyramids.size();
    }

    public boolean contains(Pyramid pyramid) {
        return pyramids.contains(pyramid);
    }

    public Pyramid get(int index) {
        return pyramids.get(index);
    }

    public Pyramid set(int index, Pyramid element) {
        return pyramids.set(index, element);
    }

    public Pyramid remove(int index) {
        return pyramids.remove(index);
    }

    public boolean remove(Pyramid pyramid) {
        return pyramids.remove(pyramid);
    }

    public int indexOf(Pyramid pyramid) {
        return pyramids.indexOf(pyramid);
    }

    public List<Pyramid> query(PyramidSpecification specification){
        return pyramids.stream().filter(specification::specify).collect(Collectors.toList());
    }

    public List<Pyramid> sort(Comparator<? super Pyramid> comparator) {
        List<Pyramid> pyramidsClone = new ArrayList<>(pyramids);
        pyramidsClone.sort(comparator);
        return pyramidsClone;
    }

    @Override
    public boolean equals(Object o) {
        return pyramids.equals(o);
    }

    @Override
    public int hashCode() {
        return pyramids.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PyramidRepository{");
        sb.append("pyramids=").append(pyramids);
        sb.append('}');
        return sb.toString();
    }
}
