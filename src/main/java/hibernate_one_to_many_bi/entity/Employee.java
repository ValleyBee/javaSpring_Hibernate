package hibernate_one_to_many_bi.entity;

// Annotation One to One
/*   @OneToOne
    private Detail empDetails;

 */
import hibernate_one_to_one.entity.Detail;

import javax.persistence.*;

@Entity
@Table(name = "employees_new")
public class Employee {

    public Employee() {
    }

    public Employee(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @Column(name = "details_id")
//    private int details_id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "salary")
    private int salary;

    // except Cascade.REMOVE  allows you to delete employee without deleting whole department
    // ManyToOne when JoinColumn refers to Foreign_key (Many) is source table to (One) target table
    // Foreign_key is always in table (Many)
    // OneToMany from target table to source(Many)
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE})
    @JoinColumn(name = "department_id") // here is Foreign_key
    private Department department;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
