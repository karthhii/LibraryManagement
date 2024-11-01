package com.karthi.spring.LibraryManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    // Show loan page
    @GetMapping
    public String loanPage() {
        return "loan"; // JSP page for loan actions
    }

    // Borrow a book
    @PostMapping("/borrow")
    public String borrowBook(@RequestParam int bookId, @RequestParam int userId, Model model) {
        String message = loanService.borrowBook(bookId, userId);
        model.addAttribute("message", message);
        return "loan";
    }

    // Return a book
    @PostMapping("/return")
    public String returnBook(@RequestParam int loanId, Model model) {
        String message = loanService.returnBook(loanId);
        model.addAttribute("message", message);
        return "loan";
    }

}
