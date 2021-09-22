package design.patterns.creational.Factory;

public class Demo {
    public static void main(String[] args) {

        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle two_wheeler = vehicleFactory.build(VehicleType.TWO_WHEELER);
        Vehicle four_wheeler = vehicleFactory.build(VehicleType.FOUR_WHEELER);
        two_wheeler.start();
        four_wheeler.start();
        System.out.println(two_wheeler);
        System.out.println(four_wheeler);

        // Factory method creates objects without specifying the exact class to create.
        // Factory pattern introduces loose coupling between classes
        // Here type of class returned should not impact client as long they extend Factory
        // Abstract factory groups object factories that have a common theme.
        // Abstract Factory adds secondary level of Abstraction to factory, for example:
        // VehicleFactory indianVehicleFactory = new VehicleFactory(Location.INDIA);
        // Vehicle two_wheeler = indianVehicleFactory.build(VehicleType.TWO_WHEELER);

    }
}
