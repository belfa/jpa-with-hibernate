package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJbdcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Date;


//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJbdcDAO dao;

    public static void main(String[] args) {

        SpringApplication.run(SpringJdbcDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", dao.findAll());
        logger.info("User id 10001-> {}", dao.findById(10001));
        logger.info("Deleting id 10002-> Nº of Rows Deleted - {}", dao.deleteById(10002));
        logger.info("Inserting 10004 -> {}", dao.insert(new Person(10004,"Tara", "Berlin", new Date())));
        logger.info("Updating 10003 -> {}", dao.update(new Person(10003,"Pieter", "Utrecht", new Date())));
        logger.info("All users -> {}", dao.findAll());
    }
}
