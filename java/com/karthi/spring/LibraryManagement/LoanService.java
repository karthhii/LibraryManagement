package com.karthi.spring.LibraryManagement;


import java.time.LocalDateTime;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    // Issue a new loan
    public String borrowBook(int bookId, int userId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        Optional<User> userOptional = userRepository.findById(userId);

        if (bookOptional.isPresent() && userOptional.isPresent()) {
            Book book = bookOptional.get();
            User user = userOptional.get();

            if (book.isAvailable()) {
                Loan loan = new Loan();
                loan.setBook(book);
                loan.setUser(user);
                loan.setLoanDate(LocalDateTime.now());
                loan.setDueDate(LocalDateTime.now().plusDays(14)); // 2-week loan period

                loanRepository.save(loan);
                book.setAvailable(false);
                bookRepository.save(book);

                return "Book borrowed successfully!";
            } else {
                return "Book is not available!";
            }
        } else {
            return "Book or user not found!";
        }
    }

    // Return a borrowed book
    public String returnBook(int loanId) {
        Optional<Loan> loanOptional = loanRepository.findById(loanId);
        if (loanOptional.isPresent()) {
            Loan loan = loanOptional.get();
            Book book = loan.getBook();
            book.setAvailable(true);

            bookRepository.save(book);
            loanRepository.delete(loan);

            return "Book returned successfully!";
        }
        return "Loan not found!";
    }

 
}