package hibernate_one_to_many_bi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departments_new")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String department_name;
    @Column(name = "max_salary")
    private int maxSalary;
    @Column(name = "min_salary")
    private int minSalary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> listEmps;


    public Department() {
    }

    public Department(String department_name, int maxSalary, int minSalary) {
        this.department_name = department_name;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }
public void addEmpsToDepartment(Employee employee){
        if( listEmps == null) {
            listEmps = new ArrayList<>();
        }
        listEmps.add(employee);
        employee.setDepartment(this);
}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public List<Employee> getEmps() {
        return listEmps;
    }

    public void setEmps(List<Employee> emps) {
        this.listEmps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", department_name='" + department_name + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                '}';
    }
}
