package hu.alkfejl.dao;

import hu.alkfejl.model.Vehicle;
import hu.alkfejl.util.ConfigManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.management.Query;
import java.sql.*;


public class VehicleSQLiteDAO implements VehicleDAO{

    private static String CONNSTR;

    private VehicleSQLiteDAO(){
        try{
            CONNSTR = ConfigManager.getValue("db.path");
            Class.forName("org.sqlite.JDBC");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private static final class InstanceHolder{
        private static final VehicleSQLiteDAO INSTANCE = new VehicleSQLiteDAO();
    }

    public static VehicleSQLiteDAO getInstance(){
        return InstanceHolder.INSTANCE;
    }

@Override
public boolean add(Vehicle vehicle) {
    try(Connection conn = DriverManager.getConnection(CONNSTR);
        PreparedStatement stmt = conn.prepareStatement(Query.INSERT.getQuery(), Statement.RETURN_GENERATED_KEYS)){

        stmt.setString(1, vehicle.getLicencePlate());
        stmt.setInt(2, vehicle.isActive() ? 1 : 0);
        stmt.setString(3, vehicle.getCategory().name());
        stmt.setInt(4, vehicle.getAge());

        return stmt.executeUpdate() > 0;

    }catch (SQLException e){
        System.err.println("INSERT failed, see details:" + System.lineSeparator());
        e.printStackTrace(System.err);
    }
    return false;
}

@Override
public ObservableList<Vehicle> findAll() {

    ObservableList<Vehicle> result = FXCollections.observableArrayList();
    try(Connection conn = DriverManager.getConnection(CONNSTR);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(Query.SELECT.getQuery())){

        while(rs.next()){
            Vehicle vehicle = new Vehicle();

            vehicle.setLicencePlate(rs.getString("plate"));
            vehicle.setActive(rs.getInt("active") == 1);
            vehicle.setCategory(Vehicle.Category.valueOf(rs.getString("category")));
            vehicle.setAge(rs.getInt("age"));

            result.add(vehicle);
        }

    }catch (SQLException e){
        e.printStackTrace();
    }

    return result;
}

private enum Query{
    SELECT("SELECT * FROM vehicle; --"),
    INSERT("INSERT INTO vehicle(plate, active, category, age) VALUES(?, ?, ?, ?); --");

        private String query;

        Query(String query) {
            this.query = query;
        }

        public String getQuery() {
            return query;
        }
    }
}
