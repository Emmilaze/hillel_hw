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

    public void setSides() {
        ab = setAb();
        bc = setBc();
        ac = setAc();
    }

    public int getVector(int firstNumber, int secondNumber) {
        return secondNumber - firstNumber;
    }

    private int setAb() {
        return getDistance(getVector(b.getX(), a.getX()), getVector(b.getY(), a.getY()));
    }

    private int setBc() {
        return getDistance(getVector(c.getX(), b.getX()), getVector(c.getY(), b.getY()));
    }

    private int setAc() {
        return getDistance(getVector(c.getX(), a.getX()), getVector(c.getY(), a.getY()));
    }

    private int getDistance(double firstNumber, double secondNumber) {
        return (int) Math.sqrt(Math.pow(firstNumber, 2) + Math.pow(secondNumber, 2));
    }

    public double getPerimeter() {
        return ab + bc + ac;
    }

    public double getSquare() {
        double halfPerimeter = getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - ab) * (halfPerimeter - bc) * (halfPerimeter - ac));
    }

    public boolean isIsosceles() {
        if (isEquilateral())
            return true;
        if (ab == bc)
            return true;
        else if (bc == ac)
            return true;
        return false;
    }

    public boolean isEquilateral() {
        return ab == bc && bc == ac;
    }

    public boolean isRight() {
        if ((ab * ab + bc * bc == ac * ac) || (ab * ab + ac * ac == bc * bc) || (bc * bc + ac * ac == ab * ab))
            return true;
        return false;
    }
}
