package screen;

import employee.EmployeeManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import work.Department;

public class DepartmentScreenController {
    private EmployeeManager department;

    @FXML
    private TableColumn<Department, String> colManager;

    @FXML
    private TableColumn<Department, String> colName;

    @FXML
    private TableColumn<Department, String> colProject;

    @FXML
    private TableColumn<Department, String> colQuantity;

    @FXML
    private TableView<Department> tblDepartment;

    public DepartmentScreenController(EmployeeManager department) {
        super();
        this.department = department;
    }

    @FXML
    public void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQuantity.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getEmployeeCount())));
        colManager.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getHead().getName()));
        colProject.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getProject().getName()));
        tblDepartment.setItems(this.department.getDepartments());
    }
}
