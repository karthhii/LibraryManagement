package com.karthi.spring.LibraryManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/book")
public class BookController {
	@Autowired
    BookService bookService;
	@GetMapping("/get")
	public String getJsp() {
		return "books";
	}

    @GetMapping("/getBooks")
    public String listBooks(Model model) {
        model.addAttribute("book", bookService.getAllBooks());
        return "books";
    }
    

    @PostMapping("/save")
    public String saveBook(Book book) {
        bookService.saveBook(book);
        return "books";
    }

}
