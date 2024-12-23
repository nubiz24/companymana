package screen;

import employee.Employee;
import employee.EmployeeManager;
import employee.Engineer;
import employee.Manager;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import work.Department;

import java.util.Optional;

public class EmployeeScreenController {
    private EmployeeManager employee;

    @FXML
    private TableColumn<Engineer, String> colDepartment;

    @FXML
    private TableColumn<Engineer, String> colMail;

    @FXML
    private TableColumn<Engineer, String> colName;

    @FXML
    private TableColumn<Engineer, String> colPhone;


    @FXML
    private TableColumn<Engineer, Double> colSalary;

    @FXML
    private TableView<Engineer> tblEmployee;

    @FXML
    private TableColumn<Manager, String> colDepartment1;

    @FXML
    private TableColumn<Manager, String> colMail1;

    @FXML
    private TableColumn<Manager, String> colName1;

    @FXML
    private TableColumn<Manager, String> colPhone1;


    @FXML
    private TableColumn<Manager, Double> colSalary1;

    @FXML
    private TableView<Manager> tblEmployee1;

    public EmployeeScreenController(EmployeeManager employee) {
        super();
        this.employee = employee;
    }

    @FXML
    public void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colMail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colDepartment.setCellValueFactory(cellData -> {
            // Kiểm tra nếu department là null, trả về chuỗi trống
            if (cellData.getValue().getDepartment() == null) {
                return new SimpleStringProperty(null); // Trả về chuỗi trống nếu department là null
            }
            // Nếu department không phải là null, trả về tên phòng ban
            return new SimpleStringProperty(cellData.getValue().getDepartment().getName());
        });

        tblEmployee.setItems(this.employee.getEngineers());


        colName1.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSalary1.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
        colPhone1.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colMail1.setCellValueFactory(new PropertyValueFactory<>("email"));
        colDepartment1.setCellValueFactory(cellData -> {
            // Kiểm tra nếu department là null, trả về chuỗi trống
            if (cellData.getValue().getDepartment() == null) {
                return new SimpleStringProperty(""); // Trả về chuỗi trống nếu department là null
            }
            // Nếu department không phải là null, trả về tên phòng ban
            return new SimpleStringProperty(cellData.getValue().getDepartment().getName());
        });

        tblEmployee1.setItems(this.employee.getManagers());
    }

    @FXML
    public void AddEngineer(ActionEvent event) {
        // Nhập tên nhân viên mới
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Employee");
        dialog.setHeaderText("Enter the name of the new employee:");
        Optional<String> result1 = dialog.showAndWait();

        if (result1.isPresent()) {
            String name = result1.get();

            // Nhập lương cơ bản
            dialog = new TextInputDialog();  // Tạo mới đối tượng dialog
            dialog.setTitle("Add Employee");
            dialog.setHeaderText("Enter base salary");
            Optional<String> result2 = dialog.showAndWait();

            if (result2.isPresent()) {
                String salaryStr = result2.get();
                double salary = 0;
                try {
                    salary = Double.parseDouble(salaryStr); // Chuyển đổi sang số thực
                } catch (NumberFormatException e) {
                    showAlert(Alert.AlertType.ERROR, "Invalid Salary", "Please enter a valid salary.");
                    return;
                }

                // Nhập số điện thoại
                dialog = new TextInputDialog();  // Tạo mới đối tượng dialog
                dialog.setTitle("Add Employee");
                dialog.setHeaderText("Enter phone number");
                Optional<String> result3 = dialog.showAndWait();

                if (result3.isPresent()) {
                    String phoneStr = result3.get();

                    // Nhập email
                    dialog = new TextInputDialog();  // Tạo mới đối tượng dialog
                    dialog.setTitle("Add Employee");
                    dialog.setHeaderText("Enter email");
                    Optional<String> result4 = dialog.showAndWait();

                    if (result4.isPresent()) {
                        String email = result4.get();

                        // Tạo nhân viên mới (Engineer) và thêm vào danh sách
                        Engineer newEngineer = new Engineer(0, name, salary, phoneStr, email, null, 0, 50);
                        employee.addEngineer(newEngineer); // Giả sử EmployeeManager có phương thức addEngineer

                        // Cập nhật bảng sau khi thêm
                        tblEmployee.setItems(this.employee.getEngineers());
                    }
                }
            }
        }
    }

    @FXML
    public void AddManager(ActionEvent event) {
        // Nhập tên nhân viên mới
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Employee");
        dialog.setHeaderText("Enter the name of the new employee:");
        Optional<String> result1 = dialog.showAndWait();

        if (result1.isPresent()) {
            String name = result1.get();

            // Nhập lương cơ bản
            dialog = new TextInputDialog();  // Tạo mới đối tượng dialog
            dialog.setTitle("Add Employee");
            dialog.setHeaderText("Enter base salary");
            Optional<String> result2 = dialog.showAndWait();

            if (result2.isPresent()) {
                String salaryStr = result2.get();
                double salary = 0;
                try {
                    salary = Double.parseDouble(salaryStr); // Chuyển đổi sang số thực
                } catch (NumberFormatException e) {
                    showAlert(Alert.AlertType.ERROR, "Invalid Salary", "Please enter a valid salary.");
                    return;
                }

                // Nhập số điện thoại
                dialog = new TextInputDialog();  // Tạo mới đối tượng dialog
                dialog.setTitle("Add Employee");
                dialog.setHeaderText("Enter phone number");
                Optional<String> result3 = dialog.showAndWait();

                if (result3.isPresent()) {
                    String phoneStr = result3.get();

                    // Nhập email
                    dialog = new TextInputDialog();  // Tạo mới đối tượng dialog
                    dialog.setTitle("Add Employee");
                    dialog.setHeaderText("Enter email");
                    Optional<String> result4 = dialog.showAndWait();

                    if (result4.isPresent()) {
                        String email = result4.get();

                        // Tạo nhân viên mới (Engineer) và thêm vào danh sách
                        Manager newManager = new Manager(0, name, salary, phoneStr, email, null, 0);
                        employee.addManager(newManager);

                        // Cập nhật bảng sau khi thêm
                        tblEmployee.setItems(this.employee.getEngineers());
                    }
                }
            }
        }
    }

    @FXML
    public void RemoveEngineer(ActionEvent event) {
        Engineer selectedEngineer = tblEmployee.getSelectionModel().getSelectedItem();
        if (selectedEngineer != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Remove Employee");
            alert.setHeaderText("Are you sure you want to remove the selected employee?");
            alert.setContentText("This action cannot be undone.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                employee.removeEngineer(selectedEngineer);
                tblEmployee.setItems(this.employee.getEngineers()); // Cập nhật bảng
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "No Employee Selected", "Please select an employee to remove.");
        }
    }

    @FXML
    public void RemoveManager(ActionEvent event) {
        Manager selectedManager = tblEmployee1.getSelectionModel().getSelectedItem();
        if (selectedManager != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Remove Employee");
            alert.setHeaderText("Are you sure you want to remove the selected employee?");
            alert.setContentText("This action cannot be undone.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                employee.removeManager(selectedManager);
                tblEmployee1.setItems(this.employee.getManagers()); // Cập nhật bảng
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "No Employee Selected", "Please select an employee to remove.");
        }
    }

    @FXML
    public void EditEngineer(ActionEvent event) {
        // Lấy nhân viên được chọn từ bảng
        Engineer selectedEngineer = tblEmployee.getSelectionModel().getSelectedItem();

        if (selectedEngineer != null) {
            // Hiển thị hộp thoại nhập liệu cho các trường cần chỉnh sửa, điền giá trị hiện tại vào các trường
            TextInputDialog nameDialog = new TextInputDialog(selectedEngineer.getName());
            nameDialog.setTitle("Edit Employee");
            nameDialog.setHeaderText("Edit the name of the employee:");
            Optional<String> nameResult = nameDialog.showAndWait();

            TextInputDialog salaryDialog = new TextInputDialog(String.valueOf(selectedEngineer.getBaseSalary()));
            salaryDialog.setTitle("Edit Salary");
            salaryDialog.setHeaderText("Edit the base salary:");
            Optional<String> salaryResult = salaryDialog.showAndWait();

            TextInputDialog phoneDialog = new TextInputDialog(String.valueOf(selectedEngineer.getPhone()));
            phoneDialog.setTitle("Edit Phone");
            phoneDialog.setHeaderText("Edit the phone number:");
            Optional<String> phoneResult = phoneDialog.showAndWait();

            TextInputDialog emailDialog = new TextInputDialog(selectedEngineer.getEmail());
            emailDialog.setTitle("Edit Email");
            emailDialog.setHeaderText("Edit the email address:");
            Optional<String> emailResult = emailDialog.showAndWait();

            // Kiểm tra nếu tất cả các trường đều có giá trị
            if (nameResult.isPresent() && salaryResult.isPresent() && phoneResult.isPresent() && emailResult.isPresent()) {
                // Cập nhật các giá trị của nhân viên
                selectedEngineer.setName(nameResult.get());
                selectedEngineer.setBaseSalary(Double.parseDouble(salaryResult.get()));
                selectedEngineer.setPhone(String.valueOf(Long.parseLong(phoneResult.get())));
                selectedEngineer.setEmail(emailResult.get());

                // Cập nhật lại danh sách và bảng
                tblEmployee.getItems().set(tblEmployee.getSelectionModel().getSelectedIndex(), selectedEngineer);
            }
        } else {
            // Nếu không có nhân viên nào được chọn, thông báo cho người dùng
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Employee Selected");
            alert.setHeaderText("Please select an employee to edit.");
            alert.showAndWait();
        }
    }

    @FXML
    public void EditManager(ActionEvent event) {
        // Lấy nhân viên được chọn từ bảng (bây giờ là Manager)
        Manager selectedManager = tblEmployee1.getSelectionModel().getSelectedItem();

        if (selectedManager != null) {
            // Hiển thị hộp thoại nhập liệu cho các trường cần chỉnh sửa, điền giá trị hiện tại vào các trường
            TextInputDialog nameDialog = new TextInputDialog(selectedManager.getName());
            nameDialog.setTitle("Edit Manager");
            nameDialog.setHeaderText("Edit the name of the manager:");
            Optional<String> nameResult = nameDialog.showAndWait();

            TextInputDialog salaryDialog = new TextInputDialog(String.valueOf(selectedManager.getBaseSalary()));
            salaryDialog.setTitle("Edit Salary");
            salaryDialog.setHeaderText("Edit the base salary:");
            Optional<String> salaryResult = salaryDialog.showAndWait();

            TextInputDialog phoneDialog = new TextInputDialog(String.valueOf(selectedManager.getPhone()));
            phoneDialog.setTitle("Edit Phone");
            phoneDialog.setHeaderText("Edit the phone number:");
            Optional<String> phoneResult = phoneDialog.showAndWait();

            TextInputDialog emailDialog = new TextInputDialog(selectedManager.getEmail());
            emailDialog.setTitle("Edit Email");
            emailDialog.setHeaderText("Edit the email address:");
            Optional<String> emailResult = emailDialog.showAndWait();

            // Kiểm tra nếu tất cả các trường đều có giá trị
            if (nameResult.isPresent() && salaryResult.isPresent() && phoneResult.isPresent() && emailResult.isPresent()) {
                try {
                    // Cập nhật các giá trị của manager
                    selectedManager.setName(nameResult.get());
                    selectedManager.setBaseSalary(Double.parseDouble(salaryResult.get()));
                    selectedManager.setPhone(String.valueOf(Long.parseLong(phoneResult.get())));
                    selectedManager.setEmail(emailResult.get());

                    // Cập nhật lại danh sách và bảng
                    tblEmployee1.getItems().set(tblEmployee1.getSelectionModel().getSelectedIndex(), selectedManager);
                } catch (NumberFormatException e) {
                    // Nếu có lỗi khi chuyển đổi số (ví dụ: chuỗi điện thoại không hợp lệ)
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Input");
                    alert.setHeaderText("Phone number is invalid.");
                    alert.setContentText("Please enter a valid phone number.");
                    alert.showAndWait();
                }
            }
        } else {
            // Nếu không có manager nào được chọn, thông báo cho người dùng
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Manager Selected");
            alert.setHeaderText("Please select a manager to edit.");
            alert.showAndWait();
        }
    }


    // Phương thức hiển thị thông báo lỗi
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }



}
