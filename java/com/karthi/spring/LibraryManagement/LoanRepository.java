package com.karthi.spring.LibraryManagement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer>{

}
