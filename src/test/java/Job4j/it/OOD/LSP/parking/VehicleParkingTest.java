package Job4j.it.OOD.LSP.parking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class VehicleParkingTest {

    Vehicle truck1 = new Truck("Andrew", 3, "Volvo");
    Vehicle truck2 = new Truck("Nikita", 2, "Kamaz");
    Vehicle car1 = new Car("bmw", "Nikita");
    Vehicle car2 = new Car("audi", "Andrew");


    @Test
    public void addManyVehicles() {
        VehicleParking parking = new VehicleParking(1, 10);
        parking.addVehicle(truck1);
        parking.addVehicle(truck2);
        parking.addVehicle(car1);
        parking.addVehicle(car2);
        List<Vehicle> vehicles = List.of(truck1, truck2, car1, car2);
        assertEquals(vehicles, parking.getVehicles());
    }
    @Test
    public void add2ManyTrucks() {
        VehicleParking parking = new VehicleParking(0, 5);
        parking.addVehicle(truck1);
        parking.addVehicle(car1);
        parking.addVehicle(car2);
        parking.addVehicle(truck2);
        List<Vehicle> vehicles = List.of(truck1, car1, car2);
        assertEquals(vehicles, parking.getVehicles());
    }

    @Test
    public void add2ManyCars() {
        VehicleParking parking = new VehicleParking(0, 4);
        parking.addVehicle(truck1);
        parking.addVehicle(car1);
        parking.addVehicle(car2);
        parking.addVehicle(truck2);
        List<Vehicle> vehicles = List.of(truck1, car1);
        assertEquals(vehicles, parking.getVehicles());
    }

}