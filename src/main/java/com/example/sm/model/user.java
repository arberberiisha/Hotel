package com.example.sm.model;


import javax.persistence.*;

@Entity
@Table(name ="users")
public class user {

    public user(){}

    public user(String email, String password, String firstName, String lastName, String roli) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roli = roli;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false,length=100)
    private String password;

    @Column(nullable=false,length=25)
    private String firstName;

    @Column(nullable=false,length=25)
    private String lastName;

    @Column(nullable=false,length=25)
    private String roli = "CLIENT";

    public String getRoli() {
        return roli;
    }

    public void setRoli(String roli) {
        this.roli = roli;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
