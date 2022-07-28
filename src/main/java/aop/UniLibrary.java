package aop;

import org.springframework.stereotype.Component;

@Component("uniLibraryBean")
public class UniLibrary {

    public void returnBook(){
        System.out.println("we return the book");
    }

    public String returnBook2(){
        return ("we return the book");
    }

    public void getMagazine(){
        System.out.println("we are taking a magazine");

    }
}
