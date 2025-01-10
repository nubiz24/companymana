package menu;

import employee.EmployeeManager;
import employee.Engineer;
import employee.Manager;
import screen.DepartmentScreen;
import screen.EmployeeScreen;
import screen.ProjectScreen;
import work.Department;
import work.Project;
import work.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuScreen extends JFrame {
    private EmployeeManager employeeManager;

    public MainMenuScreen(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;

        // Set up JFrame
        this.setTitle("Employee Management System");
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Set layout
        this.setLayout(new BorderLayout());

        // Create toolbar with improved styling
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setBackground(new Color(70, 130, 180)); // Steel blue

        // Icon size
        int iconSize = 48;

        // Add buttons to toolbar
        toolBar.add(createToolbarButton("/icons/department_icon.png", "Departments", e -> new DepartmentScreen(employeeManager), iconSize));
        toolBar.add(createToolbarButton("/icons/employee_icon.png", "Employees", e -> new EmployeeScreen(employeeManager), iconSize));
        toolBar.add(createToolbarButton("/icons/project_icon.png", "Projects", e -> new ProjectScreen(employeeManager), iconSize));

        // Add toolbar to top
        this.add(toolBar, BorderLayout.NORTH);

        // Add welcome panel
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        welcomePanel.setBackground(Color.LIGHT_GRAY);

        JLabel welcomeLabel = new JLabel("Welcome to Employee Management System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(25, 25, 112)); // Midnight blue

        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        this.add(welcomePanel, BorderLayout.CENTER);

        // Add footer
        JLabel footer = new JLabel("© 2024 Employee Management System. All Rights Reserved.", SwingConstants.CENTER);
        footer.setFont(new Font("Arial", Font.ITALIC, 12));
        footer.setForeground(Color.DARK_GRAY);
        this.add(footer, BorderLayout.SOUTH);

        // Show window
        this.setVisible(true);
    }

    // Helper method to create buttons with icons
    private JButton createToolbarButton(String iconPath, String tooltip, ActionListener action, int size) {
        ImageIcon icon = scaleIcon(new ImageIcon(getClass().getResource(iconPath)), size, size);
        JButton button = new JButton(icon);
        button.setToolTipText(tooltip);
        button.addActionListener(action);
        button.setBackground(new Color(240, 248, 255)); // Alice blue
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return button;
    }

    // Method to scale icons
    private ImageIcon scaleIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }


    public static void main(String[] args) {
        // Create an instance of EmployeeManager (use your actual implementation here)
        EmployeeManager employeeManager = new EmployeeManager();

// Tạo 7 Manager
        Manager manager1 = new Manager(1, "Samuel Harris", 6500, "212121212", "samuel.harris@email.com", null, 2100);
        Manager manager2 = new Manager(2, "Lily Adams", 6600, "313131313", "lily.adams@email.com", null, 2200);
        Manager manager3 = new Manager(3, "Benjamin Young", 6700, "414141414", "benjamin.young@email.com", null, 2300);
        Manager manager4 = new Manager(4, "Mia Carter", 6800, "515151515", "mia.carter@email.com", null, 2400);
        Manager manager5 = new Manager(5, "Jackson Lee", 6900, "616161616", "jackson.lee@email.com", null, 2500);
        Manager manager6 = new Manager(6, "Avery King", 7000, "717171717", "avery.king@email.com", null, 2600);
        Manager manager7 = new Manager(7, "Sophia Turner", 7100, "818181818", "sophia.turner@email.com", null, 2700);

// Tạo 43 Engineer (ID tăng dần từ 8)
        Engineer engineer8 = new Engineer(8, "William Miller", 4900, "919191919", "william.miller@email.com", null, 30, 100);
        Engineer engineer9 = new Engineer(9, "Charlotte Wright", 4800, "929292929", "charlotte.wright@email.com", null, 35, 110);
        Engineer engineer10 = new Engineer(10, "Lucas Robinson", 4700, "939393939", "lucas.robinson@email.com", null, 40, 120);
        Engineer engineer11 = new Engineer(11, "Grace Walker", 4600, "949494949", "grace.walker@email.com", null, 45, 130);
        Engineer engineer12 = new Engineer(12, "Alexander Harris", 4500, "959595959", "alexander.harris@email.com", null, 50, 140);
        Engineer engineer13 = new Engineer(13, "Olivia Clark", 4400, "969696969", "olivia.clark@email.com", null, 30, 110);
        Engineer engineer14 = new Engineer(14, "Henry Lewis", 4300, "979797979", "henry.lewis@email.com", null, 40, 120);
        Engineer engineer15 = new Engineer(15, "Ella Martinez", 4200, "989898989", "ella.martinez@email.com", null, 35, 125);
        Engineer engineer16 = new Engineer(16, "Sebastian White", 4100, "999999999", "sebastian.white@email.com", null, 45, 130);
        Engineer engineer17 = new Engineer(17, "Lily Moore", 4000, "101010101", "lily.moore@email.com", null, 30, 135);
        Engineer engineer18 = new Engineer(18, "Jack Turner", 3900, "111111111", "jack.turner@email.com", null, 40, 140);
        Engineer engineer19 = new Engineer(19, "Amelia Scott", 3800, "121212121", "amelia.scott@email.com", null, 35, 130);
        Engineer engineer20 = new Engineer(20, "Isabella Allen", 3700, "131313131", "isabella.allen@email.com", null, 40, 120);
        Engineer engineer21 = new Engineer(21, "Michael Hall", 3600, "141414141", "michael.hall@email.com", null, 30, 110);
        Engineer engineer22 = new Engineer(22, "Elijah Young", 3500, "151515151", "elijah.young@email.com", null, 35, 115);
        Engineer engineer23 = new Engineer(23, "Ava Nelson", 3400, "161616161", "ava.nelson@email.com", null, 40, 120);
        Engineer engineer24 = new Engineer(24, "Benjamin Carter", 3300, "171717171", "benjamin.carter@email.com", null, 45, 125);
        Engineer engineer25 = new Engineer(25, "Mason Phillips", 3200, "181818181", "mason.phillips@email.com", null, 30, 130);
        Engineer engineer26 = new Engineer(26, "Zoe Mitchell", 3100, "191919191", "zoe.mitchell@email.com", null, 40, 135);
        Engineer engineer27 = new Engineer(27, "James Harris", 3000, "202020202", "james.harris@email.com", null, 35, 140);
        Engineer engineer28 = new Engineer(28, "Oliver Perez", 2900, "212121212", "oliver.perez@email.com", null, 30, 120);
        Engineer engineer29 = new Engineer(29, "Sofia Roberts", 2800, "222222222", "sofia.roberts@email.com", null, 25, 115);
        Engineer engineer30 = new Engineer(30, "Henry Miller", 2700, "232323232", "henry.miller@email.com", null, 40, 130);
        Engineer engineer31 = new Engineer(31, "Ella Lee", 2600, "242424242", "ella.lee@email.com", null, 45, 135);
        Engineer engineer32 = new Engineer(32, "Jack Wilson", 2500, "252525252", "jack.wilson@email.com", null, 50, 140);
        Engineer engineer33 = new Engineer(33, "Harper Green", 2400, "262626262", "harper.green@email.com", null, 30, 125);
        Engineer engineer34 = new Engineer(34, "Aiden King", 2300, "272727272", "aiden.king@email.com", null, 40, 130);
        Engineer engineer35 = new Engineer(35, "Mia Perez", 2200, "282828282", "mia.perez@email.com", null, 35, 120);
        Engineer engineer36 = new Engineer(36, "Jacob Thomas", 2100, "292929292", "jacob.thomas@email.com", null, 30, 110);
        Engineer engineer37 = new Engineer(37, "Emily Robinson", 2000, "303030303", "emily.robinson@email.com", null, 25, 105);
        Engineer engineer38 = new Engineer(38, "Samantha Martinez", 2100, "313131313", "samantha.martinez@email.com", null, 35, 115);
        Engineer engineer39 = new Engineer(39, "Ryan Davis", 2200, "323232323", "ryan.davis@email.com", null, 30, 120);
        Engineer engineer40 = new Engineer(40, "Noah Jackson", 2300, "333333333", "noah.jackson@email.com", null, 40, 125);
        Engineer engineer41 = new Engineer(41, "Liam White", 2400, "343434343", "liam.white@email.com", null, 25, 130);
        Engineer engineer42 = new Engineer(42, "Chloe Evans", 2500, "353535353", "chloe.evans@email.com", null, 30, 135);
        Engineer engineer43 = new Engineer(43, "Jack Roberts", 2600, "363636363", "jack.roberts@email.com", null, 35, 140);
        Engineer engineer44 = new Engineer(44, "Lucas Moore", 2700, "373737373", "lucas.moore@email.com", null, 30, 120);
        Engineer engineer45 = new Engineer(45, "Emma Garcia", 2800, "383838383", "emma.garcia@email.com", null, 40, 125);
        Engineer engineer46 = new Engineer(46, "Lucas Green", 2900, "393939393", "lucas.green@email.com", null, 45, 130);
        Engineer engineer47 = new Engineer(47, "James Lee", 3000, "404040404", "james.lee@email.com", null, 50, 135);
        Engineer engineer48 = new Engineer(48, "Lily Davis", 3100, "414141414", "lily.davis@email.com", null, 30, 140);
        Engineer engineer49 = new Engineer(49, "Megan Lewis", 3200, "424242424", "megan.lewis@email.com", null, 35, 130);
        Engineer engineer50 = new Engineer(50, "Jack Brown", 3300, "434343434", "jack.brown@email.com", null, 40, 125);

// Thêm nhân viên vào EmployeeManager
        employeeManager.addManager(manager1);
        employeeManager.addManager(manager2);
        employeeManager.addManager(manager3);
        employeeManager.addManager(manager4);
        employeeManager.addManager(manager5);
        employeeManager.addManager(manager6);
        employeeManager.addManager(manager7);

        employeeManager.addEngineer(engineer8);
        employeeManager.addEngineer(engineer9);
        employeeManager.addEngineer(engineer10);
        employeeManager.addEngineer(engineer11);
        employeeManager.addEngineer(engineer12);
        employeeManager.addEngineer(engineer13);
        employeeManager.addEngineer(engineer14);
        employeeManager.addEngineer(engineer15);
        employeeManager.addEngineer(engineer16);
        employeeManager.addEngineer(engineer17);
        employeeManager.addEngineer(engineer18);
        employeeManager.addEngineer(engineer19);
        employeeManager.addEngineer(engineer20);
        employeeManager.addEngineer(engineer21);
        employeeManager.addEngineer(engineer22);
        employeeManager.addEngineer(engineer23);
        employeeManager.addEngineer(engineer24);
        employeeManager.addEngineer(engineer25);
        employeeManager.addEngineer(engineer26);
        employeeManager.addEngineer(engineer27);
        employeeManager.addEngineer(engineer28);
        employeeManager.addEngineer(engineer29);
        employeeManager.addEngineer(engineer30);
        employeeManager.addEngineer(engineer31);
        employeeManager.addEngineer(engineer32);
        employeeManager.addEngineer(engineer33);
        employeeManager.addEngineer(engineer34);
        employeeManager.addEngineer(engineer35);
        employeeManager.addEngineer(engineer36);
        employeeManager.addEngineer(engineer37);
        employeeManager.addEngineer(engineer38);
        employeeManager.addEngineer(engineer39);
        employeeManager.addEngineer(engineer40);
        employeeManager.addEngineer(engineer41);
        employeeManager.addEngineer(engineer42);
        employeeManager.addEngineer(engineer43);
        employeeManager.addEngineer(engineer44);
        employeeManager.addEngineer(engineer45);
        employeeManager.addEngineer(engineer46);
        employeeManager.addEngineer(engineer47);
        employeeManager.addEngineer(engineer48);
        employeeManager.addEngineer(engineer49);
        employeeManager.addEngineer(engineer50);

// Tạo 7 phòng ban và gán trưởng phòng
        Department salesDept1 = new Department(1, "Sales", manager1);
        Department financeDept1 = new Department(2, "Finance", manager2);
        Department itDept1 = new Department(3, "IT", manager3);
        Department marketingDept1 = new Department(4, "Marketing", manager4);
        Department operationsDept1 = new Department(5, "Operations", manager5);
        Department hrDept1 = new Department(6, "HR", manager6);
        Department legalDept1 = new Department(7, "Legal", manager7);

// Gán nhân viên vào phòng ban (ví dụ cho vài nhân viên, các nhân viên khác sẽ được gán tương tự)
        engineer8.setDepartment(salesDept1);
        engineer9.setDepartment(salesDept1);
        engineer10.setDepartment(salesDept1);
        engineer11.setDepartment(salesDept1);
        engineer12.setDepartment(salesDept1);
        engineer13.setDepartment(financeDept1);
        engineer14.setDepartment(financeDept1);
        engineer15.setDepartment(financeDept1);
        engineer16.setDepartment(financeDept1);
        engineer17.setDepartment(itDept1);
        engineer18.setDepartment(itDept1);
        engineer19.setDepartment(itDept1);
        engineer20.setDepartment(itDept1);
        engineer21.setDepartment(marketingDept1);
        engineer22.setDepartment(marketingDept1);
        engineer23.setDepartment(marketingDept1);
        engineer24.setDepartment(marketingDept1);
        engineer25.setDepartment(operationsDept1);
        engineer26.setDepartment(operationsDept1);
        engineer27.setDepartment(operationsDept1);
        engineer28.setDepartment(operationsDept1);
        engineer29.setDepartment(hrDept1);
        engineer30.setDepartment(hrDept1);
        engineer31.setDepartment(hrDept1);
        engineer32.setDepartment(hrDept1);
        engineer33.setDepartment(legalDept1);
        engineer34.setDepartment(legalDept1);
        engineer35.setDepartment(legalDept1);
        engineer36.setDepartment(legalDept1);
        engineer37.setDepartment(salesDept1);
        engineer38.setDepartment(salesDept1);
        engineer39.setDepartment(salesDept1);
        engineer40.setDepartment(financeDept1);
        engineer41.setDepartment(financeDept1);
        engineer42.setDepartment(itDept1);
        engineer43.setDepartment(itDept1);
        engineer44.setDepartment(marketingDept1);
        engineer45.setDepartment(marketingDept1);
        engineer46.setDepartment(operationsDept1);
        engineer47.setDepartment(operationsDept1);
        engineer48.setDepartment(hrDept1);
        engineer49.setDepartment(hrDept1);
        engineer50.setDepartment(legalDept1);


// Thêm phòng ban vào EmployeeManager
        employeeManager.addDepartment(salesDept1);
        employeeManager.addDepartment(financeDept1);
        employeeManager.addDepartment(itDept1);
        employeeManager.addDepartment(marketingDept1);
        employeeManager.addDepartment(operationsDept1);
        employeeManager.addDepartment(hrDept1);
        employeeManager.addDepartment(legalDept1);

// Tạo 7 dự án và gán cho phòng ban
        Project project1 = new Project(1, "Sales Expansion", "2025-06-15", salesDept1);
        Project project2 = new Project(2, "Financial Risk Management", "2025-07-30", financeDept1);
        Project project3 = new Project(3, "Cloud Migration", "2025-08-15", itDept1);
        Project project4 = new Project(4, "Digital Marketing", "2025-09-30", marketingDept1);
        Project project5 = new Project(5, "Supply Chain Modernization", "2025-10-15", operationsDept1);
        Project project6 = new Project(6, "Employee Well-being", "2025-11-30", hrDept1);
        Project project7 = new Project(7, "Legal Compliance", "2025-12-31", legalDept1);

// Gán các dự án vào phòng ban
        salesDept1.setProject(project1);
        financeDept1.setProject(project2);
        itDept1.setProject(project3);
        marketingDept1.setProject(project4);
        operationsDept1.setProject(project5);
        hrDept1.setProject(project6);
        legalDept1.setProject(project7);

// Thêm dự án vào EmployeeManager
        employeeManager.addProject(project1);
        employeeManager.addProject(project2);
        employeeManager.addProject(project3);
        employeeManager.addProject(project4);
        employeeManager.addProject(project5);
        employeeManager.addProject(project6);
        employeeManager.addProject(project7);

// Tạo nhiệm vụ cho các dự án
        Task task1 = new Task(1, "Increase sales volume", "2025-06-01", project1);
        Task task2 = new Task(2, "Assess financial risks", "2025-07-15", project2);
        Task task3 = new Task(3, "Migrate to cloud infrastructure", "2025-08-01", project3);
        Task task4 = new Task(4, "Launch marketing campaigns", "2025-09-01", project4);
        Task task5 = new Task(5, "Automate supply chain", "2025-10-01", project5);
        Task task6 = new Task(6, "Promote employee wellness", "2025-11-15", project6);
        Task task7 = new Task(7, "Ensure legal compliance", "2025-12-15", project7);

// Thêm nhiệm vụ vào dự án
        project1.addTask(task1);
        project2.addTask(task2);
        project3.addTask(task3);
        project4.addTask(task4);
        project5.addTask(task5);
        project6.addTask(task6);
        project7.addTask(task7);


        // Show the main menu screen
        new MainMenuScreen(employeeManager);
    }
}
