package Job4j.it.OOD.LSP.parking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParkingTest {

    Vehicle truck1 = new Truck("Andrew", 3, "Volvo");
    Vehicle truck2 = new Truck("Nikita", 2, "Kamaz");
    Vehicle car1 = new Car("bmw", "Nikita");
    Vehicle car2 = new Car("audi", "Andrew");
    Parking parking = new Parking(1, 10);

    @Test
    public void addVehicle() {
        parking.addVehicle(truck1);
        parking.addVehicle(truck2);
        parking.addVehicle(car1);
        parking.addVehicle(car2);
        List<Vehicle> vehicles = List.of(truck1, truck2, car1, car2);
        assertEquals(vehicles, parking.getVehicles());
    }
}