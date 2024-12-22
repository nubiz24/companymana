package employee;

import work.Department;

public class Engineer extends Employee {
    private int overtimeHours;
    private double overtimeRate;

    public Engineer(int id, String name, double baseSalary, String phone, String email, Department department, int overtimeHours, double overtimeRate) {
        super(id, name, baseSalary, phone, email, department);
        this.overtimeHours = overtimeHours;
        this.overtimeRate = overtimeRate;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }

    public void setOvertimeRate(double overtimeRate) {
        this.overtimeRate = overtimeRate;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (overtimeHours * overtimeRate);
    }

    // Phương thức thêm và xóa thành viên
    public static void addMember(EmployeeManager manager, Engineer newEngineer) {
        manager.addEngineer(newEngineer);
    }

    public static void removeMember(EmployeeManager manager, int id) {
        manager.removeEngineerById(id);
    }
}
