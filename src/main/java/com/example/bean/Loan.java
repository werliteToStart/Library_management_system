package com.example.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    int id;
    int user_id;
    int book_id;
    String borrow_date;
    int status;
}
