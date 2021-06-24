package by.training.shape.reader;

import by.training.shape.exception.ShapeException;

import java.io.IOException;
import java.util.List;

public interface ReaderService {

    List<String> read(String path) throws IOException, ShapeException;

}
