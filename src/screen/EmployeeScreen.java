package screen;

import controller.EmployeeScreenController;
import employee.EmployeeManager;
import employee.Engineer;
import employee.Manager;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import work.Department;
import work.Project;
import work.Task;

import javax.swing.*;

public class EmployeeScreen extends JFrame {
    private EmployeeManager employee;

    public EmployeeScreen(EmployeeManager employee) {
        super();
        this.employee = employee;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Employee");
        this.setVisible(true);
        this.setSize(1024, 768);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/employeeUI.fxml"));
                    EmployeeScreenController controller = new EmployeeScreenController(employee);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    }
