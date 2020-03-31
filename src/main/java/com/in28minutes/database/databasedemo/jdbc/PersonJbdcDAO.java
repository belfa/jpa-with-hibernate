package com.in28minutes.database.databasedemo.jdbc;

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJbdcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //Select * from person
    public List<Person> findAll() {
        return jdbcTemplate.query("Select * from person",
                new BeanPropertyRowMapper(Person.class));
    }
}
