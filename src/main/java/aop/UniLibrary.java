package aop;

import org.springframework.stereotype.Component;

@Component("uniLibraryBean")
public class UniLibrary {

    public void getBook(String boolName){
        System.out.println("we are taking a book from UniLibrary: " + boolName);
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
}
