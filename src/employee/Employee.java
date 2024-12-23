package employee;

import work.Department;

public abstract class Employee {
    private  int id;
    private  String name;
    private double baseSalary;
    private String phone; // Sửa thành String
    private String email;
    private Department department;

    // Constructor
    public Employee(int id, String name, double baseSalary, String phone, String email, Department department) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.phone = phone;
        this.email = email;
        this.department = department;
    }

    // Getters và Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getPhone() { // Thay đổi kiểu trả về
        return phone;
    }

    public void setPhone(String phone) { // Thay đổi kiểu tham số
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract double calculateSalary();

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Base Salary: " + baseSalary + ", Total Salary: " + calculateSalary());
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        // Nếu đã có phòng ban cũ, xóa nhân viên khỏi phòng ban cũ
        if (this.department != null) {
            // Chỉ xóa nếu nhân viên là Engineer
            if (this instanceof Engineer) {
                this.department.removeMember((Engineer) this);
            }
        }

        // Cập nhật phòng ban mới
        this.department = department;

        // Nếu phòng ban mới không null và nhân viên là Engineer và chưa có trong phòng ban mới, thêm vào
        if (department != null && this instanceof Engineer) {
            Engineer engineer = (Engineer) this; // Chuyển đổi sang Engineer
            if (!department.getMembers().contains(engineer)) {
                department.addMember(engineer);
            }
        }
    }


}


