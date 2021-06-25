package by.training.shape;


import by.training.shape.entity.Point;
import by.training.shape.entity.Pyramid;
import by.training.shape.exception.ShapeException;
import by.training.shape.service.impl.RightPyramidServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PyramidServiceTest {

    private RightPyramidServiceImpl service = new RightPyramidServiceImpl();
    private Pyramid pyramid;

    @Before
    public void initTest(){
        pyramid = new Pyramid(new Point(1,1,0),
                new Point(4,1,0),
                new Point(4,4,0),
                new Point(1,4,0),
                new Point(2.5,2.5,3));
    }

    @After
    public void afterTest() {
        pyramid = null;
    }


    @Test
    public void pyramidArea() {
        double expected = 29.1246;
        double actual = service.area( pyramid);
        Assert.assertEquals(actual, expected, 0.001);
    }

    @Test
    public void pyramidVolume() {
        double expected = 9.0;
        double actual = service.volume(pyramid);
        Assert.assertEquals(actual, expected, 0.001);
    }

    @Test
    public void cutPyramidVolume() throws ShapeException {
        service.cutPyramid(pyramid, 1);
        double expected = 2.667;
        double actual = service.volume(pyramid);
        Assert.assertEquals(actual, expected, 0.001);
    }

    @Test
    public void cutPyramidArea() throws ShapeException {
        service.cutPyramid(pyramid, 1);
        double expected = 12.944;
        double actual = service.area(pyramid);
        Assert.assertEquals(actual, expected, 0.001);
    }

}
