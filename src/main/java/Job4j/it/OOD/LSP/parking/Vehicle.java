package Job4j.it.OOD.LSP.parking;

import lombok.Data;

@Data
public abstract class Vehicle {
 private int size;
 private String model;
 private String owner;

 public Vehicle(int size, String model, String owner) {
  this.size = size;
  this.model = model;
  this.owner = owner;
 }


}
