package com.in28minutes.database.databasedemo.jdbc;

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJbdcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return jdbcTemplate.query("Select * from person",
                new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("Select * from person where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id=?",
                id);
    }

    public int insert(Person person) {
        return jdbcTemplate.update(
                "INSERT INTO person (id, name, location, birth_date) VALUES" + " (?,?,?,?)",
                person.getId(),
                person.getName(),
                person.getLocation(),
                new Timestamp(person.getBirthDate().getTime()));
    }

    public int update(Person person) {
        return jdbcTemplate.update(
                "update person set " +
                        "name = ?," +
                        " location = ?," +
                        " birth_date= ?" + "" +
                        "where id = ?",
                person.getName(),
                person.getLocation(),
                new Timestamp(person.getBirthDate().getTime()),
                person.getId());
    }
}
