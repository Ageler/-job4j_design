package Job4j.it.OOD.LSP.parking;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Parking implements AbstractParking{
    private final int allTruckPlaces;
    private final int allCarPlaces;
    private List<Vehicle> vehicles;
    private int emptyCarPlaces;
    private int emptyTruckPlaces;


    public Parking(int allTruckPlaces, int allCarPlaces) {
        this.allTruckPlaces = allTruckPlaces;
        this.allCarPlaces = allCarPlaces;
        emptyCarPlaces = allCarPlaces;
        emptyTruckPlaces = allTruckPlaces;
    }

    public boolean addCar(Car car) {
        if (vehicles == null) {
            vehicles = new ArrayList<>();
        }
        if (emptyCarPlaces > 0) {
            vehicles.add(car);
            emptyCarPlaces--;
            return true;
        } else {
            System.out.println("no available places");
        }
        return false;
    }

    public boolean addTruck(Truck truck) {
        if (vehicles == null) {
            vehicles = new ArrayList<>();
        }
        if (emptyTruckPlaces > 0) {
            vehicles.add(truck);
            emptyTruckPlaces--;
            return true;
        } else if (emptyCarPlaces - truck.getSize() >= 0) {
            vehicles.add(truck);
            emptyCarPlaces -= truck.getSize();
            return true;
        } else {
            System.out.println("no available places");
            return false;
        }
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle.getSize() > 1) {
            addTruck((Truck) vehicle);
        } else if (vehicle.getSize() == 1) {
            addCar((Car) vehicle);
        }
    }

}

