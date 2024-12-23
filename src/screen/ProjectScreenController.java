package screen;

import employee.EmployeeManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import work.Department;
import work.Project;

public class ProjectScreenController {
    private EmployeeManager project;

    @FXML
    private TableColumn<Project, String> colDeadline;

    @FXML
    private TableColumn<Project, String> colDepartment;

    @FXML
    private TableColumn<Project, String> colName;

    @FXML
    private TableColumn<Project, String> colQuantity;

    @FXML
    private TableView<Project> tblProject;

    public ProjectScreenController(EmployeeManager project) {
        super();
        this.project = project;
    }

    @FXML
    public void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQuantity.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getTaskCount())));
        colDepartment.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDepartment().getName()));
        colDeadline.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        tblProject.setItems(this.project.getProjects());
    }
}
