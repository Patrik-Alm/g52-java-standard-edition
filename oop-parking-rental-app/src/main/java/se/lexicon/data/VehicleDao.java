package se.lexicon.data;

import se.lexicon.model.Vehicle;

import java.util.Collection;

public interface VehicleDao {
    Vehicle create(Vehicle vehicle);

    Vehicle findByLicensePlate(String licensePlate);

    boolean remove(String licensePlate);

    Vehicle update(Vehicle vehicle);

    Collection<Vehicle> findAll();
}
