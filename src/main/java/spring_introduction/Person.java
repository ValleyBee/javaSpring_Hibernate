package spring_introduction;

public class Person {
    private Pet pet;
    private String surname;
    private int age;

    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    // SETTERS
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }
// GETTERS
    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Person(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

    public Person() {
        System.out.println("Person bean is created: Default constructor");
    }

    public void callYourPet() {
        System.out.println("Hello my lovely pet");
        pet.say();
    }

}
