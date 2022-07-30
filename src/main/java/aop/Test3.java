package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("method main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibraryBean",UniLibrary.class);

        String bookName = uniLibrary.returnBook2();
        System.out.println("bookName: " + bookName);
        context.close();
        System.out.println("method main ends");
    }
}
