import employee.EmployeeManager;
import employee.Engineer;
import employee.Manager;
import work.Department;
import work.Project;
import work.Task;

public class Main {
    public static void main(String[] args) {
        // Tạo EmployeeManager
        EmployeeManager employeeManager = new EmployeeManager();

        // Tạo các nhân viên
        Manager manager = new Manager(1, "John Doe", 5000, "123-456-789", "john.doe@email.com", null, 1000);
        Engineer engineer1 = new Engineer(2, "Alice Smith", 4000, "987-654-321", "alice.smith@email.com", null, 20, 50);
        Engineer engineer2 = new Engineer(3, "Bob Johnson", 4200, "555-555-555", "bob.johnson@email.com", null, 15, 60);

        // Thêm nhân viên vào EmployeeManager
        employeeManager.addManager(manager);
        employeeManager.addEngineer(engineer1);
        employeeManager.addEngineer(engineer2);

        // Tạo phòng ban và gán trưởng phòng
        Department department = new Department(1, "Engineering", manager);
        manager.setDepartment(department);
        engineer1.setDepartment(department);
        engineer2.setDepartment(department);

        // Thêm phòng ban vào EmployeeManager
        employeeManager.addDepartment(department);

        // Tạo dự án và gán cho phòng ban
        Project project = new Project(1, "AI Development", "2024-12-31", department);
        department.setProject(project);

        // Thêm dự án vào EmployeeManager
        employeeManager.addProject(project);

        // Tạo nhiệm vụ và thêm vào dự án
        Task task1 = new Task(1, "Develop AI model", "2024-12-25", project);
        Task task2 = new Task(2, "Test AI model", "2024-12-27", project);

        project.addTask(task1);
        project.addTask(task2);

        // In thông tin phòng ban
        department.printDepartmentMembers(employeeManager, 1);

        // In thông tin các nhiệm vụ trong dự án
        System.out.println("\nProject Tasks:");
        for (Task task : project.getTasks()) {
            task.displayTaskDetails();
        }
    }
}
