package com.example.sm.model;


import javax.persistence.*;

@Entity
@Table(name ="dhomat")
public class dhoma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, unique=true)
    private String emertimi;

    @Column(nullable=false,length=10)
    private int nrShtreterve;

    @Column(nullable=false,length=3)
    private int kati;

    @Column(nullable=false,length=25)
    private double cmimi;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmertimi() {
        return emertimi;
    }

    public void setEmertimi(String emertimi) {
        this.emertimi = emertimi;
    }

    public int getNrShtreterve() {
        return nrShtreterve;
    }

    public void setNrShtreterve(int nrShtreterve) {
        this.nrShtreterve = nrShtreterve;
    }

    public int getKati() {
        return kati;
    }

    public void setKati(int kati) {
        this.kati = kati;
    }

    public double getCmimi() {
        return cmimi;
    }

    public void setCmimi(double cmimi) {
        this.cmimi = cmimi;
    }
}
