package com.example.mapper;

import com.example.bean.Book;
import com.example.bean.Loan;
import com.example.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    /*查询*/
    public List<Book> queryAllBook();
    public List<Book> queryAllBookByNoStatus();
    public List<Book> queryBookByTitle(String title);
    public Book queryBookById(int id);
    public List<Book> queryBookByAuthor(String author);
    public List<Book> queryBookByIsbn(String isbn);
    public List<Book> queryBookByPublisher(String publisher);

    public List<Book> queryAllBookByNoStatusByTitle(String title);
    public List<Book> queryAllBookByNoStatusByAuthor(String author);
    public List<Book> queryAllBookByNoStatusByIsbn(String isbn);
    public List<Book> queryAllBookByNoStatusByPublisher(String publisher);
    public List<Loan> queryAllLoanByUserId(int user_id);
    public List<Loan> queryAllLoanByStatus(int status);
    public Loan queryLoanById(int id);


    /*删除*/
    public int deleteBookById(int id);
    public int deleteLoanByBookId(int bookId);
    public int deleteLoanById(int id);

    /*修改*/
    public int updateBook(Book book);

    public int updateLoan(Loan loan);

    /*增加*/
    public int insertBook(Book book);

    public int insertLoan(Loan loan);

}
