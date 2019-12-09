public class Main {

    public static int amountOfRightTriangle = 0;
    public static int amountOfIsoscelesTriangle = 0;
    public static int amountOfEquilateralTriangle = 0;

    public static void main(String[] args) {

        Triangle rightTriangle = new Triangle(new Point(0,0), new Point(0,3), new Point(3, 0));
        Triangle isoscelesTriangle = new Triangle(new Point(0, 3), new Point(-2, -3), new Point(-6, 1));
        Triangle equilateralTriangle = new Triangle(new Point(0,1), new Point(1, 0), new Point(0, 0));
        Triangle sampleTriangle = new Triangle(new Point(-4, 0), new Point(0,6), new Point(3, 0));

        Triangle[] triangles = new Triangle[]{rightTriangle, isoscelesTriangle, equilateralTriangle, sampleTriangle};

        for (int i=0; i<triangles.length; i++) {
            triangles[i].setSides();
            print(triangles[i], i+1);
            getTypeOfTriangle(triangles[i]);
        }
        System.out.println("\nAmount of right triangles: " + amountOfRightTriangle);
        System.out.println("Amount of isosceles triangles: " + amountOfIsoscelesTriangle);
        System.out.println("Amount of equilateral triangles: " + amountOfEquilateralTriangle);
    }

    public static void print(Triangle triangle, int number){
        System.out.println("Triangle #" + number + ": perimeter = " + triangle.getPerimeter() +
                ", square = " + triangle.getSquare());
    }

    public static void getTypeOfTriangle(Triangle triangle){
        if(triangle.isEquilateral()){
            amountOfIsoscelesTriangle++;
            amountOfEquilateralTriangle++;
        }
        else if(triangle.isIsosceles()){
            amountOfIsoscelesTriangle++;
        }
        if(triangle.isRight()){
            amountOfRightTriangle++;
        }
    }
}
