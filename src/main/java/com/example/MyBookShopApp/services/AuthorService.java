package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private JdbcTemplate jdbcTemplate;

    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public HashMap<Character,Set<String>> getAuthorsData(){
             List<Author> authors = jdbcTemplate.query("Select * FROM authors", (ResultSet rs, int rowNum)->{
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setName(rs.getString("name"));
            return author;

        });
        HashMap<Character, Set<String>> characters = (HashMap<Character, Set<String>>) authors.stream().collect(Collectors.groupingBy(element->element.getName().toUpperCase().charAt(0)
                ,Collectors.mapping(Author::getName,Collectors.toSet()) ));
       System.out.println(characters);
        return characters;
    }
}
