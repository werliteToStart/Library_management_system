package com.example.service;

import com.example.bean.Book;
import com.example.bean.Loan;
import com.example.bean.User;
import com.example.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;
    public Book queryBookById(int id){
        return bookMapper.queryBookById(id);
    }
    public List<Loan> queryAllLoanByUserId(int user_id){
        return bookMapper.queryAllLoanByUserId(user_id);
    }
    public List<Book> queryAllBookByNoStatus(){
        return bookMapper.queryAllBookByNoStatus();
    }
    public List<Book> queryAllBook(){
        return bookMapper.queryAllBook();
    }
    public List<Book> queryBookByTitle(String title){
        return bookMapper.queryBookByTitle(title);
    }
    public List<Book> queryBookByAuthor(String author){
        return bookMapper.queryBookByAuthor(author);
    }
    public List<Book> queryBookByIsbn(String isbn){
        return bookMapper.queryBookByIsbn(isbn);
    }
    public List<Book> queryBookByPublisher(String publisher){
        return bookMapper.queryBookByPublisher(publisher);
    }


    public List<Book> queryAllBookByNoStatusByTitle(String title){
        return bookMapper.queryAllBookByNoStatusByTitle(title);
    }
    public List<Book> queryAllBookByNoStatusByAuthor(String author){
        return bookMapper.queryAllBookByNoStatusByAuthor(author);
    }
    public List<Book> queryAllBookByNoStatusByIsbn(String isbn){
        return bookMapper.queryAllBookByNoStatusByIsbn(isbn);
    }
    public List<Book> queryAllBookByNoStatusByPublisher(String publisher){
        return bookMapper.queryAllBookByNoStatusByPublisher(publisher);
    }

    public List<Loan> queryAllLoanByStatus(int status){
        return bookMapper.queryAllLoanByStatus(status);
    }
    public Loan queryLoanById(int id){
        return bookMapper.queryLoanById(id);
    }


    /*删除*/
    public int deleteBookById(int id){
        return bookMapper.deleteBookById(id);
    }


    public int deleteLoanByBookId(int bookId){
        return bookMapper.deleteLoanByBookId(bookId);
    }

    public int deleteLoanById(int id){
        return bookMapper.deleteLoanById(id);
    }

    /*修改*/
    public int updateBook(Book book){
        return bookMapper.updateBook(book);
    }

    public int updateLoan(Loan loan){
        return bookMapper.updateLoan(loan);
    }


    /*增加*/
    public int insertBook(Book book){
        return bookMapper.insertBook(book);
    }

    public int insertLoan(Loan loan){
        return bookMapper.insertLoan(loan);
    }
}
