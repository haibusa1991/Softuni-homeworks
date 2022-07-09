package lecture03Inheritance.E04NeedForSpeed;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle= new Vehicle(50,50);
        Vehicle motorcycle= new Motorcycle(50,50);
        RaceMotorcycle raceMotorcycle = new RaceMotorcycle(50, 50);
        Vehicle crossMoto = new CrossMotorcycle(50,50);
        Vehicle Car = new Car(50,50);
        Vehicle familyCar = new FamilyCar(50,50);
        Vehicle sportCar = new SportCar(50,50);

        System.out.println();
    }
}
