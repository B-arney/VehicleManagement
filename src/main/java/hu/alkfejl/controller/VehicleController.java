package hu.alkfejl.controller;

import hu.alkfejl.dao.VehicleDAO;
import hu.alkfejl.dao.VehicleSQLiteDAO;
import hu.alkfejl.model.Vehicle;

import java.util.Collection;

public class VehicleController {

    private VehicleDAO dao;

    private VehicleController(){
        this.dao = VehicleSQLiteDAO.getInstance();
    }

    private static final class  InstanceHolder{
        private static final VehicleController INSTANCE = new VehicleController();
    }

    public static VehicleController getInstance(){
        return InstanceHolder.INSTANCE;
    }

    public boolean add(Vehicle vehicle){
        return dao.add(vehicle);
    }

    public Collection<Vehicle> findAll(){
        return dao.findAll();
    }

}
