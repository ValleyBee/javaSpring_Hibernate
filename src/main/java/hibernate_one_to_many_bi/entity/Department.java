package hibernate_one_to_many_bi.entity;

import javax.persistence.*;

@Entity
@Table(name="departments")
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

    public Department() {
    }

    public Department(int id, String department_name, int maxSalary, int minSalary) {
        this.id = id;
        this.department_name = department_name;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }
}
