public class TriangleProcessor {
    private static Triangle[] rightTriangles = new Triangle[4];
    private static int amountOfRightTriangle = 0;
    private static Triangle[] isoscelesTriangles = new Triangle[4];
    private static int amountOfIsoscelesTriangles = 0;
    private static Triangle[] equilateralTriangles = new Triangle[4];
    private static int amountOfEquilateralTriangles = 0;
    private static Triangle[] simpleTriangles = new Triangle[4];
    private static int amountOfSimpleTriangles = 0;

    public static void allocation(Triangle[] triangles) {
        for (int i = 0; i < triangles.length; i++) {
            print(triangles[i], i + 1);
            getTypeOfTriangle(triangles[i]);
        }

        System.out.println("\nAmount of right triangles: " + amountOfRightTriangle);
        System.out.println("Amount of isoscelesTriangles: " + amountOfIsoscelesTriangles);
        System.out.println("Amount of equilateral triangles: " + amountOfEquilateralTriangles);
        System.out.println("Amount of simple triangles: " + amountOfSimpleTriangles);
    }

    private static void print(Triangle triangle, int number) {
        System.out.println("Triangle #" + number + ": perimeter = " + triangle.getPerimeter() +
                ", square = " + triangle.getSquare());
    }

    private static void getTypeOfTriangle(Triangle triangle) {
        if (triangle.isEquilateral()) {
            equilateralTriangles[amountOfEquilateralTriangles++] = triangle;
            isoscelesTriangles[amountOfIsoscelesTriangles++] = triangle;
        } else if (triangle.isIsosceles()) {
            isoscelesTriangles[amountOfIsoscelesTriangles++] = triangle;
        } else if (triangle.isRight()) {
            rightTriangles[amountOfRightTriangle++] = triangle;
        } else {
            simpleTriangles[amountOfSimpleTriangles++] = triangle;
        }
    }

    public static void printGroups() {
        findMinMaxValues(rightTriangles, "right triangles");
        findMinMaxValues(isoscelesTriangles, "isosceles triangles");
        findMinMaxValues(equilateralTriangles, "equilateral triangles");
        findMinMaxValues(simpleTriangles, "simple triangles");
    }

    private static void findMinMaxValues(Triangle[] triangles, String group) {
        double maxPerimeter = 0;
        double minPerimeter = Double.MAX_VALUE;

        double maxSquare = 0;
        double minSquare = Double.MAX_VALUE;

        for (int i = 0; i < triangles.length; i++) {
            if (triangles[i] != null) {
                if (triangles[i].getPerimeter() >= maxPerimeter) {
                    maxPerimeter = triangles[i].getPerimeter();
                }

                if (triangles[i].getPerimeter() <= minPerimeter) {
                    minPerimeter = triangles[i].getPerimeter();
                }

                if (triangles[i].getSquare() >= maxSquare) {
                    maxSquare = triangles[i].getSquare();
                }

                if (triangles[i].getSquare() >= minSquare) {
                    minSquare = triangles[i].getSquare();
                }
            }
        }
        System.out.println("\nThe biggest perimeter in " + group + " group is " + maxPerimeter);
        System.out.println("The smallest perimeter in " + group + " group is " + minPerimeter);
        System.out.println("The biggest square in " + group + " group is " + maxSquare);
        System.out.println("The smallest square in " + group + " group is " + minSquare);
    }
}
