package se.lexicon.impl;

import se.lexicon.data.VehicleDao;
import se.lexicon.model.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VehicleDaoImpl implements VehicleDao {

    //Map Example 😎
    // A map to store vehicles where the key is the license plate
    private Map<String, Vehicle> vehicles = new HashMap<>();

    @Override
    public Vehicle create(Vehicle vehicle) {
        // Check if a vehicle with the same license plate already exists
        if (vehicles.containsKey(vehicle.getLicensePlate())) {
            throw new IllegalArgumentException("A vehicle with this license plate already exists.");
        }
        // Add the vehicle to the map
        vehicles.put(vehicle.getLicensePlate(), vehicle);
        return vehicle;
    }

    @Override
    public Vehicle findByLicensePlate(String licensePlate) {
        // Retrieve a vehicle by its license plate
        return vehicles.get(licensePlate);
    }

    @Override
    public boolean remove(String licensePlate) {
        // Remove a vehicle from the map and return whether the operation was successful
        return vehicles.remove(licensePlate) != null;
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        // Check if the vehicle exists
        if (!vehicles.containsKey(vehicle.getLicensePlate())) {
            throw new IllegalArgumentException("The vehicle does not exist.");
        }
        // Update the vehicle
        vehicles.put(vehicle.getLicensePlate(), vehicle);
        return vehicle;
    }

    @Override
    public Collection<Vehicle> findAll() {
        // Return all vehicles as a list
        return new ArrayList<>(vehicles.values());
    }
}
