package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class AuthorService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Map<String, List<Author>> getAuthorsMap() {
        List<Author> authors = jdbcTemplate.query("Select * FROM authors", (ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setName(rs.getString("name"));
        return author;
        });
        return authors.stream().collect(Collectors.groupingBy((Author a)-> a.getName().substring(0,1)));
    }
}
