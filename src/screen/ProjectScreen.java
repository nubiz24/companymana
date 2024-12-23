package screen;

import controller.ProjectScreenController;
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

public class ProjectScreen extends JFrame {
    private EmployeeManager project;

    public ProjectScreen(EmployeeManager project) {
        super();
        this.project = project;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Project");
        this.setVisible(true);
        this.setSize(1024, 768);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/projectUI.fxml"));
                    ProjectScreenController controller = new ProjectScreenController(project);
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

