public class Runner {

    public static void main(String[] args) {
        Car[] cars = new Car[]{
                new Car(1, "Fiat", "500L", 2017, "Black", 3000, "BM6452BA"),
                new Car(2, "Fiat", "124 Spider", 2016, "Blue", 7000, "AX7452AC"),
                new Car(3, "Nissan", "GT-R", 2014, "Red", 12000, "AA8732AC"),
                new Car(4, "Skoda", "Fabia", 2015, "Red", 4000, "AI2342AC"),
                new Car(5, "Nissan", "Frontier Crew", 2016, "Blue", 5000, "AM8831AC"),
                new Car(6, "Fiat", "500L", 2012, "Black", 2500, "AX1152BA")
        };

        CarProcessor carProcessor = new CarProcessor(cars);
        System.out.println("Cars brand 'Nissan':");
        carProcessor.findCarByBrand("Nissan");
        System.out.println("\nCars by model 'Fabia' and more than 3 year in operation:");
        carProcessor.findCarByModel("Fabia", 3);
        System.out.println("\nCars made in 2012 and price more than 2000:");
        carProcessor.findCarByYear(2012, 2000);

        System.out.println();

        CarProcessor carProcessorDefault = new CarProcessor();
        System.out.println("Cars brand 'Fiat':");
        carProcessorDefault.findCarByBrand(cars, "Fiat");
        System.out.println("\nCars by model '500L and more than 4 year in operation:");
        carProcessorDefault.findCarByModel(cars, "500L", 4);
        System.out.println("\nCars made in 2016 and price more than 6000$:");
        carProcessorDefault.findCarByYear(cars, 2016, 6000);
    }
}
