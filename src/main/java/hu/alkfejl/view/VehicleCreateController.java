package hu.alkfejl.view;

import hu.alkfejl.controller.VehicleController;
import hu.alkfejl.model.Vehicle.Category;
import hu.alkfejl.model.Vehicle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VehicleCreateController implements Initializable {

    @FXML
    private TextField plateField;

    @FXML
    private ComboBox<Category> categoryBox;

    @FXML
    private Spinner<Integer> ageSpinner;

    @FXML
    private CheckBox activeCheck;

    private final VehicleController controller = VehicleController.getInstance();

    @FXML
    private void save() {

        String plate = plateField.getText();
        Category category = categoryBox.getValue();
        boolean active = activeCheck.isSelected();
        int age = ageSpinner.getValue();

        if (plate == null || plate.isBlank() || category == null) {
            showError("Minden mező kötelező!");
            return;
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setLicencePlate(plate);
        vehicle.setActive(active);
        vehicle.setCategory(category);
        vehicle.setAge(age);

        if (controller.add(vehicle)) {
            Stage stage = (Stage) activeCheck.getScene().getWindow();
            stage.close();
        } else {
            showError("Mentési hiba");
        }
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR, msg);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryBox.getItems().addAll(Category.values());
        ageSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
    }
}