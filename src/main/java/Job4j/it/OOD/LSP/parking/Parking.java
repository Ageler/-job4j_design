package Job4j.it.OOD.LSP.parking;

public interface Parking {
    private boolean addCar(Car car) {
        return false;
    }

    private boolean addTruck(Truck truck) {
        return false;
    }

    void addVehicle(Vehicle vehicle);
}
