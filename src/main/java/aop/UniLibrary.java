package aop;

import org.springframework.stereotype.Component;

@Component("uniLibraryBean")
public class UniLibrary {

    public void getBook(String boolName){
        System.out.println("we are taking a book from UniLibrary: " + boolName);
    }

    public void addBook(){
        System.out.println("we add the book to UniLibrary:");
    }
    public void returnBook(){
        System.out.println("we return the book to UniLibrary:");
    }

    public String returnBook2(){
        return ("we return the book to UniLibrary:");
    }

    public void getMagazine(int a){
        System.out.println("we are taking a magazine from UniLibrary:");

    }
    public void addMagazine(){
        System.out.println("we add the magazine to UniLibrary:");
    }
    public void returnMagazine(){
        System.out.println("we return the magazine to UniLibrary:");
    }
}
