package com.tassenabi.restapp.businessEntity.hibernateUser;

import com.tassenabi.restapp.businessEntity.User;

import javax.persistence.*;
import java.io.Serializable;

//TODO Lombok Project Refactoring
@Entity
@Table(name="TBL_USER")
public class UserForHibernate extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_id", unique = true)
    private int id;

    @Column(name = "TXT_userName", unique = false)
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