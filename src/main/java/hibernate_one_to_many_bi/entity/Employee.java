package hibernate_one_to_many_bi.entity;

// Annotation One to One
/*   @OneToOne
    private Detail empDetails;

 */
import hibernate_one_to_one.entity.Detail;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    public Employee() {
    }

    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
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
    @Column(name = "department")
    private String department;
    @Column(name = "salary")
    private int salary;



    /* by @OneToOne(cascade = CascadeType.ALL)  by default not cascade. type Cascade - means changing will be done in all related tables */
    @OneToOne(cascade = CascadeType.ALL) /* The @JoinColumn annotation defines connection  side that owns the foreign key.
    that actual physical mapping on the owning side: the owning side is usually defined on the many side of the relationship. It's typically the side that owns the foreign key. */
    @JoinColumn(name = "details_id") // the foreign key name "details_id"
    private Detail empDetails;

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setDetailsId(int id) {
        this.id = id;
    }


    private boolean isEmpty(String str){
        if (str == "")
            return  true;
        else return  false;
    }
    public void setName(String name) {
        if (this.isEmpty(name)) {
            System.out.println("error");
            return;
        }
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Detail getEmpDetails() {
        return empDetails;
    }

    public void setEmpDetails(Detail empDetails) {
        this.empDetails = empDetails;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
