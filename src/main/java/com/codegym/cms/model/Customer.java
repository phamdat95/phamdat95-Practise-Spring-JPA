package com.codegym.cms.model;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "customer")
@NamedQueries({@NamedQuery(name = "findAll", query = "select c from Customer c"),
        @NamedQuery(name = "findById",query = "select c from Customer c where c.id=:id")})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstname;
    private String lastname;

    public Customer() {
    }

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
