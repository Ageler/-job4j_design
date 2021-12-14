package Job4j.it.OOD.LSP.parking;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class VehicleParking implements Parking {
    private final int allTruckPlaces;
    private final int allCarPlaces;
    private List<Vehicle> vehicles;
    private int emptyCarPlaces;
    private int emptyTruckPlaces;


    public VehicleParking(int allTruckPlaces, int allCarPlaces) {
        this.allTruckPlaces = allTruckPlaces;
        this.allCarPlaces = allCarPlaces;
        emptyCarPlaces = allCarPlaces;
        emptyTruckPlaces = allTruckPlaces;
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicles == null) {
            vehicles = new ArrayList<>();
        }
        if (vehicle.getSize() == 1 && emptyCarPlaces > 0) {
            vehicles.add(vehicle);
            emptyCarPlaces--;
        } else if (vehicle.getSize() > 1) {
            if (emptyTruckPlaces > 0) {
                vehicles.add(vehicle);
                emptyTruckPlaces--;
            } else if (emptyCarPlaces - vehicle.getSize() >= 0) {
                vehicles.add(vehicle);
                emptyCarPlaces -= vehicle.getSize();
            } else {
                System.out.println("no available places for " + vehicle.getModel());
            }
        } else {
            System.out.println("no available places for " + vehicle.getModel());
        }
    }
}

