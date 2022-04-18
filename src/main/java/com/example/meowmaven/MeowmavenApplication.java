package com.example.meowmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeowmavenApplication {
    public static void main(String[] args) {
        SpringApplication.run(MeowmavenApplication.class, args);
    }
}

/*
SpringBoot is a framework that springs on top of the Spring framework family of modules

Core, Web, AOP Aspect Oriented Programming, Data Access, Integration, Testing

Dependency Injection IoC Container

Do you fulfil the dependency object with a new instantiation? Or do you insert it as a parameter to the construction?


Auto-configuration based on context, e.g. a database

Stand-alone
Chosen way opinionated

Servlet, API object that receives a request and generates a response. MVC business logic response.

Reactive programming is Spring Webflux, web requests


Data access - remember all that repeated JDBC code, connect, query, try, catches, etc, connect, result set? Simplified by Spring to a single line. Equivalent to .NET Entity Framework
Auto-commit false or true, is example of a transaction that must all happen or not at all. all that try commit, exception is rollback, then close
Commit is a single line annotation @Transactional method of SQL queries

Spring Data Module extends Data Access and adds other database types

Testing configurations for example data before prod

Application Context is a glorified HashMap, for plain java objects
 */