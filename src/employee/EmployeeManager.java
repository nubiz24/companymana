package employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import work.Department;
import work.Project;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    ObservableList<Manager> managers = FXCollections.observableArrayList();
    ObservableList<Engineer> engineers = FXCollections.observableArrayList();
    ObservableList<Department> departments = FXCollections.observableArrayList();
    ObservableList<Project> projects = FXCollections.observableArrayList();

    public EmployeeManager() {
        managers = FXCollections.observableArrayList();
        engineers = FXCollections.observableArrayList();
        departments = FXCollections.observableArrayList();
        projects = FXCollections.observableArrayList();
    }

    // Quản lý Manager
    public void addManager(Manager manager) {
        managers.add(manager);
    }

    public void removeManagerById(int id) {
        managers.removeIf(manager -> manager.getId() == id);
    }


    public Manager findManagerById(int id) {
        for (Manager manager : managers) {
            if (manager.getId() == id) {
                return manager;
            }
        }
        return null;
    }

    // Quản lý Engineer
    public void addEngineer(Engineer engineer) {
        engineers.add(engineer);
    }

    public void removeEngineerById(int id) {
        engineers.removeIf(engineer -> engineer.getId() == id);
    }

    public Engineer findEngineerById(int id) {
        for (Engineer engineer : engineers) {
            if (engineer.getId() == id) {
                return engineer;
            }
        }
        return null;
    }

    // Quản lý phòng ban
    public void addDepartment(Department department) {
        departments.add(department);
    }

    public ObservableList<Department> getDepartments() {
        return departments;
    }

    public Department findDepartmentById(int id) {
        for (Department department : departments) {
            if (department.getDepartmentId() == id) {
                return department;
            }
        }
        return null;
    }

    // Lấy tất cả Manager và Engineer
    public ObservableList<Manager> getManagers() {
        return managers;
    }

    public ObservableList<Engineer> getEngineers() {
        return engineers;
    }
    public void removeManager(Manager manager) {
        managers.remove(manager);
    }
    public void removeEngineer(Engineer engineer) {
        engineers.remove(engineer);
    }
    public void addProject(Project project) {
        projects.add(project);
    }

    public void removeProjectById(int projectId) {
        projects.removeIf(project -> project.getProjectId() == projectId);
    }

    public Project findProjectById(int projectId) {
        for (Project project : projects) {
            if (project.getProjectId() == projectId) {
                return project;
            }
        }
        return null;
    }

    public ObservableList<Project> getProjects() {
        return projects;
    }
}
