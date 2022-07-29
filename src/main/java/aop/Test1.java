package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Library library = context.getBean("libraryBean", Library.class);
        UniLibrary uniLibrary = context.getBean("uniLibraryBean", UniLibrary.class);


//        library.getBook();
//        uniLibrary.getBook("Cooking advice");
//        System.out.println("--------------------------------");

//        uniLibrary.getBook("Spring course");
//        uniLibrary.getMagazine(0);
//        System.out.println("--------------------------------");
//
//        uniLibrary.returnMagazine();
//        uniLibrary.returnBook();
//        System.out.println("--------------------------------");

        // Join Point
        Book book = context.getBean("book",Book.class);
        uniLibrary.addBook("Mark",book);
        uniLibrary.addMagazine();



        context.close();


    }
}
