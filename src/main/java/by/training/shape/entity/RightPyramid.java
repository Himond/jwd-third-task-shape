package by.training.shape.entity;


public class RightPyramid extends Shape{

    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private Point s;


    public RightPyramid(int id) {
        super(id, "RightPyramid");
    }

    public RightPyramid(int id, Point ... points) {
        super(id, "RightPyramid");
        this.a = points[0];
        this.b = points[1];
        this.c = points[2];
        this.d = points[3];
        this.s = points[4];
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

    public Point getS() {
        return s;
    }

    public void setS(Point s) {
        this.s = s;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RightPyramid pyramid = (RightPyramid) o;

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
        if(s == null){
            if (pyramid.s != null){
                return false;
            }
        }else if (!s.equals(pyramid.s)){
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
        result = prime * result + ((s == null) ? 0: s.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RightPyramid{");
        sb.append("a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", c=").append(c);
        sb.append(", d=").append(d);
        sb.append(", s=").append(s);
        sb.append('}');
        return sb.toString();
    }
}
