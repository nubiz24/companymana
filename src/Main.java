import employee.EmployeeManager;
import employee.Engineer;
import employee.Manager;
import screen.ProjectScreen;
import work.Department;
import work.Project;
import work.Task;

public class Main {
    public static void main(String[] args) {
        {
// Tạo EmployeeManager
            EmployeeManager employeeManager = new EmployeeManager();

// Tạo các nhân viên
            Manager manager1 = new Manager(1, "John Doe", 5000, "123-456-789", "john.doe@email.com", null, 1000);
            Manager manager2 = new Manager(2, "Jane Miller", 5200, "987-654-321", "jane.miller@email.com", null, 1200);
            Manager manager3 = new Manager(3, "Richard Roe", 5300, "444-444-444", "richard.roe@email.com", null, 1100);

            Engineer engineer1 = new Engineer(4, "Alice Smith", 4000, "555-555-555", "alice.smith@email.com", null, 20, 50);
            Engineer engineer2 = new Engineer(5, "Bob Johnson", 4200, "111-111-111", "bob.johnson@email.com", null, 15, 60);
            Engineer engineer3 = new Engineer(6, "Charlie Brown", 4300, "222-222-222", "charlie.brown@email.com", null, 10, 55);
            Engineer engineer4 = new Engineer(7, "Diana Prince", 4100, "333-333-333", "diana.prince@email.com", null, 25, 65);
            Engineer engineer5 = new Engineer(8, "Eve Adams", 4500, "666-666-666", "eve.adams@email.com", null, 30, 70);
            Engineer engineer6 = new Engineer(9, "Frank Wright", 4400, "777-777-777", "frank.wright@email.com", null, 20, 75);

// Thêm nhân viên vào EmployeeManager
            employeeManager.addManager(manager1);
            employeeManager.addManager(manager2);
            employeeManager.addManager(manager3);
            employeeManager.addEngineer(engineer1);
            employeeManager.addEngineer(engineer2);
            employeeManager.addEngineer(engineer3);
            employeeManager.addEngineer(engineer4);
            employeeManager.addEngineer(engineer5);
            employeeManager.addEngineer(engineer6);

// Tạo phòng ban và gán trưởng phòng
            Department engineeringDept = new Department(1, "Engineering", manager1);
            Department marketingDept = new Department(2, "Marketing", manager2);
            Department researchDept = new Department(3, "Research", manager3);

            manager1.setDepartment(engineeringDept);
            manager2.setDepartment(marketingDept);
            manager3.setDepartment(researchDept);

            engineer1.setDepartment(engineeringDept);
            engineer2.setDepartment(engineeringDept);
            engineer3.setDepartment(engineeringDept);
            engineer4.setDepartment(marketingDept);
            engineer5.setDepartment(researchDept);
            engineer6.setDepartment(researchDept);

// Thêm phòng ban vào EmployeeManager
            employeeManager.addDepartment(engineeringDept);
            employeeManager.addDepartment(marketingDept);
            employeeManager.addDepartment(researchDept);

// Tạo dự án và gán cho phòng ban
            Project project1 = new Project(1, "AI Development", "2024-12-31", engineeringDept);
            Project project2 = new Project(2, "Market Research", "2024-11-30", marketingDept);
            Project project3 = new Project(3, "New Product Launch", "2025-01-15", marketingDept);
            Project project4 = new Project(4, "Robotics Research", "2025-06-30", researchDept);
            Project project5 = new Project(5, "Quantum Computing", "2025-12-31", researchDept);

            engineeringDept.setProject(project1);
            marketingDept.setProject(project2);
            marketingDept.setProject(project3);
            researchDept.setProject(project4);
            researchDept.setProject(project5);

// Thêm dự án vào EmployeeManager
            employeeManager.addProject(project1);
            employeeManager.addProject(project2);
            employeeManager.addProject(project3);
            employeeManager.addProject(project4);
            employeeManager.addProject(project5);

// Tạo nhiệm vụ và thêm vào dự án
            Task task1 = new Task(1, "Develop AI model", "2024-12-25", project1);
            Task task2 = new Task(2, "Test AI model", "2024-12-27", project1);
            Task task3 = new Task(3, "Conduct surveys", "2024-11-15", project2);
            Task task4 = new Task(4, "Analyze survey data", "2024-11-20", project2);
            Task task5 = new Task(5, "Prepare marketing materials", "2024-12-30", project3);
            Task task6 = new Task(6, "Coordinate launch event", "2025-01-10", project3);
            Task task7 = new Task(7, "Optimize AI model", "2024-12-29", project1);
            Task task8 = new Task(8, "Create promotional videos", "2025-01-05", project3);
            Task task9 = new Task(9, "Design robotic arms", "2025-03-15", project4);
            Task task10 = new Task(10, "Test robotic sensors", "2025-04-20", project4);
            Task task11 = new Task(11, "Develop quantum algorithms", "2025-09-15", project5);
            Task task12 = new Task(12, "Test quantum circuits", "2025-10-20", project5);

            project1.addTask(task1);
            project1.addTask(task2);
            project1.addTask(task7);
            project2.addTask(task3);
            project2.addTask(task4);
            project3.addTask(task5);
            project3.addTask(task6);
            project3.addTask(task8);
            project4.addTask(task9);
            project4.addTask(task10);
            project5.addTask(task11);
            project5.addTask(task12);

// Thêm một số nhiệm vụ khác
            Task task13 = new Task(13, "Develop machine learning pipeline", "2024-12-20", project1);
            Task task14 = new Task(14, "Analyze competitor strategies", "2024-12-15", project2);
            Task task15 = new Task(15, "Organize focus groups", "2024-11-25", project2);
            Task task16 = new Task(16, "Optimize robotic software", "2025-05-10", project4);
            Task task17 = new Task(17, "Simulate quantum environments", "2025-08-10", project5);

            project1.addTask(task13);
            project2.addTask(task14);
            project2.addTask(task15);
            project4.addTask(task16);
            project5.addTask(task17);

// Kết thúc việc thêm dữ liệu


            new ProjectScreen(employeeManager);

        }
}
    }
