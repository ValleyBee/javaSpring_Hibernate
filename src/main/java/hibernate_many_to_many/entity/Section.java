/* ManyToMany annotation @JoinTable  */
package hibernate_many_to_many.entity;

import hibernate_many_to_many.entity.Child;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    /* JoinColumn refers to jointqble PK source table and inverseColumn refers to jointable PK target table*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "child_section", joinColumns = @JoinColumn(name = "section_id"), inverseJoinColumns = @JoinColumn(name = "child_id"))
    private List<Child> childList;

    public void addChildSection(Child child) {
        if (childList == null) {
            childList = new ArrayList<>();
        }
        childList.add(child);
    }

    public Section() {
    }


    public Section(String name) {
        this.name = name;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

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


    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
