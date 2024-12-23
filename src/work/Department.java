package work;

import employee.Employee;
import employee.Engineer;
import employee.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Department {
    private int departmentId;
    private String name;
    private Employee head; // Trưởng phòng
    private ObservableList<Engineer> members = FXCollections.observableArrayList(); // Chỉ chứa Engineer

    private Project project; // Dự án mà phòng ban phụ trách

    // Constructor
    public Department(int departmentId, String name, Manager head) {
        this.departmentId = departmentId;
        this.name = name;
        this.head = head;
        this.members = FXCollections.observableArrayList();
        this.project = null;

        // Trưởng phòng không phải là Engineer, nên không thêm vào danh sách thành viên
    }

    // Getter và Setter
    public int getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    public ObservableList<Engineer> getMembers() {
        return members;
    }

    public Project getProject() {
        return project; // Trả về dự án mà phòng ban phụ trách
    }

    public void setProject(Project project) {
        this.project = project; // Gán dự án cho phòng ban
    }

    @Override
    public String toString() {
        return this.name;  // Trả về tên phòng ban
    }

    // Thêm thành viên chỉ là Engineer vào phòng ban
    public void addMember(Engineer engineer) {
        if (!members.contains(engineer)) {
            members.add(engineer);
        }
    }

    // Trả về số lượng Engineer trong phòng ban
    public int getEmployeeCount() {
        return members.size();
    }

    // Xóa thành viên (chỉ xóa Engineer, không xóa Manager)
    public void removeMember(Engineer engineer) {
        members.remove(engineer);
    }

    public void setName(String name) {
        this.name = name;
    }
}
