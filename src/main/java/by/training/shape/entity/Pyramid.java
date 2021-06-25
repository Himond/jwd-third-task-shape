package by.training.shape.entity;


import by.training.shape.util.IdGenerator;

public class Pyramid extends Shape{

    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private Point h;

    public Pyramid() {
        super(IdGenerator.generateId());
    }

    public Pyramid(Point ... points) {
        super(IdGenerator.generateId());
        this.a = points[0];
        this.b = points[1];
        this.c = points[2];
        this.d = points[3];
        this.h = points[4];
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
        result = prime * result + getId();
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
        sb.append("a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", c=").append(c);
        sb.append(", d=").append(d);
        sb.append(", s=").append(h);
        sb.append('}');
        return sb.toString();
    }
}
