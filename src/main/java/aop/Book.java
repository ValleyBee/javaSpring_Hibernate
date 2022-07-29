package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book{
    @Value("Spring join point") // this replaces setters. It will set an arg during creating a container bean.
    private String name;
    @Value("ZT")
    private String author;
    @Value("2021")
    private int yearOfIssue;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }
}
