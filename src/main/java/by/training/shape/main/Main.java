package by.training.shape.main;


import by.training.shape.comparator.PyramidVolumeComparator;
import by.training.shape.entity.ParametersOfPyramid;
import by.training.shape.entity.Pyramid;
import by.training.shape.entity.PyramidWarehouse;
import by.training.shape.exception.ShapeException;
import by.training.shape.creator.PyramidCreator;
import by.training.shape.observer.Observer;
import by.training.shape.observer.impl.PyramidObserver;
import by.training.shape.parser.PyramidParser;
import by.training.shape.reader.impl.ReaderServiceImpl;
import by.training.shape.repository.PyramidRepository;
import by.training.shape.repository.PyramidSpecification;
import by.training.shape.repository.impl.AreaPyramidSpecification;
import by.training.shape.service.impl.RightPyramidServiceImpl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ShapeException {

        ReaderServiceImpl reader = new ReaderServiceImpl();
        PyramidCreator creator = new PyramidCreator();
        RightPyramidServiceImpl service = new RightPyramidServiceImpl();
        PyramidRepository repository = new PyramidRepository();
        Observer observer = new PyramidObserver();
        PyramidWarehouse warehouse = PyramidWarehouse.getInstance();

        List<String> stringArrayList = reader.read("src\\main\\resources\\pyramids.txt");
        List<double[]> parser = PyramidParser.parsePyramid(stringArrayList);
        List<Pyramid> pyramids = creator.create(parser);

        repository.addAll(pyramids);

        for (Pyramid pyramid: pyramids){
            System.out.println(pyramid);
            double area = service.area(pyramid);
            double volume = service.volume(pyramid);
            warehouse.putParameters(pyramid.getId(), new ParametersOfPyramid(area, volume));
        }

        for (int i = 0; i < repository.size(); i++){
            System.out.println(warehouse.getParametersByID(i + 1).toString());
        }


        for (int i = 0; i < repository.size(); i++){
            repository.get(i).attach(observer);
        }

        //cut pyramids and change parameters
        for (int i = 0; i < repository.size(); i++){
            service.cutPyramid(repository.get(i), 2);
            repository.get(i).notifyObservers();
        }


        for (int i = 0; i < repository.size(); i++){
            System.out.println(warehouse.getParametersByID(i + 1).toString());
        }

        PyramidSpecification specification = new AreaPyramidSpecification(30, 70);
        List<Pyramid> pyramidList = repository.query(specification);
        System.out.println(pyramidList);

        List<Pyramid> pyramidsSortVolume = repository.sort(new PyramidVolumeComparator());
        System.out.println(pyramidsSortVolume);

    }
}
