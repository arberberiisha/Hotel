package com.example.sm.model;




import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="rezervimi")
public class rezervimi {


    public rezervimi(){}

    public rezervimi(LocalDate ngaData, LocalDate deriMeDaten, dhoma dhomaID, user userID) {
        this.ngaData = ngaData;
        this.deriMeDaten = deriMeDaten;
        this.dhomaID = dhomaID;
        this.userID = userID;
    }

//    public void UpdateFields(LocalDate nga, LocalDate deri, dhoma dhoma){
//        this.ngaData = nga;
//        this.deriMeDaten = deri;
//        this.dhomaID = dhoma;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable=true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngaData;


    @Column(nullable=true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deriMeDaten;

    @ManyToOne()
    @JoinColumn(name="dhomaId")
    private dhoma dhomaID;

    @ManyToOne()
    @JoinColumn(name="userId")
    private user userID;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getNgaData() {
        return ngaData;
    }

    public void setNgaData(LocalDate ngaData) {
        this.ngaData = ngaData;
    }

    public LocalDate getDeriMeDaten() {
        return deriMeDaten;
    }

    public void setDeriMeDaten(LocalDate deriMeDaten) {
        this.deriMeDaten = deriMeDaten;
    }

    public dhoma getDhomaID() {
        return dhomaID;
    }

    public void setDhomaID(dhoma dhomaID) {
        this.dhomaID = dhomaID;
    }

    public user getUserID() {
        return userID;
    }

    public void setUserID(user userID) {
        this.userID = userID;
    }
}
