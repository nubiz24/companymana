package work;

import employee.Employee;
import employee.EmployeeManager;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private int departmentId;
    private String name;
    private Employee head; // Trưởng phòng
    private List<Employee> members;
    private Project project; // Dự án mà phòng ban phụ trách

    public Department(int departmentId, String name, Employee head) {
        this.departmentId = departmentId;
        this.name = name;
        this.head = head;
        this.members = new ArrayList<>();
        this.project = null;

        addMember(head);
    }

    public Department() {
        departmentId = departmentId;
        name = name;
        head = head;
        members = new ArrayList<>();
        project = null;
    }

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
        if (!members.contains(head)) {
            addMember(head);
        }
    }

    public List<Employee> getMembers() {
        return members;
    }

    public Project getProject() {
        return project; // Trả về dự án mà phòng ban phụ trách
    }

    public void setProject(Project project) {
        this.project = project; // Gán dự án cho phòng ban
    }

    public void addMember(Employee employee) {
        if (!members.contains(employee)) {
            members.add(employee);
        }
    }

    public int getEmployeeCount() {
        return members.size();  // Trả về số lượng nhân viên trong phòng ban
    }

    public void removeMember(Employee employee) {
        if (!employee.equals(head)) {
            members.remove(employee);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(List<Employee> members) {
        this.members = members;
    }


}
