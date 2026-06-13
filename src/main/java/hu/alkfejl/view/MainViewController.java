package hu.alkfejl.view;

import hu.alkfejl.controller.VehicleController;
import hu.alkfejl.model.Vehicle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private TableView<Vehicle> table;

    @FXML
    private TableColumn<Vehicle, String> plateCol;

    @FXML
    private TableColumn<Vehicle, String> categoryCol;

    @FXML
    private TableColumn<Vehicle, Integer> ageCol;

    @FXML
    private TableColumn<Vehicle, Boolean> activeCol;

    private final VehicleController controller = VehicleController.getInstance();

    private void load() {
        table.setItems(
                FXCollections.observableArrayList(controller.findAll())
        );
    }

    @FXML
    private void openCreate() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/hu/alkfejl/view/vehicle-create-view.fxml")
        );

        Stage stage = new Stage();
        stage.setTitle("Új jármű");
        stage.setScene(new Scene(loader.load()));
        stage.showAndWait();

        // visszatérés után frissítünk
        load();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        plateCol.setCellValueFactory(new PropertyValueFactory<>("licencePlate"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        activeCol.setCellValueFactory((new PropertyValueFactory<>("active")));

        load();
    }
}