package Job4j.it.OOD.LSP.parking;

public interface AbstractParking {
    boolean addCar(Car car);
    boolean addTruck(Truck truck);
    void addVehicle(Vehicle vehicle);
}
