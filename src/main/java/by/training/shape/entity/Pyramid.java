package by.training.shape.entity;


import by.training.shape.observer.Observer;
import by.training.shape.observer.PyramidEvent;
import by.training.shape.observer.PyramidObservable;
import by.training.shape.util.IdGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Pyramid extends Shape implements PyramidObservable {
    private static Logger logger = LogManager.getLogger();

    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private Point h;

    private Observer observer;

    public Pyramid() {
        super(IdGenerator.generateId());
    }

    public Pyramid(Point a, Point b, Point c, Point d, Point h) {
        super(IdGenerator.generateId());
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.h = h;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
    }

    public Point getH() {
        return h;
    }

    public void setH(Point h) {
        this.h = h;
    }


    @Override
    public void attach(Observer observer) {
        this.observer = observer;

    }

    @Override
    public void detach() {
        this.observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null){
            PyramidEvent pyramidEvent = new PyramidEvent(this);
            observer.changeParameters(pyramidEvent);
        }else {
            logger.log(Level.INFO, "Observer is null");
        }
    }


    public static Pyramid.Builder newBuilder(){
        return new Pyramid().new Builder();
    }

    public class Builder{

        private Builder() {
        }

        public Pyramid.Builder setPointA(Point a){
            Pyramid.this.a = a;
            return this;
        }

        public Pyramid.Builder setPointB(Point b){
            Pyramid.this.b = b;
            return this;
        }

        public Pyramid.Builder setPointC(Point c){
            Pyramid.this.c = c;
            return this;
        }

        public Pyramid.Builder setPointD(Point d){
            Pyramid.this.d = d;
            return this;
        }

        public Pyramid.Builder setPointH(Point h){
            Pyramid.this.h = h;
            return this;
        }


        public Pyramid build(){
            return Pyramid.this;
        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pyramid pyramid = (Pyramid) o;

        if(a == null){
            if (pyramid.a != null){
                return false;
            }
        }else if (!a.equals(pyramid.a)){
            return false;
        }
        if(b == null){
            if (pyramid.b != null){
                return false;
            }
        }else if (!b.equals(pyramid.b)){
            return false;
        }
        if(c == null){
            if (pyramid.c != null){
                return false;
            }
        }else if (!c.equals(pyramid.c)){
            return false;
        }
        if(d == null){
            if (pyramid.d != null){
                return false;
            }
        }else if (!d.equals(pyramid.d)){
            return false;
        }
        if(h == null){
            if (pyramid.h != null){
                return false;
            }
        }else if (!h.equals(pyramid.h)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + super.hashCode();
        result = prime * result + ((a == null) ? 0: a.hashCode());
        result = prime * result + ((b == null) ? 0: b.hashCode());
        result = prime * result + ((c == null) ? 0: c.hashCode());
        result = prime * result + ((d == null) ? 0: d.hashCode());
        result = prime * result + ((h == null) ? 0: h.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RightPyramid{");
        sb.append("id=").append(this.getId());
        sb.append(", a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", c=").append(c);
        sb.append(", d=").append(d);
        sb.append(", h=").append(h);
        sb.append('}');
        return sb.toString();
    }


}
