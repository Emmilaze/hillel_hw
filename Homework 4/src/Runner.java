public class Runner {

    public static void main(String[] args) {
        CarProcessor carProcessor = new CarProcessor();
        Car[] cars = new Car[]{
                new Car(1, "Fiat", "500L", 2017, "Black", 3000, "BM6452BA"),
                new Car(2, "Fiat", "124 Spider", 2016, "Blue", 7000, "AX7452AC"),
                new Car(3, "Nissan", "GT-R", 2014, "Red", 12000, "AA8732AC"),
                new Car(4, "Skoda", "Fabia", 2015, "Red", 4000, "AI2342AC"),
                new Car(5, "Nissan", "Frontier Crew", 2016, "Blue", 5000, "AM8831AC"),
                new Car(6, "Fiat", "500L", 2012, "Black", 2500, "AX1152BA")
        };

        System.out.println("Cars brand 'Fiat':");
        carProcessor.findCarByBrand(cars, "Fiat");
        System.out.println("\nCars by model '500L and more than 4 year in operation:");
        carProcessor.findCarByModel(cars, "500L", 4);
        System.out.println("\nCars made in 2016 and price more than 6000$:");
        carProcessor.findCarByYear(cars, 2016, 6000);


    }

}
