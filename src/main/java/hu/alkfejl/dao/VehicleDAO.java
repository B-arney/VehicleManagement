package hu.alkfejl.dao;

import hu.alkfejl.model.Vehicle;

import java.util.Collection;

public interface VehicleDAO {
    boolean add(Vehicle vehicle);
    Collection<Vehicle> findAll();
}
