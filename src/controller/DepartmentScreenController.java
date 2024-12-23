package controller;

import employee.Employee;
import employee.EmployeeManager;
import employee.Engineer;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import work.Department;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

import java.awt.event.ActionEvent;

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
    private TableColumn<Engineer, String> colMail1;

    @FXML
    private TableColumn<Engineer, String> colName1;

    @FXML
    private TableColumn<Engineer, String> colPhone1;

    @FXML
    private TableColumn<Engineer, Double> colSalary1;


    @FXML
    private TableView<Engineer> tblMembers;

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
        colName1.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMail1.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone1.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colSalary1.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
    }
    @FXML
    public void ViewAction() {
        Department selectedDepartment = tblDepartment.getSelectionModel().getSelectedItem(); // Lấy phòng ban được chọn
        ObservableList<Engineer> members = selectedDepartment.getMembers();
        if (selectedDepartment != null) {
            // Cập nhật bảng thành viên với danh sách thành viên của phòng ban được chọn
            tblMembers.setItems(members); // Cập nhật bảng thành viên
        }
    }


    @FXML
    public void removeFromDepartment() {
        // Lấy phòng ban được chọn từ bảng phòng ban
        Department selectedDepartment = tblDepartment.getSelectionModel().getSelectedItem();

        // Lấy nhân viên được chọn từ bảng thành viên
        Engineer selectedEmployee = tblMembers.getSelectionModel().getSelectedItem();

        // Kiểm tra nếu phòng ban và nhân viên được chọn hợp lệ
        if (selectedDepartment != null && selectedEmployee != null) {
            // Nếu nhân viên là một Engineer, thực hiện xóa khỏi phòng ban
            if (selectedEmployee instanceof Engineer) {
                selectedDepartment.removeMember((Engineer) selectedEmployee);

                // Cập nhật lại danh sách thành viên trong bảng
                tblMembers.setItems(selectedDepartment.getMembers());

                // Cập nhật lại bảng phòng ban để thay đổi số lượng nhân viên
                tblDepartment.refresh();  // Cập nhật lại bảng phòng ban

                // Hiển thị thông báo thành công
                showAlert("Thành công", "Nhân viên " + selectedEmployee.getName() + " đã bị xóa khỏi phòng ban " + selectedDepartment.getName(), AlertType.INFORMATION);
            } else {
                // Hiển thị thông báo lỗi nếu nhân viên không phải là Engineer
                showAlert("Lỗi", "Không thể xóa trưởng phòng (Manager) khỏi phòng ban.", AlertType.ERROR);
            }
        } else {
            // Hiển thị thông báo lỗi nếu không có phòng ban hoặc nhân viên được chọn
            showAlert("Lỗi", "Chưa chọn phòng ban hoặc nhân viên.", AlertType.WARNING);
        }
    }

    // Phương thức hiển thị Alert
    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);  // Đặt null cho header
        alert.setContentText(message);  // Thiết lập nội dung của thông báo

        // Hiển thị Alert và chờ người dùng đóng
        alert.showAndWait();
    }


}
