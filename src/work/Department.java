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
        this.project = null; // Khởi tạo không có dự án nào

        addMember(head); // Trưởng phòng cũng là thành viên của phòng
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

    public void printDepartmentMembers(EmployeeManager manager, int departmentId) {
        Department department = manager.findDepartmentById(departmentId);
        if (department != null) {
            System.out.println("Department: " + department.getName());
            System.out.println("Head of Department:");
            department.getHead().displayInfo();

            System.out.println("Members:");
            for (Employee employee : department.getMembers()) {
                employee.displayInfo();
            }

            // In thông tin dự án mà phòng ban phụ trách
            if (department.getProject() != null) {
                System.out.println("Project managed by this department:");
                System.out.println("Project: " + department.getProject().getName() + ", Deadline: " + department.getProject().getDeadline());
            } else {
                System.out.println("This department is not managing any project.");
            }
        } else {
            System.out.println("Department not found.");
        }
    }
}
