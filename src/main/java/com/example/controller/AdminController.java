package com.example.controller;

import com.example.bean.*;
import com.example.mapper.UserMapper;
import com.example.service.BookService;
import com.example.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @RequestMapping("/admin/queryAllBook")
    public String queryAllBook(Model model){
        List<Book> books = bookService.queryAllBook();
        books.sort((book1, book2) -> book1.getTitle().compareTo(book2.getTitle()));
        model.addAttribute("books",books);

        return "user_index";
    }

    @GetMapping("/admin/deleteBookById/{bookId}")
    public String deleteBookById(@PathVariable("bookId") int bookId){
        bookService.deleteBookById(bookId);
        return "redirect:/admin/queryAllBook";
    }
    @RequestMapping("/admin/updateBook")
    public String updateBook(Book book){
        bookService.updateBook(book);

        return "redirect:/admin/queryAllBook";

    }

    @GetMapping("/admin/ToUpdateBook/{bookId}")
    public String updateBook(@PathVariable("bookId") int bookId,Model model){
        Book book = bookService.queryBookById(bookId);

        model.addAttribute("book",book);
        return "book_update";
    }

    @GetMapping("/admin/queryAllBook/{where}/{value}")
    public String queryAllBookByWhere(@PathVariable("where") String where,@PathVariable("value") String value,Model model){
        switch (where){
            case "title":model.addAttribute("books",bookService.queryBookByTitle(value.trim()));break;
            case "author":model.addAttribute("books",bookService.queryBookByAuthor(value.trim()));break;
            case "isbn":model.addAttribute("books",bookService.queryBookByIsbn(value.trim()));break;
            case "publisher":model.addAttribute("books",bookService.queryBookByPublisher(value.trim()));break;
            default:break;
        }
        return "user_index";
    }
    @PostMapping("/admin/insertBook")
    public String insertBook(Book book){
        bookService.insertBook(book);
        return "redirect:/admin/queryAllBook";
    }

    @RequestMapping("/admin/ToInsertBook")
    public String insertBook(){
        return "book_insert";
    }

    @RequestMapping("/admin/queryAllLoan")
    public String queryAllLoan(Model model){
        List<Loan> loans = bookService.queryAllLoanByStatus(0);
        List<LoanAndBookAndUser> userLoans = new ArrayList<>();
        for (Loan loan : loans) {
            userLoans.add(new LoanAndBookAndUser(userService.queryUserById(loan.getUser_id()),loan,bookService.queryBookById(loan.getBook_id())));
        }

        model.addAttribute("userLoans",userLoans);
        return "user_index_2";
    }

    @GetMapping("/admin/updateLoanForSuccess/{id}")
    public String updateLoan(@PathVariable("id") int id){
        Loan loan = bookService.queryLoanById(id);
        loan.setStatus(1);
        bookService.updateLoan(loan);
        return "redirect:/admin/queryAllLoan";
    }

    @GetMapping("/admin/updateLoanForFail/{id}")
    public String deleteLoanById(@PathVariable("id") int id){
        bookService.deleteLoanById(id);
        return "redirect:/admin/queryAllLoan";
    }

    @RequestMapping("/admin/queryAllUser")
    public String queryAllUser(Model model){
        List<User> users = userService.queryAllUser();
        List<LoanAndRoleAndUser> userLoanRoles = new ArrayList<>();
        for (User user : users) {
            userLoanRoles.add(new LoanAndRoleAndUser(userService.queryRoleById(user.getRole_id()),user,bookService.queryAllLoanByUserId(user.getId())));
        }
        model.addAttribute("userLoanRoles",userLoanRoles);
        return "user_loan";
    }

    @GetMapping("/admin/queryAllLoanByUserId/{id}")
    public String queryAllLoanByUserId(@PathVariable("id") int id,Model model){
        List<Loan> loans = bookService.queryAllLoanByUserId(id);
        ArrayList<LoanAndBook> books = new ArrayList<>();
        for (Loan loan : loans) {
            books.add(new LoanAndBook(bookService.queryBookById(loan.getBook_id()),loan));
        }
        model.addAttribute("books",books);
        return "user_book";

    }

    @GetMapping("/admin/deleteLoan/{id}/{userId}")
    public String deleteLoanByBookId(@PathVariable("id") int id,@PathVariable("userId") int userId){
        bookService.deleteLoanByBookId(id);
        return "redirect:/admin/queryAllLoanByUserId/" + userId;
    }

    @RequestMapping("/admin/queryAllBookByNoStatus")
    public String queryAllBookByNoStatus(Model model){
        List<Book> books = bookService.queryAllBookByNoStatus();
        model.addAttribute("books",books);
        return "admin_system_book";
    }

}
