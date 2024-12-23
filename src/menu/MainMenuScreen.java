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

        // Set up the JFrame
        this.setTitle("Main Menu");
        this.setSize(800, 500);  // Set a bigger size for a better layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Center the window

        // Use GridBagLayout for better control over component positions
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(layout);

        // Remove the JMenuBar (File and Open menus)
        this.setJMenuBar(null);

        // Create a toolbar for quick access
        JToolBar toolBar = new JToolBar("Quick Access");
        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        // Define the desired icon size (e.g., 48x48 for bigger icons)
        int iconWidth = 48;
        int iconHeight = 48;

        // Method to scale the icons to a fixed size
        ImageIcon departmentIcon = scaleIcon(new ImageIcon(getClass().getResource("/icons/department_icon.png")), iconWidth, iconHeight);
        ImageIcon employeeIcon = scaleIcon(new ImageIcon(getClass().getResource("/icons/employee_icon.png")), iconWidth, iconHeight);
        ImageIcon projectIcon = scaleIcon(new ImageIcon(getClass().getResource("/icons/project_icon.png")), iconWidth, iconHeight);

        // Add buttons to the toolbar with icons
        JButton deptButton = new JButton(departmentIcon);
        deptButton.setToolTipText("Open Department Screen");
        deptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DepartmentScreen(employeeManager);
            }
        });
        deptButton.setPreferredSize(new Dimension(iconWidth + 10, iconHeight + 10));  // Optional: Add some padding

        JButton empButton = new JButton(employeeIcon);
        empButton.setToolTipText("Open Employee Screen");
        empButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeScreen(employeeManager);
            }
        });
        empButton.setPreferredSize(new Dimension(iconWidth + 10, iconHeight + 10));  // Optional: Add some padding

        JButton projButton = new JButton(projectIcon);
        projButton.setToolTipText("Open Project Screen");
        projButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProjectScreen(employeeManager);
            }
        });
        projButton.setPreferredSize(new Dimension(iconWidth + 10, iconHeight + 10));  // Optional: Add some padding

        // Add buttons to the toolbar
        toolBar.add(deptButton);
        toolBar.add(empButton);
        toolBar.add(projButton);

        // Add toolbar to the frame using GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        this.add(toolBar, gbc);

        // Create a welcome panel or content area with text
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        contentPanel.setBackground(Color.LIGHT_GRAY);
        JLabel welcomeLabel = new JLabel("Welcome to Employee Management System");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        contentPanel.add(welcomeLabel);

        // Add the content panel to the center of the layout
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        this.add(contentPanel, gbc);

        // Show the window
        this.setVisible(true);
    }

    // Method to scale icons to a specific size
    private ImageIcon scaleIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    public static void main(String[] args) {
        // Create an instance of EmployeeManager (use your actual implementation here)
        EmployeeManager employeeManager = new EmployeeManager();

// Tạo 7 Manager
        Manager manager12 = new Manager(12, "Samuel Harris", 6500, "212121212", "samuel.harris@email.com", null, 2100);
        Manager manager13 = new Manager(13, "Lily Adams", 6600, "313131313", "lily.adams@email.com", null, 2200);
        Manager manager14 = new Manager(14, "Benjamin Young", 6700, "414141414", "benjamin.young@email.com", null, 2300);
        Manager manager15 = new Manager(15, "Mia Carter", 6800, "515151515", "mia.carter@email.com", null, 2400);
        Manager manager16 = new Manager(16, "Jackson Lee", 6900, "616161616", "jackson.lee@email.com", null, 2500);
        Manager manager17 = new Manager(17, "Avery King", 7000, "717171717", "avery.king@email.com", null, 2600);
        Manager manager18 = new Manager(18, "Sophia Turner", 7100, "818181818", "sophia.turner@email.com", null, 2700);

// Tạo 40 Engineer
        Engineer engineer21 = new Engineer(41, "William Miller", 4900, "919191919", "william.miller@email.com", null, 30, 100);
        Engineer engineer22 = new Engineer(42, "Charlotte Wright", 4800, "929292929", "charlotte.wright@email.com", null, 35, 110);
        Engineer engineer23 = new Engineer(43, "Lucas Robinson", 4700, "939393939", "lucas.robinson@email.com", null, 40, 120);
        Engineer engineer24 = new Engineer(44, "Grace Walker", 4600, "949494949", "grace.walker@email.com", null, 45, 130);
        Engineer engineer25 = new Engineer(45, "Alexander Harris", 4500, "959595959", "alexander.harris@email.com", null, 50, 140);
        Engineer engineer26 = new Engineer(46, "Olivia Clark", 4400, "969696969", "olivia.clark@email.com", null, 30, 110);
        Engineer engineer27 = new Engineer(47, "Henry Lewis", 4300, "979797979", "henry.lewis@email.com", null, 40, 120);
        Engineer engineer28 = new Engineer(48, "Ella Martinez", 4200, "989898989", "ella.martinez@email.com", null, 35, 125);
        Engineer engineer29 = new Engineer(49, "Sebastian White", 4100, "999999999", "sebastian.white@email.com", null, 45, 130);
        Engineer engineer30 = new Engineer(50, "Lily Moore", 4000, "101010101", "lily.moore@email.com", null, 30, 135);
        Engineer engineer31 = new Engineer(51, "Jack Turner", 3900, "111111111", "jack.turner@email.com", null, 40, 140);
        Engineer engineer32 = new Engineer(52, "Amelia Scott", 3800, "121212121", "amelia.scott@email.com", null, 35, 130);
        Engineer engineer33 = new Engineer(53, "Isabella Allen", 3700, "131313131", "isabella.allen@email.com", null, 40, 120);
        Engineer engineer34 = new Engineer(54, "Michael Hall", 3600, "141414141", "michael.hall@email.com", null, 30, 110);
        Engineer engineer35 = new Engineer(55, "Elijah Young", 3500, "151515151", "elijah.young@email.com", null, 35, 115);
        Engineer engineer36 = new Engineer(56, "Ava Nelson", 3400, "161616161", "ava.nelson@email.com", null, 40, 120);
        Engineer engineer37 = new Engineer(57, "Benjamin Carter", 3300, "171717171", "benjamin.carter@email.com", null, 45, 125);
        Engineer engineer38 = new Engineer(58, "Mason Phillips", 3200, "181818181", "mason.phillips@email.com", null, 30, 130);
        Engineer engineer39 = new Engineer(59, "Zoe Mitchell", 3100, "191919191", "zoe.mitchell@email.com", null, 40, 135);
        Engineer engineer40 = new Engineer(60, "James Harris", 3000, "202020202", "james.harris@email.com", null, 35, 140);
        Engineer engineer41 = new Engineer(61, "Oliver Perez", 2900, "212121212", "oliver.perez@email.com", null, 30, 120);
        Engineer engineer42 = new Engineer(62, "Sofia Roberts", 2800, "222222222", "sofia.roberts@email.com", null, 25, 115);
        Engineer engineer43 = new Engineer(63, "Henry Miller", 2700, "232323232", "henry.miller@email.com", null, 40, 130);
        Engineer engineer44 = new Engineer(64, "Ella Lee", 2600, "242424242", "ella.lee@email.com", null, 45, 135);
        Engineer engineer45 = new Engineer(65, "Jack Wilson", 2500, "252525252", "jack.wilson@email.com", null, 50, 140);
        Engineer engineer46 = new Engineer(66, "Harper Green", 2400, "262626262", "harper.green@email.com", null, 30, 125);
        Engineer engineer47 = new Engineer(67, "Aiden King", 2300, "272727272", "aiden.king@email.com", null, 40, 130);
        Engineer engineer48 = new Engineer(68, "Mia Perez", 2200, "282828282", "mia.perez@email.com", null, 35, 120);
        Engineer engineer49 = new Engineer(69, "Jacob Thomas", 2100, "292929292", "jacob.thomas@email.com", null, 30, 110);
        Engineer engineer50 = new Engineer(70, "Emily Robinson", 2000, "303030303", "emily.robinson@email.com", null, 25, 105);

// Thêm nhân viên vào EmployeeManager
        employeeManager.addManager(manager12);
        employeeManager.addManager(manager13);
        employeeManager.addManager(manager14);
        employeeManager.addManager(manager15);
        employeeManager.addManager(manager16);
        employeeManager.addManager(manager17);
        employeeManager.addManager(manager18);

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
        Department salesDept2 = new Department(12, "Sales", manager12);
        Department financeDept3 = new Department(13, "Finance", manager13);
        Department itDept2 = new Department(14, "IT", manager14);
        Department marketingDept3 = new Department(15, "Marketing", manager15);
        Department operationsDept2 = new Department(16, "Operations", manager16);
        Department hrDept3 = new Department(17, "HR", manager17);
        Department legalDept = new Department(18, "Legal", manager18);

// Gán nhân viên vào phòng ban
        manager12.setDepartment(salesDept2);
        manager13.setDepartment(financeDept3);
        manager14.setDepartment(itDept2);
        manager15.setDepartment(marketingDept3);
        manager16.setDepartment(operationsDept2);
        manager17.setDepartment(hrDept3);
        manager18.setDepartment(legalDept);

// Gán nhân viên vào các phòng ban
        engineer21.setDepartment(salesDept2);
        engineer22.setDepartment(salesDept2);
        engineer23.setDepartment(financeDept3);
        engineer24.setDepartment(financeDept3);
        engineer25.setDepartment(itDept2);
        engineer26.setDepartment(itDept2);
        engineer27.setDepartment(marketingDept3);
        engineer28.setDepartment(marketingDept3);
        engineer29.setDepartment(operationsDept2);
        engineer30.setDepartment(operationsDept2);
        engineer31.setDepartment(hrDept3);
        engineer32.setDepartment(hrDept3);
        engineer33.setDepartment(legalDept);
        engineer34.setDepartment(legalDept);
        engineer35.setDepartment(salesDept2);
        engineer36.setDepartment(salesDept2);
        engineer37.setDepartment(financeDept3);
        engineer38.setDepartment(financeDept3);
        engineer39.setDepartment(itDept2);
        engineer40.setDepartment(itDept2);
        engineer41.setDepartment(marketingDept3);
        engineer42.setDepartment(marketingDept3);
        engineer43.setDepartment(operationsDept2);
        engineer44.setDepartment(operationsDept2);
        engineer45.setDepartment(hrDept3);
        engineer46.setDepartment(hrDept3);
        engineer47.setDepartment(legalDept);
        engineer48.setDepartment(legalDept);
        engineer49.setDepartment(salesDept2);
        engineer50.setDepartment(salesDept2);

// Thêm phòng ban vào EmployeeManager
        employeeManager.addDepartment(salesDept2);
        employeeManager.addDepartment(financeDept3);
        employeeManager.addDepartment(itDept2);
        employeeManager.addDepartment(marketingDept3);
        employeeManager.addDepartment(operationsDept2);
        employeeManager.addDepartment(hrDept3);
        employeeManager.addDepartment(legalDept);

// Tạo 7 dự án và gán cho phòng ban
        Project project16 = new Project(16, "Sales Expansion", "2025-06-15", salesDept2);
        Project project17 = new Project(17, "Financial Risk Management", "2025-07-30", financeDept3);
        Project project18 = new Project(18, "Cloud Migration", "2025-08-15", itDept2);
        Project project19 = new Project(19, "Digital Marketing", "2025-09-30", marketingDept3);
        Project project20 = new Project(20, "Supply Chain Modernization", "2025-10-15", operationsDept2);
        Project project21 = new Project(21, "Employee Well-being", "2025-11-30", hrDept3);
        Project project22 = new Project(22, "Legal Compliance", "2025-12-31", legalDept);

// Gán các dự án vào phòng ban
        salesDept2.setProject(project16);
        financeDept3.setProject(project17);
        itDept2.setProject(project18);
        marketingDept3.setProject(project19);
        operationsDept2.setProject(project20);
        hrDept3.setProject(project21);
        legalDept.setProject(project22);

// Thêm dự án vào EmployeeManager
        employeeManager.addProject(project16);
        employeeManager.addProject(project17);
        employeeManager.addProject(project18);
        employeeManager.addProject(project19);
        employeeManager.addProject(project20);
        employeeManager.addProject(project21);
        employeeManager.addProject(project22);

// Tạo nhiệm vụ cho các dự án
        Task task41 = new Task(41, "Increase sales volume", "2025-06-01", project16);
        Task task42 = new Task(42, "Assess financial risks", "2025-07-15", project17);
        Task task43 = new Task(43, "Migrate to cloud infrastructure", "2025-08-01", project18);
        Task task44 = new Task(44, "Launch marketing campaigns", "2025-09-01", project19);
        Task task45 = new Task(45, "Automate supply chain", "2025-10-01", project20);
        Task task46 = new Task(46, "Promote employee wellness", "2025-11-15", project21);
        Task task47 = new Task(47, "Ensure legal compliance", "2025-12-15", project22);

// Thêm nhiệm vụ vào dự án
        project16.addTask(task41);
        project17.addTask(task42);
        project18.addTask(task43);
        project19.addTask(task44);
        project20.addTask(task45);
        project21.addTask(task46);
        project22.addTask(task47);

        // Show the main menu screen
        new MainMenuScreen(employeeManager);
    }
}
