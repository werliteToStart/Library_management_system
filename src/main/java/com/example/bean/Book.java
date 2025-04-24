package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    int id;
    String title;
    String author;
    String isbn;
    String publisher;
    Date publish_date;


}
