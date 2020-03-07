package com.softuni.springdataintroex.controlers;
import com.softuni.springdataintroex.services.AuthorService;
import com.softuni.springdataintroex.services.BookService;
import com.softuni.springdataintroex.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class AppController implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @Override
    public void run(String... args) throws Exception {
        //seed data
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

//        Ex 1
//        List<Book> books = this.bookService.getAllBooksAfter2000();
//
//        Ex 3
//        this.authorService
//                .findAllAuthorsByCountOfBooks()
//                .forEach(a -> {
//                    System.out.printf("%s %s %d%n", a.getFirstName(), a.getLastName(), a.getBooks().size());
//                });
    }
}
