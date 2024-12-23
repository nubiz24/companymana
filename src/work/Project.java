package work;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Project {
    private  int projectId;
    private String name;
    private String deadline;
    private Department department; // Phòng ban phụ trách dự án
    private ObservableList<Task> tasks = FXCollections.observableArrayList(); // Chỉ chứa Engineer

    public Project(int projectId, String name, String deadline, Department department) {
        this.projectId = projectId;
        this.name = name;
        this.deadline = deadline;
        this.department = department;
        this.tasks = FXCollections.observableArrayList();
    }

    public int getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public String getDeadline() {
        return deadline;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ObservableList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setTasks(ObservableList<Task> tasks) {
        this.tasks = tasks;
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
    public int getTaskCount() {
        return tasks.size();  // Trả về số lượng nhiệm vụ trong danh sách
    }
}
