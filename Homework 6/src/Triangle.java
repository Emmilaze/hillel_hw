public class Triangle {
    private final Point a;
    private final Point b;
    private final Point c;
    private int ab;
    private int bc;
    private int ac;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public boolean isIsosceles() {
        if (a == b)
            return true;
        else if (b == c)
            return true;
        else if (a == c)
            return true;
        return false;
    }

    public boolean isEquilateral() {
        return a == b && a == c;
    }

    public boolean isRight() {
        if(a*a+b*b == c*c)
            return true;

    }
}
