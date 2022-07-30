package aop;

import org.springframework.stereotype.Component;

@Component("uniLibraryBean")
public class UniLibrary {

    public void getBook(String boolName){
        System.out.println("we are taking a book from UniLibrary: " + boolName);
        System.out.println("---------------------------------------------------");
    }

    public void addBook(String person_name, Book book){
        System.out.println("we add the book to UniLibrary:");
        System.out.println("---------------------------------------------------");
    }
    public void returnBook(){
        System.out.println("we return the book to UniLibrary:");
        System.out.println("---------------------------------------------------");
    }

    public String returnBook2(){
      // int a = 10/0;
        System.out.println("we return the book to UniLibrary: " + "\n---------------------------------------------------");
        return ("book name - Spring AOP");

    }

    public void getMagazine(int a){
        System.out.println("we are taking a magazine from UniLibrary:");
        System.out.println("---------------------------------------------------");

    }
    public void addMagazine(){
        System.out.println("we add the magazine to UniLibrary:");
        System.out.println("---------------------------------------------------");
    }
    public void returnMagazine(){
        System.out.println("we return the magazine to UniLibrary:");
        System.out.println("---------------------------------------------------");
    }
}
