package com.tassenabi.restapp.entity.jpauser;

import com.tassenabi.restapp.data.querygenerator.QueryGeneratorUser;
import com.tassenabi.restapp.entity.User;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity User for the Hibernate/JPA Database Fetch
 */

//TODO Lombok Project Refactoring
@Entity
@TableGenerator(name="sqlite", table="sqlite_sequence",
        pkColumnName="name", valueColumnName="seq",
        pkColumnValue="sqliteTestTable")
@Table(name=QueryGeneratorUser.TABLENAME)
public class UserForJpa extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = QueryGeneratorUser.COLUMN1, unique = true)
    private int id;

    @Column(name = QueryGeneratorUser.COLUMN2, unique = false)
    private String userName;

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }
}