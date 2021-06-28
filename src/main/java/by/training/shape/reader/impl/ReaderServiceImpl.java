package by.training.shape.reader.impl;

import by.training.shape.exception.ShapeException;
import by.training.shape.reader.ReaderService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderServiceImpl implements ReaderService {

    private static Logger logger = LogManager.getLogger();

    @Override
    public List<String> read(String path) throws  ShapeException {

        List<String> stringPyramidsList;
        Path getPath = Paths.get(path);

        try (Stream<String> lineStream = Files.newBufferedReader(getPath).lines()) {
            stringPyramidsList = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.log(Level.ERROR, "File not found: " + getPath.getFileName());
            throw new ShapeException(e);
        }

        return stringPyramidsList;
    }
}
