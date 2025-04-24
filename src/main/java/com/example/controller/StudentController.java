package com.example.controller;


import com.example.bean.Book;
import com.example.bean.Loan;
import com.example.bean.LoanAndBook;
import com.example.bean.User;
import com.example.service.BookService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    BookService bookService;

    @RequestMapping({"/index","index.html"})
    public String index(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user.getRole_id() == 2 || user.getRole_id() == 3){
            return "redirect:/admin/queryAllBook";
        }

        List<Book> books = bookService.queryAllBookByNoStatus();
        books.sort((book1, book2) -> book1.getTitle().compareTo(book2.getTitle()));

        model.addAttribute("books",books);
        return "user_index";
    }



    @RequestMapping("/book/queryAllBook")
    public String queryAllBook(Model model){
        return "redirect:/index";
    }
    @RequestMapping("/loan/queryAllLoan")
    public String queryAllLoan(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        List<Loan> loans = bookService.queryAllLoanByUserId(user.getId());
        List<LoanAndBook> books = new ArrayList<>();
        for (Loan loan : loans) {

            books.add(new LoanAndBook(bookService.queryBookById(loan.getBook_id()),loan));
        }
        
        model.addAttribute("books",books);
        return "user_index_2";
    }

    @GetMapping("/loan/{id}")
    public String insertLoan(@PathVariable("id") int bookId,HttpSession session){
        User user = (User)session.getAttribute("user");
        Loan loan = new Loan();
        loan.setUser_id(user.getId());
        loan.setStatus(0);
        loan.setBook_id(bookId);
        loan.setBorrow_date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        bookService.insertLoan(loan);
        return "redirect:/index";
    }

    @GetMapping("/deleteLoan/{id}")
    public String deleteLoanByBookId(@PathVariable("id") int id){
        bookService.deleteLoanByBookId(id);
        return "redirect:/loan/queryAllLoan";
    }

    @GetMapping("/book/queryAllBook/{where}/{value}")
    public String queryAllBookByWhere(@PathVariable("where") String where,@PathVariable("value") String value,Model model,HttpSession session){
        switch (where){
            case "title":model.addAttribute("books",bookService.queryAllBookByNoStatusByTitle(value.trim()));break;
            case "author":model.addAttribute("books",bookService.queryAllBookByNoStatusByAuthor(value.trim()));break;
            case "isbn":model.addAttribute("books",bookService.queryAllBookByNoStatusByIsbn(value.trim()));break;
            case "publisher":model.addAttribute("books",bookService.queryAllBookByNoStatusByPublisher(value.trim()));break;
            default:break;
        }
        User user = (User) session.getAttribute("user");
        if (user.getRole_id() == 2 || user.getRole_id() == 3){
            return "admin_system_book";
        }
        return "user_index";
    }
}
