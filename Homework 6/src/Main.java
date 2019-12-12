public class Main {

    public static void main(String[] args) {

        Triangle rightTriangle = new Triangle(new Point(0, 0), new Point(0, 4), new Point(3, 0));
        Triangle isoscelesTriangle = new Triangle(new Point(0, 3), new Point(-2, -3), new Point(-6, 1));
        Triangle equilateralTriangle = new Triangle(new Point(0, 1), new Point(1, 0), new Point(0, 0));
        Triangle simpleTriangle = new Triangle(new Point(-1, 0), new Point(5, 0), new Point(4, 5));

        Triangle[] triangles = new Triangle[]{rightTriangle, isoscelesTriangle, equilateralTriangle, simpleTriangle};

        TriangleProcessor.allocation(triangles);
        TriangleProcessor.printGroups();
    }
}
