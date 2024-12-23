package controller;

import employee.EmployeeManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import work.Project;
import work.Task;

public class ProjectScreenController {
    private EmployeeManager project;

    @FXML
    private TableColumn<Project, String> colDeadline;

    @FXML
    private TableColumn<Project, String> colDepartment;

    @FXML
    private TableColumn<Task, String> colDeadline1;

    @FXML
    private TableColumn<Task, String> colDescription;

    @FXML
    private TableColumn<Task, String> colProgress;

    @FXML
    private TableColumn<Project, String> colName;

    @FXML
    private TableColumn<Project, String> colQuantity;

    @FXML
    private TableView<Task> tblTask;

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

        colDeadline1.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colProgress.setCellValueFactory(cellData -> new SimpleStringProperty("undone"));
    }
    @FXML
    public void ViewAction() {
        // Lấy project được chọn
        Project selectedProject = tblProject.getSelectionModel().getSelectedItem();

        // Kiểm tra nếu project được chọn hợp lệ
        if (selectedProject != null) {
            // Lấy danh sách tasks của project
            ObservableList<Task> tasks = (ObservableList<Task>) selectedProject.getTasks();

            // Cập nhật bảng tasks với danh sách tasks của project
            tblTask.setItems(tasks);
        } else {
            // Hiển thị thông báo nếu chưa chọn project
            showAlert("Lỗi", "Chưa chọn project.", Alert.AlertType.WARNING);
        }
    }
    // Phương thức hiển thị Alert
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);  // Đặt null cho header
        alert.setContentText(message);  // Thiết lập nội dung của thông báo
        alert.showAndWait();  // Hiển thị Alert và chờ người dùng đóng
    }

    @FXML
    public void createTask() {
        // Lấy project đang được xem
        Project selectedProject = tblProject.getSelectionModel().getSelectedItem();

        // Kiểm tra nếu project được chọn hợp lệ
        if (selectedProject != null) {
            // Lấy thông tin từ người dùng (bạn có thể sử dụng các hộp thoại để nhập thông tin)
            // Ví dụ ở đây dùng hộp thoại nhập mô tả và hạn hoàn thành (Bạn có thể thay đổi theo yêu cầu thực tế)
            TextInputDialog descriptionDialog = new TextInputDialog();
            descriptionDialog.setTitle("Nhập mô tả");
            descriptionDialog.setHeaderText("Mô tả nhiệm vụ");
            descriptionDialog.setContentText("Nhập mô tả nhiệm vụ:");

            String description = descriptionDialog.showAndWait().orElse("");

            TextInputDialog deadlineDialog = new TextInputDialog();
            deadlineDialog.setTitle("Nhập hạn hoàn thành");
            deadlineDialog.setHeaderText("Hạn hoàn thành nhiệm vụ");
            deadlineDialog.setContentText("Nhập hạn hoàn thành:");

            String deadline = deadlineDialog.showAndWait().orElse("");

            if (!description.isEmpty() && !deadline.isEmpty()) {
                // Tạo nhiệm vụ mới
                Task newTask = new Task(selectedProject.getTasks().size() + 1, description, deadline, selectedProject);

                // Thêm nhiệm vụ vào dự án
                selectedProject.addTask(newTask);

                // Cập nhật bảng nhiệm vụ
                tblTask.setItems(selectedProject.getTasks());
                tblProject.refresh();

                // Hiển thị thông báo thành công
                showAlert("Thành công", "Nhiệm vụ đã được thêm vào dự án.", Alert.AlertType.INFORMATION);
            } else {
                // Hiển thị thông báo nếu thông tin nhập vào không hợp lệ
                showAlert("Lỗi", "Thông tin nhiệm vụ không đầy đủ.", Alert.AlertType.WARNING);
            }
        } else {
            // Hiển thị thông báo nếu chưa chọn dự án
            showAlert("Lỗi", "Chưa chọn dự án.", Alert.AlertType.WARNING);
        }
    }

}
