package by.training.shape;


import by.training.shape.entity.Point;
import by.training.shape.entity.RightPyramid;
import by.training.shape.service.impl.RightPyramidServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class PyramidServiceTest {

    private RightPyramidServiceImpl service = new RightPyramidServiceImpl();
    private RightPyramid pyramid = new RightPyramid(1,new Point(1,1,0),
            new Point(4,1,0),
            new Point(4,4,0),
            new Point(1,4,0),
            new Point(2.5,2.5,3));

    @Test
    public void pyramidArea() {
        double expected = 29.1246;
        double actual = service.area( pyramid);
        Assert.assertEquals(actual, expected, 0.001);
    }

    @Test
    public void cutPyramidArea() {
        double expected = 24.18;
        double actual = service.truncatedArea(2, pyramid);
        Assert.assertEquals(actual, expected, 0.001);
    }

    @Test
    public void pyramidVolume() {
        double expected = 9.0;
        double actual = service.volume(pyramid);
        Assert.assertEquals(actual, expected, 0.001);
    }


    @Test
    public void pyramidCutVolume() {
        double expected = 6.333;
        double actual = service.truncatedVolume(2, pyramid);
        Assert.assertEquals(actual, expected, 0.001);
    }

}
