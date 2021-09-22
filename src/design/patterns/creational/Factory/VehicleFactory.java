package design.patterns.creational.Factory;

public class VehicleFactory {
    public Vehicle build(VehicleType vehicleType) {
        switch (vehicleType) {
            case TWO_WHEELER:
                return new TwoWheeler();

            case FOUR_WHEELER:
                return new FourWheeler();

            default:
                return null;
        }
    }
}
